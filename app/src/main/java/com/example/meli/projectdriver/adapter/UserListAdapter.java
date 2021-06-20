package com.example.meli.projectdriver.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meli.projectdriver.DirectionActivity;
import com.example.meli.projectdriver.DirectionDriverActivity;
import com.example.meli.projectdriver.MainActivity;
import com.example.meli.projectdriver.OjekActivity;
import com.example.meli.projectdriver.R;
import com.example.meli.projectdriver.RequestOrder;
import com.example.meli.projectdriver.SelectDriver;
import com.example.meli.projectdriver.apihelper.ApiClient;
import com.example.meli.projectdriver.apihelper.BaseApiService;
import com.example.meli.projectdriver.model.GetRequest;
import com.example.meli.projectdriver.model.GetTransaksi;
import com.example.meli.projectdriver.model.PostRegister;
import com.example.meli.projectdriver.model.PostRequest;
import com.example.meli.projectdriver.model.PostTransaksi;
import com.example.meli.projectdriver.model.RequestUser;
import com.example.meli.projectdriver.model.Transaksi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
     * Created by root on 2/3/17.
     */

    public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.MyViewHolder>{
        List<RequestUser> mRequestList;
        Context mContext;
        RequestOrder req;
        SharedPreferenceDriver sharedPreferenceDriver;



    BaseApiService mApiInterface;
    String idUsers;

    public UserListAdapter(List <RequestUser> requestList) {
            mRequestList = requestList;
        }

        @Override
        public MyViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
            View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.request_list_item, parent, false);
            MyViewHolder mViewHolder = new MyViewHolder(mView);
            mContext = parent.getContext();
            sharedPreferenceDriver = new SharedPreferenceDriver(mContext);
            return mViewHolder;
        }

        @Override
        public void onBindViewHolder (final MyViewHolder holder, final int position){
            holder.mTextViewNama.setText("" + mRequestList.get(position).getNama());
            holder.mTextViewTujuan.setText(" " + mRequestList.get(position).getTujuan());
            //holder.mTextViewNomor.setText("Nomor = " + mDriverList.get(position).getNomor());
            idUsers = mRequestList.get(position).getId();
            holder.mBtnAccept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Intent mIntent = new Intent(view.getContext(), OjekActivity.class);
//                    mIntent.putExtra("id_extra", mRequestList.get(position).getIdReq());
//                    mIntent.putExtra("Nama", mRequestList.get(position).getNama());
//                    mIntent.putExtra("Tujuan", mRequestList.get(position).getTujuan());
//                    view.getContext().startActivity(mIntent);

                    Call<PostRequest> putRequestCall = mApiInterface.putRequest(mRequestList.get(position).getIdReq(),Integer.toString(sharedPreferenceDriver.getSPId()));
                    putRequestCall.enqueue(new Callback<PostRequest>() {
                        @Override
                        public void onResponse(Call<PostRequest> call, Response<PostRequest> response) {
                            //Toast.makeText(mContext, "Accepted", Toast.LENGTH_LONG).show();
                            refresh2();
                            refresh2();
                            Call<GetTransaksi> transaksiCall = mApiInterface.getTransaksi(Integer.toString(sharedPreferenceDriver.getSPId()),mRequestList.get(position).getId());
                            transaksiCall.enqueue(new Callback<GetTransaksi>() {
                                @Override
                                public void onResponse(Call<GetTransaksi> call, Response<GetTransaksi>
                                        response) {
                                    List<Transaksi> transaksiList = response.body().getListDataTransaksi();
                                    Log.d("Retrofit Get", "Jumlah data Transaksi: " +
                                            String.valueOf(transaksiList.size()));
//                                    if (transaksiList.get(0).getStatus().equalsIgnoreCase("diterima"))
//                                                Toast.makeText(getApplicationContext(), "Sukses", Toast.LENGTH_LONG).show();
                                    //mAdapter = new UserListAdapter(requestList);
                                    //mRecyclerView.setAdapter(mAdapter);
                                }
                                @Override
                                public void onFailure(Call<GetTransaksi> call, Throwable t) {
                                    Log.e("Retrofit Get", t.toString());
                                }
                            });
                            refresh2();
                            refresh2();
                            refresh2();
                            refresh1();
                        }
                        //Intent i = new Intent(mContext,OjekActivity.class);
                        //mContext.startActivity(i);

                        @Override
                        public void onFailure(Call<PostRequest> call, Throwable t) {
                            Toast.makeText(mContext, "Error", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            });

            holder.mBtnDecline.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Intent mIntent = new Intent(view.getContext(), OjekActivity.class);
//                    mIntent.putExtra("id_extra", mRequestList.get(position).getId());
//                    mIntent.putExtra("Nama", mRequestList.get(position).getNama());
//                    mIntent.putExtra("Tujuan", mRequestList.get(position).getTujuan());
//                    view.getContext().startActivity(mIntent);
                    Call<PostRequest> putRequestRejectCall = mApiInterface.putRequestReject(mRequestList.get(position).getIdReq());
                    putRequestRejectCall.enqueue(new Callback<PostRequest>() {
                        @Override
                        public void onResponse(Call<PostRequest> call, Response<PostRequest> response) {
                            Toast.makeText(mContext, "Rejected", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(mContext,RequestOrder.class);
                            mContext.startActivity(i);

                        }

                        @Override
                        public void onFailure(Call<PostRequest> call, Throwable t) {
                            Toast.makeText(mContext, "Error", Toast.LENGTH_LONG).show();

                        }
                    });
                }
            });
        }

        @Override
        public int getItemCount () {
            return mRequestList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView mTextViewNama, mTextViewTujuan;
            public Button mBtnAccept,mBtnDecline;

            public MyViewHolder(View itemView) {
                super(itemView);
                mTextViewNama = (TextView) itemView.findViewById(R.id.txtviewNama1);
                mTextViewTujuan = (TextView) itemView.findViewById(R.id.txtviewTujuan);
                mBtnAccept = (Button) itemView.findViewById(R.id.bt_accept);
                mBtnDecline = (Button) itemView.findViewById(R.id.bt_decline);
                mApiInterface = ApiClient.getClient().create(BaseApiService.class);
            }
        }

    public void refresh() {
        Call<GetRequest> requestCall = mApiInterface.getRequest(Integer.toString(sharedPreferenceDriver.getSPId()));
        requestCall.enqueue(new Callback<GetRequest>() {
            @Override
            public void onResponse(Call<GetRequest> call, Response<GetRequest>
                    response) {
                List<RequestUser> requestList = response.body().getListDataRequestUser();
                Log.d("Retrofit Get", "Jumlah data User: " +
                        String.valueOf(requestList.size()));
            }

            @Override
            public void onFailure(Call<GetRequest> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

    public void refresh1(){
        Toast.makeText(mContext, "Accepted", Toast.LENGTH_LONG).show();
        Call<GetTransaksi> transaksiCall = mApiInterface.getTransaksi(Integer.toString(sharedPreferenceDriver.getSPId()),idUsers);
        transaksiCall.enqueue(new Callback<GetTransaksi>() {
            @Override
            public void onResponse(Call<GetTransaksi> call, Response<GetTransaksi>
                    response) {
                List<Transaksi> transaksiList = response.body().getListDataTransaksi();
                Log.d("Retrofit Get", "Jumlah data Transaksi: " +
                        String.valueOf(transaksiList.size()));
                Intent i = new Intent(mContext, DirectionDriverActivity.class);
                Double latJem = Double.valueOf(transaksiList.get(0).getLatJem());
                Double longJem = Double.valueOf(transaksiList.get(0).getLongJem());
                Double latTuj = Double.valueOf(transaksiList.get(0).getLatTuj());
                Double longTuj = Double.valueOf(transaksiList.get(0).getLongTuj());
                Double price = Double.valueOf(transaksiList.get(0).getTotalHarga());
                String idTrans = transaksiList.get(0).getIdTransaksi();
                Intent intent = ((RequestOrder)mContext).getIntent();
                i.putExtra("idUser",idUsers);
                i.putExtra("latJem",latJem);
                i.putExtra("longJem",longJem);
                i.putExtra("latTuj",latTuj);
                i.putExtra("longTuj",longTuj);
                i.putExtra("price",price);
                i.putExtra("idTrans",idTrans);
                i.putExtra("saldo",intent.getDoubleExtra("saldo",0));
                mContext.startActivity(i);
            }
            @Override
            public void onFailure(Call<GetTransaksi> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

    public void refresh2(){
        Toast.makeText(mContext, "Accepted", Toast.LENGTH_LONG).show();
        Call<GetTransaksi> transaksiCall = mApiInterface.getTransaksi(Integer.toString(sharedPreferenceDriver.getSPId()),idUsers);
        transaksiCall.enqueue(new Callback<GetTransaksi>() {
            @Override
            public void onResponse(Call<GetTransaksi> call, Response<GetTransaksi>
                    response) {
                List<Transaksi> transaksiList = response.body().getListDataTransaksi();
                Log.d("Retrofit Get", "Jumlah data Transaksi: " +
                        String.valueOf(transaksiList.size()));
//                Intent i = new Intent(mContext, DirectionDriverActivity.class);
//                Double latJem = Double.valueOf(transaksiList.get(0).getLatJem());
//                Double longJem = Double.valueOf(transaksiList.get(0).getLongJem());
//                Double latTuj = Double.valueOf(transaksiList.get(0).getLatTuj());
//                Double longTuj = Double.valueOf(transaksiList.get(0).getLongTuj());
//                String idTrans = transaksiList.get(0).getIdTransaksi();
//                i.putExtra("idUser",idUsers);
//                i.putExtra("latJem",latJem);
//                i.putExtra("longJem",longJem);
//                i.putExtra("latTuj",latTuj);
//                i.putExtra("longTuj",longTuj);
//                i.putExtra("idTrans",idTrans);
//                mContext.startActivity(i);
            }
            @Override
            public void onFailure(Call<GetTransaksi> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

    //Intent i = new Intent(mContext,OjekActivity.class);
    //mContext.startActivity(i);
    }
