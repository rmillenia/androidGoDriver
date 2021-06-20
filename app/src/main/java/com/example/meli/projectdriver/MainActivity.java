package com.example.meli.projectdriver;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meli.projectdriver.adapter.SharedPreference;
import com.example.meli.projectdriver.adapter.SharedPreferenceDriver;
import com.example.meli.projectdriver.apihelper.ApiClient;
import com.example.meli.projectdriver.apihelper.BaseApiService;
import com.example.meli.projectdriver.apihelper.UtilsApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    Button buttonLogin;
    //SessionManagement sessionManagement;
    TextView signUp;
    BaseApiService mApiInterface;
    //ArrayList<GetLogin> list;
    ProgressDialog loading;
    Context mContext;
    SharedPreference sharedPreference;
    SharedPreferenceDriver sharedPreferenceDriver;
 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
//        dbHelper = new DataHelper(this);
        edtUsername = findViewById(R.id.loginUsername);
        edtPassword = findViewById(R.id.login_password);
        buttonLogin = findViewById(R.id.loginBtn);
        //mApiInterface = ApiClient.getClient().create(BaseApiService.class);
        signUp = findViewById(R.id.createAccount);
        mApiInterface = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper
        mContext = this;
        sharedPreference = new SharedPreference(this);
        sharedPreferenceDriver = new SharedPreferenceDriver(this);
        //sharedPreference.clearSharedPreference(this);
//        initCreateAccountTextView();
//        initViews();

            buttonLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loading = ProgressDialog.show(mContext, null, "Harap Tunggu", true, false);
                    requestLogin();
                }
            });

        // Code berikut berfungsi untuk mengecek session, Jika session true ( sudah login )
        // maka langsung memulai Dashboard.
        if (sharedPreference.getSPSudahLogin()&& sharedPreference.getSPLevel().equalsIgnoreCase("customer")){
            //sharedPreference.saveSPString(SharedPreference.SP_LEVEL, "customer");
          Intent i = new Intent(getApplicationContext(),Dashboard.class);
          startActivity(i);
        }else if(sharedPreferenceDriver.getSPSudahLogin()&& sharedPreferenceDriver.getSPLevel().equalsIgnoreCase("driver")){
            Intent i = new Intent(getApplicationContext(),DashboardDriver.class);
            startActivity(i);
        }

    }



    private void requestLogin(){
        mApiInterface.getLogin(edtUsername.getText().toString(), edtPassword.getText().toString())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            loading.dismiss();
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                if (jsonRESULTS.getString("error").equals("false")){
                                    // Jika login berhasil maka data nama yang ada di response API
                                    // akan diparsing ke activity selanjutnya.
                                    int id = jsonRESULTS.getJSONObject("user").getInt("id");
                                    String nama = jsonRESULTS.getJSONObject("user").getString("nama");
                                    String username = jsonRESULTS.getJSONObject("user").getString("username");
                                    String level = jsonRESULTS.getJSONObject("user").getString("level");
                                    if (level.equalsIgnoreCase("customer")){
                                        Toast.makeText(getApplicationContext(), "BERHASIL LOGIN", Toast.LENGTH_SHORT).show();
                                        Intent i = new Intent(getApplicationContext(), Dashboard.class);
                                        sharedPreference.saveSPInt(SharedPreference.SP_ID, id);
                                        sharedPreference.saveSPString(SharedPreference.SP_NAMA, nama);
                                        sharedPreference.saveSPString(SharedPreference.SP_LEVEL, level);
                                        sharedPreference.saveSPBoolean(SharedPreference.SP_SUDAH_LOGIN, true);
                                        //i.putExtra("result_level", level);
                                        startActivity(i);
                                    }else if(level.equalsIgnoreCase("driver")){
                                        Toast.makeText(getApplicationContext(), "BERHASIL LOGIN", Toast.LENGTH_SHORT).show();
                                        Intent ints = new Intent(getApplicationContext(), DashboardDriver.class);
                                        sharedPreferenceDriver.saveSPInt(SharedPreference.SP_ID, id);
                                        sharedPreferenceDriver.saveSPString(SharedPreference.SP_NAMA, nama);
                                        sharedPreferenceDriver.saveSPString(SharedPreference.SP_LEVEL, level);
                                        sharedPreferenceDriver.saveSPBoolean(SharedPreference.SP_SUDAH_LOGIN, true);
                                        startActivity(ints);
                                    }else{
                                        Toast.makeText(mContext, "Anda tidak bisa login", Toast.LENGTH_SHORT).show();
                                    }

                                } else {
                                    // Jika login gagal
                                    String error_message = jsonRESULTS.getString("error_msg");
                                    Toast.makeText(getApplicationContext(), error_message, Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
//                        Log.e("debug", "onFailure: ERROR > " + t.toString());
                        loading.dismiss();
                        String message = t.toString();
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

                    }
                });
    }

}


