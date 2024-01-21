package com.example.products.api;

import com.example.products.model.ProductResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface WebService {
    @GET("products")
    Call<ProductResponse> getProducts();
}
