package com.rusin.kupandatest.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.rusin.kupandatest.R;
import com.rusin.kupandatest.net.object.ItemsResponse;

import java.util.ArrayList;


public class RecyclerAdapter extends  RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<ItemsResponse.KuItem> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mImageView;
        public TextView mTextView;


        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.recycler_text);
            mImageView = (ImageView)v.findViewById(R.id.recycler_image);
        }
    }

    public RecyclerAdapter(ArrayList<ItemsResponse.KuItem> dataset) {
        mDataset = dataset;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mTextView.setText(mDataset.get(position).origin_price.amount + "");

        Glide.with(holder.mImageView.getContext()).load(mDataset.get(position).image_item)
                .fitCenter()
                .into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }



}
