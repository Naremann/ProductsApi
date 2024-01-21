package com.example.products.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.products.R;

public class MainActivity extends AppCompatActivity {
    Button productBtn,favBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        productBtn =findViewById(R.id.movies_btn);
        favBtn =findViewById(R.id.favorite_btn);
        productBtn.setOnClickListener(view->{
            startAllProductActivity(AllProductsActivity.class);
        });
        favBtn.setOnClickListener(view->{
            startAllProductActivity(FavoriteProductActivity.class);
        });
    }

    private void startAllProductActivity(Class activityClass) {
        Intent intent=new Intent(MainActivity.this,activityClass);
        startActivity(intent);
    }


}