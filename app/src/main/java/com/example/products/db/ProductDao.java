package com.example.products.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.products.model.Product;

import java.util.List;

@Dao
public interface ProductDao {
    @Query("Select * from Product")
    LiveData<List<Product>> getAllProducts();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertProductToFavorite(Product product);
    @Delete
    void deleteProductFromFavorite(Product product);


}
