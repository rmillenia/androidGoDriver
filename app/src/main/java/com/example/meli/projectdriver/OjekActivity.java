package com.example.meli.projectdriver;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meli.projectdriver.adapter.SharedPreference;
import com.example.meli.projectdriver.adapter.UserListAdapter;
import com.example.meli.projectdriver.apihelper.ApiClient;
import com.example.meli.projectdriver.apihelper.BaseApiService;
import com.example.meli.projectdriver.model.GetRequest;
import com.example.meli.projectdriver.model.PostRegister;
import com.example.meli.projectdriver.model.PostRequest;
import com.example.meli.projectdriver.model.PostTransaksi;
import com.example.meli.projectdriver.model.RequestUser;
import com.example.meli.projectdriver.network.ApiServices;
import com.example.meli.projectdriver.network.InitLibrary;
import com.example.meli.projectdriver.response.Distance;
import com.example.meli.projectdriver.response.Duration;
import com.example.meli.projectdriver.response.LegsItem;
import com.example.meli.projectdriver.response.ResponseRoute;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OjekActivity extends AppCompatActivity implements OnMapReadyCallback,GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener {
    private GoogleMap mMap;
    ProgressDialog loading;
    SharedPreference sharedPreference;

    private String API_KEY = "AIzaSyBe9P-itehQgH5BG7ox5vizpv5E1iGLMhg";

    public LatLng pickUpLatLng = null;
    public LatLng locationLatLng = null;

    private TextView tvStartAddress, tvEndAddress;
    private TextView tvPrice, tvDistance;
    private Button btnNext;
    private LinearLayout infoPanel;
    // Deklarasi variable
    private TextView tvPickUpFrom, tvDestLocation, toolbar;
    Context mContext;
    BaseApiService mApiInterface;

    public static final int PICK_UP = 0;
    public static final int DEST_LOC = 1;
    private static int REQUEST_CODE = 0;

    String idDriver,formattedDate;
    public Double priceTotal = null;
    Double saldo;
    String namaDriver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ojek);
        //getSupportActionBar().setTitle("Ojek Hampir Online");
        // Inisialisasi Widget
        mApiInterface = ApiClient.getClient().create(BaseApiService.class);
        wigetInit();
        sharedPreference = new SharedPreference(this);
        Intent i = getIntent();
        idDriver = i.getStringExtra("id_extra");
        namaDriver = i.getStringExtra("Nama");
        saldo = i.getDoubleExtra("saldo",0);
        mContext = this;
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        formattedDate = df.format(c.getTime());
        infoPanel.setVisibility(View.GONE);
        // Event OnClick
        tvPickUpFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Jalankan Method untuk menampilkan Place Auto Complete
                // Bawa constant PICK_UP
                showPlaceAutoComplete(PICK_UP);
            }
        });
        // Event OnClick
        tvDestLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Jalankan Method untuk menampilkan Place Auto Complete
                // Bawa constant DEST_LOC
                showPlaceAutoComplete(DEST_LOC);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           // Jalankan Method untuk menampilkan Place Auto Complete
                                           // Bawa constant DEST_LOC
                                           loading = ProgressDialog.show(mContext, null, "Harap menunggu untuk konfirmasi driver", true, false);
