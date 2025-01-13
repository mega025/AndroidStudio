package com.mega025.palabraroom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PalabraRVAdapter extends RecyclerView.Adapter<PalabraRVAdapter.MyViewHolder> {

    Context context;
    LiveData<List<Palabra>> palabras;

    public PalabraRVAdapter(Context context, LiveData<List<Palabra>> palabras) {
        this.context = context;
        this.palabras = palabras;
    }

    @NonNull
    @Override
    public PalabraRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cv_row, parent, false);
        return new PalabraRVAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PalabraRVAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvPalabra;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPalabra = itemView.findViewById(R.id.textView);
        }
    }


}
