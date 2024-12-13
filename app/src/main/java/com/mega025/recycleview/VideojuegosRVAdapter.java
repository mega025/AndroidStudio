package com.mega025.recycleview;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

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

        String preguntas = videojuegosModels.get(position).getPreguntas();
         holder.pregunta.setText(preguntas);
         String respuestas = videojuegosModels.get(position).getPreguntas();
         holder.respuesta.setText(respuestas);




        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(context)
                        .setIcon(R.drawable.baseline_gamepad_24)
                        .setTitle(preguntas)
                        .setPositiveButton("Lo sé", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })

                        .setNegativeButton("No lo sé", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                materialAlertDialogBuilder.show();
            }
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
