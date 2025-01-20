package com.mega025.retrofitexample;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


public class DrinksRVAdapter  extends ListAdapter<Drinks, DrinksRVAdapter.MyViewHolder> {

    protected DrinksRVAdapter(@NonNull DiffUtil.ItemCallback<Drinks> diffCallback) {
        super(diffCallback);
    }



    @NonNull
    @Override
    public DrinksRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MyViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinksRVAdapter.MyViewHolder holder, int position) {
Drinks current = getItem(position);


    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvPalabra;
        private final ImageView tvImage;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPalabra = itemView.findViewById(R.id.Name);
            tvImage = itemView.findViewById(R.id.Image);


        }
        public void bind(String text) {
            tvPalabra.setText(text);
        }
        static MyViewHolder create(ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.cocktaalcardview, parent, false);
            return new MyViewHolder(view);


        }



}
}
