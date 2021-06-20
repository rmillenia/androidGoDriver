package com.example.meli.projectdriver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meli.projectdriver.adapter.SharedPreference;
import com.example.meli.projectdriver.apihelper.ApiClient;
import com.example.meli.projectdriver.apihelper.BaseApiService;
import com.example.meli.projectdriver.model.GetUser;
import com.example.meli.projectdriver.model.PostRating;
import com.example.meli.projectdriver.model.PostRegister;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RatingActivity extends AppCompatActivity {

    Button btn1;
    RatingBar ratingBar;
    BaseApiService mApiInterface;
    TextView txt;
    SharedPreference sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        btn1 = (Button) findViewById(R.id.btnSubmit);
        txt = (TextView) findViewById(R.id.driver_name);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        mApiInterface = ApiClient.getClient().create(BaseApiService.class);
        sharedPreference = new SharedPreference(this);
        final Intent i = getIntent();
        txt.setText(""+i.getStringExtra("namaDriver"));

        double saldoEpay = i.getDoubleExtra("saldo",0) - i.getDoubleExtra("price",0);
        Call<GetUser> updateSaldoCall = mApiInterface.updateSaldo(sharedPreference.getSPId(),saldoEpay);
        updateSaldoCall.enqueue(new Callback<GetUser>() {
            @Override
            public void onResponse(Call<GetUser> call, Response<GetUser> response) {
            }

            @Override
            public void onFailure(Call<GetUser> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
            }
        });



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<PostRating> postRatingCall = mApiInterface.postRating(ratingBar.getRating(),Integer.valueOf(i.getStringExtra("idTrans")));
                postRatingCall.enqueue(new Callback<PostRating>() {
                    @Override
                    public void onResponse(Call<PostRating> call, Response<PostRating> response) {
                        Toast.makeText(getApplicationContext(), "Selesai", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(),Dashboard.class);
                        startActivity(i);
                    }

                    @Override
                    public void onFailure(Call<PostRating> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }
}
