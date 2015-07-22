package com.rusin.kupandatest.view.activity;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.rusin.kupandatest.KuApp;
import com.rusin.kupandatest.R;
import com.rusin.kupandatest.model.ItemsModel;
import com.rusin.kupandatest.net.object.ItemsResponse;
import com.rusin.kupandatest.view.adapter.RecyclerAdapter;
import com.rusin.kupandatest.view.adapter.RecyclerItemClickListener;

import java.util.ArrayList;

public class FirstActivity extends BaseActivity{
    private RecyclerView mRecyclerView;

    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        Toast.makeText(getBaseContext(), position + "", Toast.LENGTH_SHORT).show();
                    }
                })
        );

        if (KuApp.getManagerModel().getItemsModel().getItem().isEmpty()) {
            KuApp.getManagerModel().getItemsModel().loadItems(new LoadListner());
        } else {
            loadData();
        }

    }

    private void loadData() {
        mAdapter = new RecyclerAdapter(KuApp.getManagerModel().getItemsModel().getItem());
        mRecyclerView.setAdapter(mAdapter);

    }


    private class LoadListner implements ItemsModel.IListnerLoad{
        @Override
        public void load(ArrayList<ItemsResponse.KuItem> list) {
            mAdapter = new RecyclerAdapter(list);
            mRecyclerView.setAdapter(mAdapter);
        }
    }

}
