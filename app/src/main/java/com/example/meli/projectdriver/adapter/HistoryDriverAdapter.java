package com.example.meli.projectdriver.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.meli.projectdriver.model.History;
import com.example.meli.projectdriver.R;

import java.util.List;

/**
 * Created by root on 2/3/17.
 */

public class HistoryDriverAdapter extends RecyclerView.Adapter<HistoryDriverAdapter.MyViewHolder>{
    List<History> mHistoryList;

    public HistoryDriverAdapter(List <History> HistoryList) {
        mHistoryList = HistoryList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.historydriver_list_item, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder,final int position){
        holder.mTextViewNama.setText(mHistoryList.get(position).getNama());
        holder.mTextViewTujuan.setText(mHistoryList.get(position).getTujuan());
        holder.mTextViewJam.setText(mHistoryList.get(position).getStartTime());
        holder.rating.setRating(Float.parseFloat(mHistoryList.get(position).getRating()));
    }

    @Override
    public int getItemCount () {
        return mHistoryList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewNama, mTextViewTujuan,  mTextViewJam;
        RatingBar rating;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewNama = (TextView) itemView.findViewById(R.id.title12);
            mTextViewTujuan = (TextView) itemView.findViewById(R.id.title13);
            mTextViewJam = (TextView) itemView.findViewById(R.id.jam1);
            rating = (RatingBar) itemView.findViewById(R.id.ratingBar4);
        }
    }
}
