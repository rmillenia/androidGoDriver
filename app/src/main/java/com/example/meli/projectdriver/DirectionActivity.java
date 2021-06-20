package com.example.meli.projectdriver;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meli.projectdriver.adapter.SharedPreference;
import com.example.meli.projectdriver.adapter.SharedPreferenceDriver;
import com.example.meli.projectdriver.apihelper.ApiClient;
import com.example.meli.projectdriver.apihelper.BaseApiService;
import com.example.meli.projectdriver.model.GetTransaksi;
import com.example.meli.projectdriver.model.PostRating;
import com.example.meli.projectdriver.model.PostRegister;
import com.example.meli.projectdriver.model.PostTransaksi;
import com.example.meli.projectdriver.model.Rating;
import com.example.meli.projectdriver.model.Transaksi;
import com.example.meli.projectdriver.network.ApiServices;
import com.example.meli.projectdriver.network.InitLibrary;
import com.example.meli.projectdriver.response.Distance;
import com.example.meli.projectdriver.response.Duration;
import com.example.meli.projectdriver.response.LegsItem;
import com.example.meli.projectdriver.response.ResponseRoute;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DirectionActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;

    private String API_KEY = "AIzaSyBe9P-itehQgH5BG7ox5vizpv5E1iGLMhg";
    Double latJem,longJem,latTuj,longTuj;


    private LatLng pickUpLatLng; // Jakarta
    private LatLng locationLatLng; // Cirebon
    Button btn;
    SharedPreferenceDriver sharedPreferenceDriver;
    SharedPreference sharedPreference;
    BaseApiService mApiInterface;
    String formattedDate;
    Context mContext;
    Intent i;
    String driver;
    ProgressDialog loading;

    private TextView tvStartAddress, tvEndAddress, tvDuration, tvDistance, tvPrice;
    String namaDriver;
    double price, saldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direction);
        // Maps
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        i = getIntent();
        latJem = i.getDoubleExtra("latJem",0);
        longJem = i.getDoubleExtra("longJem",0);
        latTuj = i.getDoubleExtra("latTuj",0);
        longTuj = i.getDoubleExtra("longTuj",0);
        driver = i.getStringExtra("idDriver");
        namaDriver = i.getStringExtra("namaDriver");
        price = i.getDoubleExtra("price",0);
        saldo = i.getDoubleExtra("saldo",0);
        mContext = this;
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        formattedDate = df.format(c.getTime());
        pickUpLatLng = new LatLng(latJem, longJem); // Jakarta
        locationLatLng = new LatLng(latTuj,longTuj); // Cirebon
        mApiInterface = ApiClient.getClient().create(BaseApiService.class);
        // Set Title bar
        //getSupportActionBar().setTitle("Direction Maps API");
        // Inisialisasi Widget
        widgetInit();
        // jalankan method
        actionRoute();

        Call<GetTransaksi> transaksiCall = mApiInterface.getTransaksi(driver, String.valueOf(sharedPreference.getSPId()));
        transaksiCall.enqueue(new Callback<GetTransaksi>() {
            @Override
            public void onResponse(Call<GetTransaksi> call, Response<GetTransaksi>
                    response) {
                List<Transaksi> transaksiList = response.body().getListDataTransaksi();
                if (transaksiList.get(0).getStatus().equalsIgnoreCase("selesai")) {
                    Intent intent = new Intent(getApplicationContext(), RatingActivity.class);
                    intent.putExtra("driver", driver);
                    intent.putExtra("namaDriver",namaDriver);
                    intent.putExtra("price", price);
                    intent.putExtra("saldo", saldo);
                    intent.putExtra("idTrans", transaksiList.get(0).getIdTransaksi());
                    startActivity(intent);
                } else {
                    refresh();
                }

//                                           }
                //mAdapter = new UserListAdapter(requestList);
                //mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetTransaksi> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

    private void widgetInit() {
        tvStartAddress = findViewById(R.id.tvStartAddress);
        tvEndAddress = findViewById(R.id.tvEndAddress);
        tvDuration = findViewById(R.id.tvDuration);
        tvDistance = findViewById(R.id.tvDistance);
        tvPrice = findViewById(R.id.tvPrice);
        btn = (Button) findViewById(R.id.btnFinish);
        sharedPreferenceDriver = new SharedPreferenceDriver(this);
        sharedPreference = new SharedPreference(this);
        if (sharedPreference.getSPLevel().equalsIgnoreCase("customer")||sharedPreferenceDriver.getSPLevel().equalsIgnoreCase("customer")){
            btn.setEnabled(false);
            btn.setBackgroundColor(Color.GRAY);
        }
    }

    private void actionRoute() {
        String lokasiAwal = pickUpLatLng.latitude + "," + pickUpLatLng.longitude;
        String lokasiAkhir = locationLatLng.latitude + "," + locationLatLng.longitude;

        // Panggil Retrofit
        ApiServices api = InitLibrary.getInstance();
        // Siapkan request
        Call<ResponseRoute> routeRequest = api.request_route(lokasiAwal, lokasiAkhir, API_KEY);
        // kirim request
        routeRequest.enqueue(new Callback<ResponseRoute>() {
            @Override
            public void onResponse(Call<ResponseRoute> call, Response<ResponseRoute> response) {

                if (response.isSuccessful()){                    // tampung response ke variable
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

                    // Tambah Marker
                    mMap.addMarker(new MarkerOptions().position(pickUpLatLng).title("Lokasi Awal"));
                    mMap.addMarker(new MarkerOptions().position(locationLatLng).title("Lokasi Akhir"));
                    // Dapatkan jarak dan waktu
                    Distance dataDistance = dataLegs.getDistance();
                    Duration dataDuration = dataLegs.getDuration();

                    // Set Nilai Ke Widget
                    tvStartAddress.setText("" + dataLegs.getStartAddress().toString());
                    tvEndAddress.setText("" + dataLegs.getEndAddress().toString());

                    tvDistance.setText("" + dataDistance.getText());
                    tvDuration.setText("" + dataDuration.getText());
                    Locale localeID = new Locale("in", "ID");
                    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
                    tvPrice.setText(formatRupiah.format(price));
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


                }
            }

            @Override
            public void onFailure(Call<ResponseRoute> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }

    public void refresh(){
        Call<GetTransaksi> transaksiCall = mApiInterface.getTransaksi(driver, String.valueOf(sharedPreference.getSPId()));
        transaksiCall.enqueue(new Callback<GetTransaksi>() {
            @Override
            public void onResponse(Call<GetTransaksi> call, Response<GetTransaksi>
                    response) {
                List<Transaksi> transaksiList = response.body().getListDataTransaksi();
                if (transaksiList.get(0).getStatus().equalsIgnoreCase("selesai")) {
                    Intent intent = new Intent(getApplicationContext(), RatingActivity.class);
                    intent.putExtra("driver", driver);
                    intent.putExtra("namaDriver",namaDriver);
                    intent.putExtra("idTrans", transaksiList.get(0).getIdTransaksi());
                    intent.putExtra("price", price);
                    intent.putExtra("saldo", saldo);
                    startActivity(intent);
                } else {
                    refresh();
                }

//                                           }
                //mAdapter = new UserListAdapter(requestList);
                //mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetTransaksi> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}
