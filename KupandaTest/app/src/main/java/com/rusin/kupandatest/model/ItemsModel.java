package com.rusin.kupandatest.model;


import com.rusin.kupandatest.net.object.ItemsResponse;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ItemsModel {
    private ArrayList<ItemsResponse.KuItem> list;

    public ItemsModel(){
        list = new ArrayList<>(0);
    }

    public ArrayList<ItemsResponse.KuItem> getItem() {
        return new ArrayList(list);
    }

    public void loadItems(final IListnerLoad listner){

        Callback<ItemsResponse> cl = new Callback<ItemsResponse>() {
            @Override
            public void success(ItemsResponse itemsResponse, Response response) {
                list = new ArrayList<>(itemsResponse.result.data.items);
                listner.load(new ArrayList<>(list));
            }

            @Override
            public void failure(RetrofitError error) {

            }
        };

    }

    public interface IListnerLoad{
       void load(ArrayList<ItemsResponse.KuItem> list);
    }
}
