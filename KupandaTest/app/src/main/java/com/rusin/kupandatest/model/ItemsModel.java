package com.rusin.kupandatest.model;


import com.rusin.kupandatest.net.api.ApiFacade;
import com.rusin.kupandatest.net.object.ItemsResponse;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ItemsModel {

    private static final String apiKey = "ca3e173c79f471cc04d53ce6b349d9cf";
    private static final int cityId = 1;
    private static final String method = "get_offer_coupons";
    private static final int category_id = 26;
    private static final int offset = 0;
    private static final int limit = 20;

    private ArrayList<ItemsResponse.KuItem> list;

    public ItemsModel() {
        list = new ArrayList<>(0);
    }

    public ArrayList<ItemsResponse.KuItem> getItems() {
        return new ArrayList(list);
    }

    public ItemsResponse.KuItem getItem(int position) {
        if ((list == null) || (list.isEmpty())) {
            return null;
        }
        if (list.size() > position) {
            return list.get(position);
        }
        return null;
    }

    public void loadItems(final IListnerLoad listner) {

        Callback<ItemsResponse> cl = new Callback<ItemsResponse>() {
            @Override
            public void success(ItemsResponse itemsResponse, Response response) {
                list = new ArrayList<>(itemsResponse.result.data.items);
                if (listner != null) {
                    listner.load(new ArrayList<>(list));
                }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        };
        ApiFacade.getInstance().getItems(apiKey, cityId, method, category_id, offset, limit, cl);
    }

    public int size() {
        if (list != null) {
            list.size();
        }
        return 0;
    }

    public interface IListnerLoad {
        void load(ArrayList<ItemsResponse.KuItem> list);
    }
}
