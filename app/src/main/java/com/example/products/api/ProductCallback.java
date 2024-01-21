package com.example.products.api;

import com.example.products.model.Product;

import java.util.List;

public interface ProductCallback {
     void onSuccessResult(List<Product> products);
     void onFailureResult(String errorMessage);

}
