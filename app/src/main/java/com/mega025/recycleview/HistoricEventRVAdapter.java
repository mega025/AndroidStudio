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


public class HistoricEventRVAdapter extends RecyclerView.Adapter<HistoricEventRVAdapter.MyViewHolder> {

    // Contexto de la actividad o fragmento donde se utiliza el RecyclerView.
    Context context;
    ArrayList<HistoricEventModel> historicEventModels;

    // Constructor de la clase para inicializar el contexto y la lista de datos.
    public HistoricEventRVAdapter(Context context, ArrayList<HistoricEventModel> historicEventModels) {
        this.context = context;
        this.historicEventModels = historicEventModels;
    }

    // Método que se llama cuando se necesita crear un nuevo ViewHolder.
    @NonNull
    @Override
    public HistoricEventRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Crea un LayoutInflater para inflar el diseño de la fila individual (cv_row).
        LayoutInflater inflater = LayoutInflater.from(context);
        // Infla la vista de la fila desde el archivo de diseño xml.
        View view = inflater.inflate(R.layout.cv_row, parent, false);
        // Devuelve una instancia de MyViewHolder que contiene la vista inflada.
        return new HistoricEventRVAdapter.MyViewHolder(view);
    }

    // Método que enlaza los datos de la lista al ViewHolder para una posición específica.
    @Override
    public void onBindViewHolder(@NonNull HistoricEventRVAdapter.MyViewHolder holder, int position) {

        // Establece el nombre del evento en el TextView correspondiente.
        String eventName = historicEventModels.get(position).getEventName();
         holder.tvEventName.setText(eventName);


        // Establece la fecha del evento en el TextView correspondiente.
        String eventDate = historicEventModels.get(position).getEventDate();
         holder.tvEventDate.setText(eventDate);


        // Establece la ubicación del evento en el TextView correspondiente.
        String eventLocation = historicEventModels.get(position).getEventLocation();
        holder.tvEventLocation.setText(eventLocation);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(context)
                        .setIcon(R.drawable.baseline_menu_book_24)
                        .setTitle(eventName)
                        .setMessage("Este evento sucedio en el año " + eventDate)
                        .setPositiveButton("si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setNegativeButton("no", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                materialAlertDialogBuilder.show();
            }
        });
    }

    // Método que devuelve el número total de elementos en la lista.
    @Override
    public int getItemCount() {
        return historicEventModels.size(); // Retorna el tamaño de la lista de modelos.
    }

    // Clase interna que representa un ViewHolder personalizado para las filas del RecyclerView.
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // Declaramos los TextViews que mostrarán los datos del evento.
        TextView tvEventName, tvEventDate, tvEventLocation;

        // Constructor del ViewHolder que enlaza los widgets del diseño (cv_row.xml) con variables.
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // Enlaza el TextView para el nombre del evento.
            tvEventName = itemView.findViewById(R.id.eventName);
            // Enlaza el TextView para la fecha del evento.
            tvEventDate = itemView.findViewById(R.id.eventDate);
            // Enlaza el TextView para la ubicación del evento.
            tvEventLocation = itemView.findViewById(R.id.eventLocation);
        }
    }
}
