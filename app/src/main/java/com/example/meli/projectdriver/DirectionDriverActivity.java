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
import com.example.meli.projectdriver.model.GetUser;
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

public class DirectionDriverActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;

    private String API_KEY = "AIzaSyBe9P-itehQgH5BG7ox5vizpv5E1iGLMhg";
    Double latJem,longJem,latTuj,longTuj,price;


    private LatLng pickUpLatLng; // Jakarta
    private LatLng locationLatLng; // Cirebon
    Button btn;
    SharedPreferenceDriver sharedPreferenceDriver;
    SharedPreference sharedPreference;
    BaseApiService mApiInterface;
    String formattedDate;
    Context mContext;
    Intent i;
    ProgressDialog loading;

    private TextView tvStartAddress, tvEndAddress, tvDuration, tvDistance, tvPrice;
    double saldoEpay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direction_driver);
        // Maps
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map1);
        mapFragment.getMapAsync(this);
        i = getIntent();
        latJem = i.getDoubleExtra("latJem",0);
        longJem = i.getDoubleExtra("longJem",0);
        latTuj = i.getDoubleExtra("latTuj",0);
        longTuj = i.getDoubleExtra("longTuj",0);
        price = i.getDoubleExtra("price",0);
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

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Call<PostTransaksi> putTransaksiCall = mApiInterface.putTransaksi(String.valueOf(sharedPreferenceDriver.getSPId()),i.getStringExtra("idTrans"),formattedDate);
                    putTransaksiCall.enqueue(new Callback<PostTransaksi>() {
                        @Override
                        public void onResponse(Call<PostTransaksi> call, Response<PostTransaksi> response) {
                            saldoEpay = i.getDoubleExtra("saldo",0) + i.getDoubleExtra("price",0);
                            Call<GetUser> updateSaldoCall = mApiInterface.updateSaldo(sharedPreferenceDriver.getSPId(),saldoEpay);
                            updateSaldoCall.enqueue(new Callback<GetUser>() {
                                @Override
                                public void onResponse(Call<GetUser> call, Response<GetUser> response) {

                                }

                                @Override
                                public void onFailure(Call<GetUser> call, Throwable t) {
                                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                                }
                            });

                            Toast.makeText(getApplicationContext(), "Selesai", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(getApplicationContext(), DashboardDriver.class);
                            startActivity(i);
                        }
                        @Override
                        public void onFailure(Call<PostTransaksi> call, Throwable t) {
                            Log.e("Retrofit Get", t.toString());
                        }
                    });
                }
            });;
        }

    private void widgetInit() {
        tvStartAddress = findViewById(R.id.tvStartAddress1);
        tvEndAddress = findViewById(R.id.tvEndAddress1);
        tvDuration = findViewById(R.id.tvDuration1);
        tvDistance = findViewById(R.id.tvDistance1);
        tvPrice = findViewById(R.id.tvPrice1);
        btn = (Button) findViewById(R.id.btnFinish1);
        sharedPreferenceDriver = new SharedPreferenceDriver(this);
        sharedPreference = new SharedPreference(this);
        if (sharedPreference.getSPLevel().equalsIgnoreCase("customer")||sharedPreferenceDriver.getSPLevel().equalsIgnoreCase("customer")){
            btn.setEnabled(false);
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


//    public void refresh(){
//                Call<PostRating> getRatingCall = mApiInterface.getRating(i.getStringExtra("idTrans"));
//                getRatingCall.enqueue(new Callback<PostRating>() {
//                    @Override
//                    public void onResponse(Call<PostRating> call, Response<PostRating> response) {
//                        if (response != null && response.isSuccessful()) {
//                            List<Rating> ratingList = response.body().getResult();
//                            loading.dismiss();
//                            Toast.makeText(getApplicationContext(), "Selesai", Toast.LENGTH_LONG).show();
//                            Intent i = new Intent(getApplicationContext(), RatingDriver.class);
//                            startActivity(i);
//                        }else if (response != null && !response.isSuccessful() && response.errorBody() != null) {
//                            refresh();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<PostRating> call, Throwable t) {
//                        t.printStackTrace();
//                    }
//                });
//            }
    }
