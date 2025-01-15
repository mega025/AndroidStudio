package com.mega025.palabraroom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PalabraRVAdapter extends ListAdapter<Palabra, PalabraRVAdapter.MyViewHolder> {

    Context context;
    LiveData<List<Palabra>> palabras;
    private PalabraViewModel palabraViewModel;

    //Define como comparar los cambios (modificacion,eliminar,añadir,etc)
    public PalabraRVAdapter(@NonNull DiffUtil.ItemCallback<Palabra> diffCallback) {
        super(diffCallback);
    }
    //metodos internos de diffCallBack
    static class WordDiff extends DiffUtil.ItemCallback<Palabra> {

       //mira si ese objeto ya existe
        @Override
        public boolean areItemsTheSame(@NonNull Palabra oldItem, @NonNull Palabra newItem) {
            return oldItem == newItem;
        }
//mira si hay cambios en algun objeto
        @Override
        public boolean areContentsTheSame(@NonNull Palabra oldItem, @NonNull Palabra newItem) {
            return oldItem.getPalabra().equals(newItem.getPalabra());
        }
    }


    @NonNull
    @Override
    public PalabraRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MyViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull PalabraRVAdapter.MyViewHolder holder, int position) {
        Palabra current = getItem(position);
        holder.bind(current.getPalabra());
        // Evento de clic para eliminar
        holder.deleteIcon.setOnClickListener(view -> {
            // Llamar al método de eliminación en el ViewModel
            palabraViewModel.delete(current);
        });
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

       private final TextView tvPalabra;
       private final ImageView deleteIcon;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPalabra = itemView.findViewById(R.id.textView);
            deleteIcon = itemView.findViewById(R.id.papeleria);
        }

        public void bind(String text) {
            tvPalabra.setText(text);
        }

        static MyViewHolder create(ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.cv_row, parent, false);
            return new MyViewHolder(view);
        }
    }
}
