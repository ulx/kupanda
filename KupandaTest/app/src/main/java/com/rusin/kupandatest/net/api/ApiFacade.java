package com.rusin.kupandatest.net.api;

import com.rusin.kupandatest.net.object.ItemsResponse;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;
import retrofit.client.Client;
import retrofit.client.OkClient;

/**
 * Created by alexander on 22.07.15.
 */
public class ApiFacade {
    public final static String TAG = "KUPANDA";
    private final static int TIMEOUT = 5000;
    private final static String SEVER_URL = "http://apimobile.kupanda.ru/api";
    private static ApiFacade instance;
    private final boolean isSecure = true;
    private IApi api;

    private ApiFacade() {
        api = getApiInterface(TIMEOUT, getApiEndpoint());
    }

    public static ApiFacade getInstance() {
        if (instance == null) {
            instance = new ApiFacade();
        }

        return instance;
    }

    private String getApiEndpoint() {
        return SEVER_URL;
    }

    private Client getClient(final long timeout) {
        final OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(timeout, TimeUnit.MILLISECONDS);
        client.setRetryOnConnectionFailure(true);

        return new OkClient(client);
    }

    private IApi getApiInterface(final long timeout, final String endpointUrl) {
        return new RestAdapter.Builder()
                .setClient(getClient(timeout))
                .setEndpoint(endpointUrl)
                .setLogLevel(RestAdapter.LogLevel.BASIC)
                .setLog(new AndroidLog(TAG))
                .build()
                .create(IApi.class);
    }

    public void getItems(String apiKey, int cityId, String method, int categoryId, int offset, int limit, Callback<ItemsResponse> cl) {
        api.getItems(apiKey, cityId, method, categoryId, offset, limit, cl);
    }
}
