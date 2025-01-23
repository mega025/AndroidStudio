package com.mega025.retrofitexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;


public class DrinksRVAdapter  extends RecyclerView.Adapter<DrinksRVAdapter.MyViewHolder> {

private List<Drinks.Cocktail> drinks;


    public DrinksRVAdapter(List<Drinks.Cocktail> drinks) {
        this.drinks = drinks;

    }

    @NonNull
    @Override
    public DrinksRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cocktaalcardview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinksRVAdapter.MyViewHolder holder, int position) {
        holder.bind(drinks.get(position).getCocktailName(),drinks.get(position).getCocktailImageUrl());
    }

    @Override
    public int getItemCount() {
        return drinks.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
         TextView tvPalabra;
         ImageView tvImage;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPalabra = itemView.findViewById(R.id.Name);
            tvImage = itemView.findViewById(R.id.Image);
        }

        public void bind(String text,String urlImagen) {
            tvPalabra.setText(text);

            Glide.with(itemView)
                    .load(urlImagen)
                    .into(tvImage);

        }




}
}
