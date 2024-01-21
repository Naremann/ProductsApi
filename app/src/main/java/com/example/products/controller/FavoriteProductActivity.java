package com.example.products.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.products.R;
import com.example.products.db.MyDatabase;
import com.example.products.model.Product;
import com.example.products.model.Repository;
import com.example.products.view.FavoriteProductAdapter;
import com.example.products.view.ProductAdapter;

import java.util.ArrayList;
import java.util.List;

public class FavoriteProductActivity extends AppCompatActivity {
    FavoriteProductAdapter productAdapter;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_product);
        repository = Repository.getInstance(this);
        initViews();
    }

    private void initViews() {
        productAdapter = new FavoriteProductAdapter(new ArrayList<>());
        recyclerView = findViewById(R.id.recycler_view);
        progressBar = findViewById(R.id.progress_bar);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(FavoriteProductActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        LiveData<List<Product>> productList = repository.getProducts();
        // MyDatabase.getInstance(FavoriteProductActivity.this).getproductDao().getAllProducts();
        productList.observe(FavoriteProductActivity.this, products -> {
            if (products != null) {
                productAdapter.changeData(products);
            }
        });
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(productAdapter);
        productAdapter.onDeleteClickListener = product -> {
            repository=Repository.getInstance(FavoriteProductActivity.this.getApplicationContext());
            repository.deleteFavoriteProduct(product);
        };


    }
}