package com.example.meli.projectdriver;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.meli.projectdriver.adapter.SharedPreference;
import com.example.meli.projectdriver.apihelper.ApiClient;
import com.example.meli.projectdriver.apihelper.BaseApiService;
import com.example.meli.projectdriver.model.GetUser;
import com.example.meli.projectdriver.model.User;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Dashboard extends AppCompatActivity {

    SharedPreference sharedPreference;
    Context mContext;
    BaseApiService mApiInterface;
    TextView priceDashboard;
    Double saldo;
    String name,email,noHp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Button btn = (Button) findViewById(R.id.buttonTop);
        CardView card2 = (CardView) findViewById(R.id.card_order);
        CardView card3 = (CardView) findViewById(R.id.card_history);
        TextView text = (TextView)  findViewById(R.id.names);
        CardView card4 = (CardView) findViewById(R.id.card_edit);
        CardView card5 = (CardView) findViewById(R.id.card_logout);
        priceDashboard = (TextView) findViewById(R.id.priceDashboard);
        mContext = this;
        sharedPreference = new SharedPreference(mContext);
        mApiInterface = ApiClient.getClient().create(BaseApiService.class);

        //Intent i = getIntent();
        //String extra_nama = i.getStringExtra("result_nama");
        text.setText("Good Morning "+ sharedPreference.getSPNama());


        Call<GetUser> userCall = mApiInterface.getUser(sharedPreference.getSPId());
        userCall.enqueue(new Callback<GetUser>() {
            @Override
            public void onResponse(Call<GetUser> call, Response<GetUser>
                    response) {
                List<User> userList = response.body().getListDataUser();
                saldo = Double.parseDouble(userList.get(0).getTotalSaldo());
                name = userList.get(0).getNama();
                email = userList.get(0).getEmail();
                noHp = userList.get(0).getNoHp();
                Locale localeID = new Locale("in", "ID");
                NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
                priceDashboard.setText(formatRupiah.format(saldo));
                refresh();
            }

            @Override
            public void onFailure(Call<GetUser> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TopUpActivity.class);
                startActivity(intent);
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SelectDriver.class);
                intent.putExtra("saldo",saldo);
                startActivity(intent);
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HistoryUser.class);
                startActivity(intent);
            }
        });

        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EditUserProfile.class);
                intent.putExtra("name",name);
                intent.putExtra("email",email);
                intent.putExtra("noHp",noHp);
                startActivity(intent);
            }
        });

        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreference.clearSharedPreference(mContext);
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }
    public void refresh(){
        Call<GetUser> userCall = mApiInterface.getUser(sharedPreference.getSPId());
        userCall.enqueue(new Callback<GetUser>() {
            @Override
            public void onResponse(Call<GetUser> call, Response<GetUser>
                    response) {
                List<User> userList = response.body().getListDataUser();
                double saldo = Double.parseDouble(userList.get(0).getTotalSaldo());
                Locale localeID = new Locale("in", "ID");
                NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
                priceDashboard.setText(formatRupiah.format(saldo));
                refresh();
            }

            @Override
            public void onFailure(Call<GetUser> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}
