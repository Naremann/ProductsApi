package com.example.products.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "Product")
public class Product {

   // @SerializedName("discountPercentage")
    //private float discountPercentage;

    @SerializedName("thumbnail")
    private String thumbnail;



    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
//@SerializedName("images")
    //private List<String> images;

    @SerializedName("price")
    private int price;

    @SerializedName("rating")
    private float rating;

    @SerializedName("description")
    private String description;
    @PrimaryKey
    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("stock")
    private int stock;

    @SerializedName("category")
    private String category;

    @SerializedName("brand")
    private String brand;

   // public Object getDiscountPercentage(){
     //   return discountPercentage;
   // }

    public String getThumbnail(){
        return thumbnail;
    }

    //public List<String> getImages(){
     //   return images;
    //}

    public int getPrice(){
        return price;
    }

    public float getRating(){
        return rating;
    }

    public String getDescription(){
        return description;
    }

    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public int getStock(){
        return stock;
    }

    public String getCategory(){
        return category;
    }

    public String getBrand(){
        return brand;
    }
}