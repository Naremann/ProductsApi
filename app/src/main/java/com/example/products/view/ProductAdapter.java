package com.example.products.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.products.R;
import com.example.products.model.Product;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    List<Product> productList;
    public OnFavoriteClickListener onFavoriteClickListener;

    public ProductAdapter(List<Product> products) {
        productList=products;
    }


    public ProductAdapter() {
    }

    public void changeData(List<Product> productList) {
        this.productList = productList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.product_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.titleTextView.setText(product.getTitle());
        holder.priceTextView.setText(String.valueOf(product.getPrice()));
        holder.descriptionTextView.setText(product.getDescription());
        holder.brandTextView.setText(product.getBrand());
        Glide.with(holder.imageView.getContext()).load(product.getThumbnail()).into(holder.imageView);
        holder.ratingBar.setRating( product.getRating());
        holder.favBtn.setOnClickListener(view -> {
            onFavoriteClickListener.onItemClickListener(product);
        });

    }



    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView titleTextView, priceTextView, brandTextView, descriptionTextView, currentItemTv;
        RatingBar ratingBar;
        ProgressBar progressBar,imageProgressBar;
        Button favBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            titleTextView = itemView.findViewById(R.id.title_text_view);
            priceTextView = itemView.findViewById(R.id.price_text_view);
            brandTextView = itemView.findViewById(R.id.brand_text_view);
            descriptionTextView = itemView.findViewById(R.id.description_text_view);
            ratingBar=itemView.findViewById(R.id.rating_bar);
            progressBar = itemView.findViewById(R.id.progress_bar);
            progressBar = itemView.findViewById(R.id.progress_bar);
            favBtn=itemView.findViewById(R.id.favorite_btn);
        }
    }

    public interface OnFavoriteClickListener{
        void onItemClickListener(Product product);
    }
}
