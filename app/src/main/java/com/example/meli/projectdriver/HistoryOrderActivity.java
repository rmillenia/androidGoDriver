package com.example.meli.projectdriver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.meli.projectdriver.adapter.HistoryDriverAdapter;
import com.example.meli.projectdriver.adapter.SharedPreferenceDriver;
import com.example.meli.projectdriver.apihelper.ApiClient;
import com.example.meli.projectdriver.apihelper.BaseApiService;
import com.example.meli.projectdriver.model.GetHistory;
import com.example.meli.projectdriver.model.History;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryOrderActivity extends AppCompatActivity {
    Button btIns;
    BaseApiService mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static HistoryOrderActivity ho;
    SharedPreferenceDriver sharedPreference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_order);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView1);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(BaseApiService.class);
        sharedPreference = new SharedPreferenceDriver(this);
        ho=this;
        refresh();
    }

    public void refresh() {
        Call<GetHistory> historyCall = mApiInterface.getHistory(String.valueOf(sharedPreference.getSPId()));
        historyCall.enqueue(new Callback<GetHistory>() {
            @Override
            public void onResponse(Call<GetHistory> call, Response<GetHistory>
                    response) {
                List<History> HistoryList = response.body().getResult();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(HistoryList.size()));
                mAdapter = new HistoryDriverAdapter(HistoryList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetHistory> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}
