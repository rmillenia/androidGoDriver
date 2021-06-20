package com.example.meli.projectdriver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meli.projectdriver.adapter.DriverListAdapter;
import com.example.meli.projectdriver.model.GetDriver;
import com.example.meli.projectdriver.model.Driver;
import com.example.meli.projectdriver.apihelper.ApiClient;
import com.example.meli.projectdriver.apihelper.BaseApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SelectDriver extends AppCompatActivity {
    BaseApiService mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static SelectDriver sd;

    TextView toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_driver);
        toolbar = (TextView) findViewById(R.id.tv_title);
        toolbar.setText("Available Driver");
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(BaseApiService.class);
        sd=this;
        refresh();
    }

    public void refresh() {
        Call<GetDriver> kontakCall = mApiInterface.getDriver();
        kontakCall.enqueue(new Callback<GetDriver>() {
            @Override
            public void onResponse(Call<GetDriver> call, Response<GetDriver>
                    response) {
                List<Driver> DriverList = response.body().getListDataDriver();
                Log.d("Retrofit Get", "Jumlah data Driver: " +
                        String.valueOf(DriverList.size()));
                mAdapter = new DriverListAdapter(DriverList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetDriver> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }


}
