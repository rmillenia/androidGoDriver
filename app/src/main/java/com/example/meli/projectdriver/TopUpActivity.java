package com.example.meli.projectdriver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.meli.projectdriver.adapter.SharedPreference;
import com.example.meli.projectdriver.apihelper.ApiClient;
import com.example.meli.projectdriver.apihelper.BaseApiService;
import com.example.meli.projectdriver.model.PostSaldo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopUpActivity extends AppCompatActivity {

    EditText rekening,nominal;
    Button request;
    BaseApiService mApiInterface;
    SharedPreference sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);
        rekening = (EditText) findViewById(R.id.input_number);
        nominal = (EditText) findViewById(R.id.input_nominal);
        mApiInterface = ApiClient.getClient().create(BaseApiService.class);
        request = (Button) findViewById(R.id.btn_request);
        sharedPreference = new SharedPreference(this);
        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostSaldo> postSaldoCall = mApiInterface.postSaldo(sharedPreference.getSPId(),Double.valueOf(nominal.getText().toString()),rekening.getText().toString(), "proses");
                postSaldoCall.enqueue(new Callback<PostSaldo>() {
                    @Override
                    public void onResponse(Call<PostSaldo> call, Response<PostSaldo> response) {
                        Toast.makeText(getApplicationContext(), "Harap menunggu konfirmasi administrator", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<PostSaldo> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
