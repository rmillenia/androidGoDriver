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
import com.example.meli.projectdriver.adapter.SharedPreferenceDriver;
import com.example.meli.projectdriver.adapter.UserListAdapter;
import com.example.meli.projectdriver.model.GetDriver;
import com.example.meli.projectdriver.model.Driver;
import com.example.meli.projectdriver.apihelper.ApiClient;
import com.example.meli.projectdriver.apihelper.BaseApiService;
import com.example.meli.projectdriver.model.GetRequest;
import com.example.meli.projectdriver.model.Request;
import com.example.meli.projectdriver.model.RequestUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RequestOrder extends AppCompatActivity {
    BaseApiService mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static RequestOrder ro;
    SharedPreferenceDriver sharedPreference;

    TextView toolbar;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_order);
        toolbar = (TextView) findViewById(R.id.tv_title);
        toolbar.setText("Request Order");
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView1);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        sharedPreference = new SharedPreferenceDriver(this);
        mApiInterface = ApiClient.getClient().create(BaseApiService.class);
        button = (Button) findViewById(R.id.bt_decline);
        ro=this;
        refresh();

    }

    public void refresh() {
        Call<GetRequest> requestCall = mApiInterface.getRequest(Integer.toString(sharedPreference.getSPId()));
        requestCall.enqueue(new Callback<GetRequest>() {
            @Override
            public void onResponse(Call<GetRequest> call, Response<GetRequest>
                    response) {
                List<RequestUser> requestList = response.body().getListDataRequestUser();
                Log.d("Retrofit Get", "Jumlah data Driver: " +
                        String.valueOf(requestList.size()));
                mAdapter = new UserListAdapter(requestList);
                mRecyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<GetRequest> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        refresh();
    }


}
