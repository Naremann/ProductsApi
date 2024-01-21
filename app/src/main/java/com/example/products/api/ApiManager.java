package com.example.products.api;

import android.util.Log;

import com.example.products.model.ProductResponse;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {
    static Retrofit retrofit=null;
    private static final String BASE_URL="https://dummyjson.com/";

    public static Retrofit getInstance(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }



    public static WebService getApi(){
        return getInstance().create(WebService.class);
    }

    public void makeNetworkCall(ProductCallback productCallback){
        getApi().getProducts().enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                if(response.isSuccessful()){
                    productCallback.onSuccessResult(response.body().getProducts());
                }
                else{
                    Log.e("TAG", "onResponse: "+response.message());
                }

            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                productCallback.onFailureResult(t.getLocalizedMessage());
                Log.e("TAG", "onResponse: "+t.getLocalizedMessage());
            }
        });

    }
}
