package com.example.meli.projectdriver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.meli.projectdriver.apihelper.ApiClient;
import com.example.meli.projectdriver.apihelper.BaseApiService;
import com.example.meli.projectdriver.model.PostRegister;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

        EditText nik,fullname,username,password,email,noHp;
        Button signUpBtn;
        BaseApiService mApiInterface;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.signup_layout);
            fullname = (EditText) findViewById(R.id.fullname);
            username = (EditText) findViewById(R.id.username);
            //nik = (EditText) findViewById(R.id.nik);
            password = (EditText) findViewById(R.id.password);
            email = (EditText) findViewById(R.id.email);
            noHp = (EditText) findViewById(R.id.noHp);
            mApiInterface = ApiClient.getClient().create(BaseApiService.class);
            signUpBtn = (Button) findViewById(R.id.signUpBtn);
            signUpBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Call<PostRegister> postRegisterCall = mApiInterface.postRegister(nik.getText().toString(), fullname.getText().toString(),noHp.getText().toString(), "customer",email.getText().toString(), username.getText().toString(),  password.getText().toString());
                    postRegisterCall.enqueue(new Callback<PostRegister>() {
                        @Override
                        public void onResponse(Call<PostRegister> call, Response<PostRegister> response) {
                            Toast.makeText(getApplicationContext(), "Register Sukses", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(i);
                        }

                        @Override
                        public void onFailure(Call<PostRegister> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            });
        }
    }

