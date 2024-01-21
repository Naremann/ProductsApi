package com.example.products.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.products.R;
import com.example.products.api.ApiManager;
import com.example.products.api.ProductCallback;
import com.example.products.db.MyDatabase;
import com.example.products.model.Product;
import com.example.products.model.Repository;
import com.example.products.view.ProductAdapter;

import java.util.ArrayList;
import java.util.List;

public class AllProductsActivity extends AppCompatActivity implements ProductCallback {
    ProductAdapter productAdapter;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    Repository repository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_products);
        repository=Repository.getInstance(this.getApplicationContext());
        productAdapter=new ProductAdapter(new ArrayList<>());
        initViews();
        ApiManager apiManager=new ApiManager();
        apiManager.makeNetworkCall(this);

    }

    private void initViews() {
        recyclerView = findViewById(R.id.recycler_view);
        progressBar=findViewById(R.id.progress_bar);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AllProductsActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        productAdapter.onFavoriteClickListener= product -> {
            Log.e("onItemClickListener", "onItemClickListener: Clicked");
            repository.insertProductToFavorite(product);
        };
    }

    @Override
    public void onSuccessResult(List<Product> products) {
        progressBar.setVisibility(View.INVISIBLE);
        Log.e("TAG", "onSuccessResult: "+products.get(0) );
        productAdapter.changeData(products);
        recyclerView.setAdapter(productAdapter);
    }
    @Override
    public void onFailureResult(String errorMessage) {
        progressBar.setVisibility(View.INVISIBLE);
        Log.e("TAG", "onFailResult: "+errorMessage);
        ShowToastMessage(errorMessage);
    }

    private void ShowToastMessage(String errorMessage) {
        Toast.makeText(AllProductsActivity.this,errorMessage,Toast.LENGTH_LONG).show();
    }
}