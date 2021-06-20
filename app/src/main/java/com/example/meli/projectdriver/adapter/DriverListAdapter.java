package com.example.meli.projectdriver.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.meli.projectdriver.OjekActivity;
import com.example.meli.projectdriver.SelectDriver;
import com.example.meli.projectdriver.model.Driver;
import com.example.meli.projectdriver.OjekActivity;
import com.example.meli.projectdriver.R;

import java.util.List;

/**
 * Created by root on 2/3/17.
 */

public class DriverListAdapter extends RecyclerView.Adapter<DriverListAdapter.MyViewHolder>{
    List<Driver> mDriverList;
    Context mContext;

    public DriverListAdapter(List <Driver> driverList) {
        mDriverList = driverList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.driver_list_item, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        mContext = parent.getContext();
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder,final int position){
        holder.mTextViewNama.setText("" + mDriverList.get(position).getNama());
        holder.mTextViewHp.setText(" " + mDriverList.get(position).getNoHp());
        //holder.mTextViewNomor.setText("Nomor = " + mDriverList.get(position).getNomor());
        holder.mBtnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = ((SelectDriver)mContext).getIntent();
                intent.getDoubleExtra("saldo",0);
                Intent mIntent = new Intent(view.getContext(), OjekActivity.class);
                mIntent.putExtra("id_extra", mDriverList.get(position).getId());
                mIntent.putExtra("saldo",intent.getDoubleExtra("saldo",0));
                mIntent.putExtra("Nama", mDriverList.get(position).getNama());
                mIntent.putExtra("Nomor", mDriverList.get(position).getNoHp());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mDriverList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewNama, mTextViewHp;
        public Button mBtnSelect;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewNama = (TextView) itemView.findViewById(R.id.txtviewNama);
            mTextViewHp = (TextView) itemView.findViewById(R.id.txtviewTelp);
            mBtnSelect = (Button) itemView.findViewById(R.id.bt_select);
        }
    }
}

