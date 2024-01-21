package com.example.products.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ProductResponse{

    @SerializedName("total")
    private int total;

    @SerializedName("limit")
    private int limit;

    @SerializedName("skip")
    private int skip;

    @SerializedName("products")
    private List<Product> products;

    public int getTotal(){
        return total;
    }

    public int getLimit(){
        return limit;
    }

    public int getSkip(){
        return skip;
    }

    public List<Product> getProducts(){
        return products;
    }
}