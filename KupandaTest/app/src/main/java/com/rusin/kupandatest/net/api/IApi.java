package com.rusin.kupandatest.net.api;

import com.rusin.kupandatest.net.object.ItemsResponse;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by alexander on 22.07.15.
 */
public interface IApi {
    @GET("/")
    void getItems(@Query("api_key") String apiKey,
                  @Query("city_id") int city_id,
                  @Query("method") String method,
                  @Query("category_id") int category_id,
                  @Query("offset") int offset,
                  @Query("limit") int limit,
                  Callback<ItemsResponse> cl);
}
