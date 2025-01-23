package com.mega025.retrofitexample;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.mega025.retrofitexample.R;


import java.util.List;


public class DrinksRVAdapter  extends RecyclerView.Adapter<DrinksRVAdapter.MyViewHolder> {

private List<Drinks.Cocktail> drinks;
private Context context;
    ViewGroup parent;

    public DrinksRVAdapter(List<Drinks.Cocktail> drinks, Context context) {
        this.drinks = drinks;
        this.context = context;
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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View detail = LayoutInflater.from(context)
                        .inflate(R.layout.cocktailcardpopup, parent, false);

                ImageView detailsImage = detail.findViewById(R.id.imageView);
                Glide.with(view)
                        .load(drinks.get(holder.getAdapterPosition()).getCocktailImageUrl())
                        .into(detailsImage);

                TextView nameText = detail.findViewById(R.id.Nombre);
                nameText.setText(drinks.get(holder.getAdapterPosition()).cocktailName);

                TextView idText = detail.findViewById(R.id.idCocktail);
                idText.setText(drinks.get(holder.getAdapterPosition()).cocktailId);

                TextView instructionsText = detail.findViewById(R.id.Intruciones);
                instructionsText.setText(drinks.get(holder.getAdapterPosition()).intruciones);



                MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(context)
                        .setView(detail)
                        .setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {}
                        });
                materialAlertDialogBuilder.show();
            }
        });
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
