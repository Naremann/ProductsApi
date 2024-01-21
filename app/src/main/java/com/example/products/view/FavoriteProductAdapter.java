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

public class FavoriteProductAdapter extends RecyclerView.Adapter<FavoriteProductAdapter.FavProducctViewHolder>{
    List<Product> productList;
    public FavoriteProductAdapter.OnDeleteClickListener onDeleteClickListener;

    public FavoriteProductAdapter(List<Product> products) {
        productList=products;
    }




    public void changeData(List<Product> productList) {
        this.productList = productList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FavoriteProductAdapter.FavProducctViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.favorite_product_item,parent,false);
        FavoriteProductAdapter.FavProducctViewHolder viewHolder = new FavoriteProductAdapter.FavProducctViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FavProducctViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.titleTextView.setText(product.getTitle());
        holder.priceTextView.setText(String.valueOf(product.getPrice()));
        holder.descriptionTextView.setText(product.getDescription());
        holder.brandTextView.setText(product.getBrand());
        Glide.with(holder.imageView.getContext()).load(product.getThumbnail()).into(holder.imageView);
        holder.ratingBar.setRating( product.getRating());
        holder.deleteBtn.setOnClickListener(view -> {
            onDeleteClickListener.onItemClickListener(product);
        });

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class FavProducctViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView titleTextView, priceTextView, brandTextView, descriptionTextView, currentItemTv;
        RatingBar ratingBar;
        ProgressBar progressBar,imageProgressBar;
        Button deleteBtn;

        public FavProducctViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            titleTextView = itemView.findViewById(R.id.title_text_view);
            priceTextView = itemView.findViewById(R.id.price_text_view);
            brandTextView = itemView.findViewById(R.id.brand_text_view);
            descriptionTextView = itemView.findViewById(R.id.description_text_view);
            ratingBar=itemView.findViewById(R.id.rating_bar);
            progressBar = itemView.findViewById(R.id.progress_bar);
            progressBar = itemView.findViewById(R.id.progress_bar);
            deleteBtn=itemView.findViewById(R.id.delete_btn);

        }
    }

    public interface OnDeleteClickListener{
        void onItemClickListener(Product product);
    }
}