//                String lokLat = ""+locationLatLng.latitude;
//                String lokLong = ""+locationLatLng.longitude;
                                           Call<PostRequest> postRequestCall = mApiInterface.postRequest(Integer.valueOf(idDriver), sharedPreference.getSPId(), tvDestLocation.getText().toString(), locationLatLng.latitude, locationLatLng.longitude, "belum diterima");
                                           postRequestCall.enqueue(new Callback<PostRequest>() {
                                               @Override
                                               public void onResponse(Call<PostRequest> call, final Response<PostRequest> response) {
                                                   //Toast.makeText(getApplicationContext(), "Request Success", Toast.LENGTH_LONG).show();
                                                   Call<GetRequest> requestCall = mApiInterface.getRequestDone(idDriver,Integer.toString(sharedPreference.getSPId()));
                                                   requestCall.enqueue(new Callback<GetRequest>() {
                                                       @Override
                                                       public void onResponse(Call<GetRequest> call, Response<GetRequest>
                                                               response) {
                                                           List<RequestUser> requestList = response.body().getListDataRequestUser();
                                                           Log.d("Retrofit Get", "Jumlah data Driver: " +
                                                                   String.valueOf(requestList.size()));

                                                           if (requestList.get(0).getStatus().equalsIgnoreCase("diterima")){
                                                               loading.dismiss();
                                                               Call<PostTransaksi> postTransaksiCall = mApiInterface.postTransaksi(sharedPreference.getSPId(),Integer.valueOf(idDriver),formattedDate, null,priceTotal,pickUpLatLng.latitude,pickUpLatLng.longitude,tvPickUpFrom.getText().toString(),locationLatLng.latitude,locationLatLng.longitude,tvDestLocation.getText().toString(),"baru");
                                                               postTransaksiCall.enqueue(new Callback<PostTransaksi>() {
                                                                   @Override
                                                                   public void onResponse(Call<PostTransaksi> call, Response<PostTransaksi> response) {
                                                                       Toast.makeText(getApplicationContext(), "Sukses", Toast.LENGTH_LONG).show();
                                                                       Intent i = new Intent(getApplicationContext(),DirectionActivity.class);
                                                                       i.putExtra("idDriver",idDriver);
                                                                       i.putExtra("namaDriver",namaDriver);
                                                                       i.putExtra("price",priceTotal);
                                                                       i.putExtra("saldo",saldo);
                                                                       i.putExtra("latJem",pickUpLatLng.latitude);
                                                                       i.putExtra("longJem",pickUpLatLng.longitude);
                                                                       i.putExtra("latTuj",locationLatLng.latitude);
                                                                       i.putExtra("longTuj",locationLatLng.longitude);
                                                                       startActivity(i);
                                                                   }

                                                                   @Override
                                                                   public void onFailure(Call<PostTransaksi> call, Throwable t) {
                                                                       Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                                                                   }
                                                               });
                                                           }
                                                           else if (requestList.get(0).getStatus().equalsIgnoreCase("ditolak")){
                                                               loading.dismiss();
                                                               Toast.makeText(getApplicationContext(), "Request rejected", Toast.LENGTH_LONG).show();
                                                           }else{
                                                               refresh();
                                                           }
                                                           //mAdapter = new UserListAdapter(requestList);
                                                           //mRecyclerView.setAdapter(mAdapter);
                                                       }

                                                       @Override
                                                       public void onFailure(Call<GetRequest> call, Throwable t) {
                                                           Log.e("Retrofit Get", t.toString());
                                                       }
                                                   });
                                               }

                                               @Override
                                               public void onFailure(Call<PostRequest> call, Throwable t) {

                                               }
                                           });
                                       }
                                   });
    }


    // Method untuk Inisilisasi Widget agar lebih rapih
    private void wigetInit() {
        // Maps
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        infoPanel = findViewById(R.id.infoPanel);
        // Widget
        tvPickUpFrom = findViewById(R.id.tvPickUpFrom);
        tvDestLocation = findViewById(R.id.tvDestLocation);
        toolbar = findViewById(R.id.tv_title);
        toolbar.setText("MoSam Trash Location");
        tvPrice = findViewById(R.id.tvPrice);
        tvDistance = findViewById(R.id.tvDistance);
        btnNext = findViewById(R.id.btnNext);
    }

    // Method menampilkan input Place Auto Complete
    private void showPlaceAutoComplete(int typeLocation) {
        // isi RESUT_CODE tergantung tipe lokasi yg dipilih.
        // titik jmput atau tujuan
        REQUEST_CODE = typeLocation;

        // Filter hanya tmpat yg ada di Indonesia
        AutocompleteFilter typeFilter = new AutocompleteFilter.Builder().setCountry("ID").build();
        try {
            // Intent untuk mengirim Implisit Intent
            Intent mIntent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_OVERLAY)
                    .setFilter(typeFilter)
                    .build(this);
            // jalankan intent impilist
            startActivityForResult(mIntent, REQUEST_CODE);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace(); // cetak error
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace(); // cetak error
            // Display Toast
            Toast.makeText(this, "Layanan Play Services Tidak Tersedia", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Toast.makeText(this, "Sini Gaes", Toast.LENGTH_SHORT).show();
        // Pastikan Resultnya OK
        if (resultCode == RESULT_OK) {
            //Toast.makeText(this, "Sini Gaes2", Toast.LENGTH_SHORT).show();
            // Tampung Data tempat ke variable
            Place placeData = PlaceAutocomplete.getPlace(this, data);

            if (placeData.isDataValid()) {
                // Show in Log Cat
                Log.d("autoCompletePlace Data", placeData.toString());

                // Dapatkan Detail
                String placeAddress = placeData.getAddress().toString();
                LatLng placeLatLng = placeData.getLatLng();
                String placeName = placeData.getName().toString();

                // Cek user milih titik jemput atau titik tujuan
                switch (REQUEST_CODE) {
                    case PICK_UP:
                        // Set ke widget lokasi asal
                        tvPickUpFrom.setText(placeAddress);
                        pickUpLatLng = placeData.getLatLng();
                        break;
                    case DEST_LOC:
                        // Set ke widget lokasi tujuan
                        tvDestLocation.setText(placeAddress);
                        locationLatLng = placeData.getLatLng();
                        break;
                }
                // Jalankan Action Route
                if (pickUpLatLng != null && locationLatLng != null) {
                    actionRoute(placeLatLng, REQUEST_CODE);
                }

            } else {
                // Data tempat tidak valid
                Toast.makeText(this, "Invalid Place !", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setPadding(10, 180, 10, 10);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        mMap.setMyLocationEnabled(true);
        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.getUiSettings().setRotateGesturesEnabled(false);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        LatLng sydney = new LatLng(-33.852, 151.211);
        MarkerOptions marker = new MarkerOptions()
                .position(sydney)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.logo))
                .title("lokasi driver");
        googleMap.addMarker(marker);
    }

    private void actionRoute(LatLng placeLatLng, int requestCode) {
        String lokasiAwal = pickUpLatLng.latitude + "," + pickUpLatLng.longitude;
        String lokasiAkhir = locationLatLng.latitude + "," + locationLatLng.longitude;

        // Clear dulu Map nya
        mMap.clear();
        // Panggil Retrofit
        ApiServices api = InitLibrary.getInstance();
        // Siapkan request
        Call<ResponseRoute> routeRequest = api.request_route(lokasiAwal, lokasiAkhir, API_KEY);
        // kirim request
        routeRequest.enqueue(new Callback<ResponseRoute>() {
            @Override
            public void onResponse(Call<ResponseRoute> call, Response<ResponseRoute> response) {

                if (response.isSuccessful()){
                    // tampung response ke variable
                    ResponseRoute dataDirection = response.body();

                    LegsItem dataLegs = dataDirection.getRoutes().get(0).getLegs().get(0);

                    // Dapatkan garis polyline
                    String polylinePoint = dataDirection.getRoutes().get(0).getOverviewPolyline().getPoints();
                    // Decode
                    List<LatLng> decodePath = PolyUtil.decode(polylinePoint);
                    // Gambar garis ke maps
                    mMap.addPolyline(new PolylineOptions().addAll(decodePath)
                            .width(8f).color(Color.argb(255, 56, 167, 252)))
                            .setGeodesic(true);

                    //LatLng pickUp = new LatLng(112.601040,-7.927569);
                    // Tambah Marker
                    mMap.addMarker(new MarkerOptions().position(pickUpLatLng).title("Lokasi Awal"));
                    mMap.addMarker(new MarkerOptions().position(locationLatLng).title("Lokasi Akhir"));
                    //mMap.addMarker(new MarkerOptions().position(pickUp).title("Lokasi Driver"));
                    // Dapatkan jarak dan waktu
                    Distance dataDistance = dataLegs.getDistance();
                    Duration dataDuration = dataLegs.getDuration();

                    // Set Nilai Ke Widget
                    double price_per_meter = 5;
                    priceTotal = dataDistance.getValue() * price_per_meter; // Jarak * harga permeter
                    Locale localeID = new Locale("in", "ID");
                    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
                    tvDistance.setText(dataDistance.getText());
                    tvPrice.setText(formatRupiah.format(priceTotal));
                    /** START
                     * Logic untuk membuat layar berada ditengah2 dua koordinat
                     */

                    LatLngBounds.Builder latLongBuilder = new LatLngBounds.Builder();
                    latLongBuilder.include(pickUpLatLng);
                    latLongBuilder.include(locationLatLng);

                    // Bounds Coordinata
                    LatLngBounds bounds = latLongBuilder.build();

                    int width = getResources().getDisplayMetrics().widthPixels;
                    int height = getResources().getDisplayMetrics().heightPixels;
                    int paddingMap = (int) (width * 0.2); //jarak dari
                    CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, width, height, paddingMap);
                    mMap.animateCamera(cu);

                    /** END
                     * Logic untuk membuat layar berada ditengah2 dua koordinat
                     */
                    // Tampilkan info panel
                    infoPanel.setVisibility(View.VISIBLE);

                    mMap.setPadding(10, 180, 10, 180);

                }
            }

            @Override
            public void onFailure(Call<ResponseRoute> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this, "Current location:\n" + location, Toast.LENGTH_LONG).show();
        pickUpLatLng = new LatLng(location.getLatitude(),location.getLongitude());
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        double lat = location.getLatitude();
        double longs = location.getLongitude();
        List<Address> addresses = null;
        try {
            addresses = geocoder.getFromLocation(lat,longs,1);
            String add = addresses.get(0).getAddressLine(0);
            tvPickUpFrom.setText(add);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void refresh() {
        Call<GetRequest> requestCall = mApiInterface.getRequestDone(idDriver,Integer.toString(sharedPreference.getSPId()));
        requestCall.enqueue(new Callback<GetRequest>() {
            @Override
            public void onResponse(Call<GetRequest> call, Response<GetRequest>
                    response) {
                List<RequestUser> requestList = response.body().getListDataRequestUser();
                Log.d("Retrofit Get", "Jumlah data Driver: " +
                        String.valueOf(requestList.size()));

                if (requestList.get(0).getStatus().equalsIgnoreCase("diterima")){
                    loading.dismiss();
                    Call<PostTransaksi> postTransaksiCall = mApiInterface.postTransaksi(sharedPreference.getSPId(),Integer.valueOf(idDriver),formattedDate, null,priceTotal,pickUpLatLng.latitude,pickUpLatLng.longitude,tvPickUpFrom.getText().toString(),locationLatLng.latitude,locationLatLng.longitude,tvDestLocation.getText().toString(),"baru");
                    postTransaksiCall.enqueue(new Callback<PostTransaksi>() {
                        @Override
                        public void onResponse(Call<PostTransaksi> call, Response<PostTransaksi> response) {
                            Intent i = new Intent(getApplicationContext(),DirectionActivity.class);
                            Toast.makeText(getApplicationContext(), "Sukses", Toast.LENGTH_LONG).show();
                            i.putExtra("idDriver",idDriver);
                            i.putExtra("namaDriver",namaDriver);
                            i.putExtra("price",priceTotal);
                            i.putExtra("saldo",saldo);
                            i.putExtra("latJem",pickUpLatLng.latitude);
                            i.putExtra("longJem",pickUpLatLng.longitude);
                            i.putExtra("latTuj",locationLatLng.latitude);
                            i.putExtra("longTuj",locationLatLng.longitude);
                            startActivity(i);
                        }

                        @Override
                        public void onFailure(Call<PostTransaksi> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        }
                    });
                }
                else if (requestList.get(0).getStatus().equalsIgnoreCase("ditolak")){
                    loading.dismiss();
                    Toast.makeText(getApplicationContext(), "Request rejected", Toast.LENGTH_LONG).show();
                }else{
                    refresh();
                }
                //mAdapter = new UserListAdapter(requestList);
                //mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetRequest> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}
