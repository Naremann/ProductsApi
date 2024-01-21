package com.example.products.model;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.products.db.MyDatabase;
import com.example.products.db.ProductDao;

import java.util.List;

public class Repository {
    private ProductDao productDao;
    private LiveData<List<Product>>  products;
    private static Repository repository=null;

    public Repository(Context ctx) {
        MyDatabase database=MyDatabase.getInstance(ctx);
        productDao=database.getproductDao();
        products=productDao.getAllProducts();
    }
    public static Repository getInstance(Context context){
        if(repository==null) {
            repository = new Repository(context);
        }
        return repository;
    }
    public LiveData<List<Product>>getProducts(){
        return products;
    }
    public void deleteFavoriteProduct(Product product){
        new Thread(() -> productDao.deleteProductFromFavorite(product)){
        }.start();
    }
    public void insertProductToFavorite(Product product){
        new Thread(() -> productDao.insertProductToFavorite(product)){
        }.start();
    }

}
