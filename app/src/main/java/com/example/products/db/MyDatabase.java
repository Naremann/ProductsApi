package com.example.products.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.products.model.Product;

@Database(entities = {Product.class},version = 1)
public abstract class MyDatabase extends RoomDatabase {
    public static final String DATABASE_NAME="myDatabase";
    public static MyDatabase database=null;
    public abstract ProductDao getproductDao();
    public static synchronized MyDatabase getInstance(Context context){
        if(database==null){
            database= Room.databaseBuilder(context.getApplicationContext(),MyDatabase.class,DATABASE_NAME)
                    .build();
        }
        return database;
    }

}
