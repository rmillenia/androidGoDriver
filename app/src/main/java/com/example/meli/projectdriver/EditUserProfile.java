package com.example.meli.projectdriver;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meli.projectdriver.adapter.SharedPreference;
import com.example.meli.projectdriver.apihelper.ApiClient;
import com.example.meli.projectdriver.apihelper.BaseApiService;
import com.example.meli.projectdriver.model.GetUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditUserProfile extends AppCompatActivity {

    SharedPreference sharedPreference;
    Context mContext;
    BaseApiService mApiInterface;
    TextView name,email,noHp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_profile);

        Button btn = (Button) findViewById(R.id.btn_update);
        name = (TextView)  findViewById(R.id.input_name);
        email = (TextView) findViewById(R.id.input_email);
        noHp = (TextView) findViewById(R.id.input_nohp);
        mContext = this;
        sharedPreference = new SharedPreference(mContext);
        mApiInterface = ApiClient.getClient().create(BaseApiService.class);

        Intent i = getIntent();
        name.setText(i.getStringExtra("name"));
        email.setText(i.getStringExtra("email"));
        noHp.setText( i.getStringExtra("noHp"));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<GetUser> updateProfileCall = mApiInterface.updateProfile(sharedPreference.getSPId(),name.getText().toString(),noHp.getText().toString(),email.getText().toString());
                updateProfileCall.enqueue(new Callback<GetUser>() {
                    @Override
                    public void onResponse(Call<GetUser> call, Response<GetUser> response) {
                        Toast.makeText(getApplicationContext(), "update berhasil", Toast.LENGTH_LONG).show();
                        sharedPreference.saveSPString(SharedPreference.SP_NAMA,name.getText().toString());
                        sharedPreference.saveSPString(SharedPreference.SP_EMAIL,email.getText().toString());
                        Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<GetUser> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
