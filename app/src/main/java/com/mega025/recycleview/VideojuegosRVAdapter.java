package com.mega025.recycleview;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.mega025.recycleview.R;

import java.util.ArrayList;


public class VideojuegosRVAdapter extends RecyclerView.Adapter<VideojuegosRVAdapter.MyViewHolder> {

    Context context;
    ArrayList<VideojuegosModel> videojuegosModels;
    public VideojuegosRVAdapter(Context context, ArrayList<VideojuegosModel> videojuegosModels) {
        this.context = context;
        this.videojuegosModels = videojuegosModels;
    }

    @NonNull
    @Override
    public VideojuegosRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cv_row_game, parent, false);
        return new VideojuegosRVAdapter.MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull VideojuegosRVAdapter.MyViewHolder holder, int position) {
        String pregunta = videojuegosModels.get(position).getPregunta();
        String respuestaCorrecta = videojuegosModels.get(position).getRespuestaCorrecta();
        String[] opciones = videojuegosModels.get(position).getOpciones();

        holder.pregunta.setText(pregunta);

        holder.itemView.setOnClickListener(view -> {
            MaterialAlertDialogBuilder dialogBuilder = new MaterialAlertDialogBuilder(context)
                    .setIcon(R.drawable.baseline_gamepad_24)
                    .setTitle(pregunta)
                    .setSingleChoiceItems(opciones, -1, (dialog, which) -> {
                        if (opciones[which].equals(respuestaCorrecta)) {
                            Toast.makeText(context, "¡Respuesta correcta!", Toast.LENGTH_SHORT).show();


                            videojuegosModels.remove(position);
                            notifyItemRemoved(position);
                            notifyItemRangeChanged(position, videojuegosModels.size());
                        } else {
                            Toast.makeText(context, "¡Respuesta incorrecta!", Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    })
                    .setNegativeButton("Cancelar", null);
            dialogBuilder.show();
        });
    }



    @Override
    public int getItemCount() {
        return videojuegosModels.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView pregunta, respuesta;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pregunta = itemView.findViewById(R.id.Pregunta);
        }
    }
}
