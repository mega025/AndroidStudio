package com.mega025.palabraroom;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

        LiveData<List<Palabra>> palabraEvent;
        private PalabraViewModel palabraViewModel;
        // Código usado para identificar resultados de la actividades (gestiona la comunicacion entre dos actividades
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activa un diseño a pantalla completa en dispositivos modernos
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RecyclerView palabraRecycleView = findViewById(R.id.Palabra);

        final PalabraRVAdapter adapter = new PalabraRVAdapter(new PalabraRVAdapter.WordDiff(), this);

        palabraRecycleView.setAdapter(adapter);
        palabraRecycleView.setLayoutManager(new LinearLayoutManager(this));

        //getPalabra() devuelve un LiveData con la lista de palabras, y se observa para actualizar
        // automáticamente el adaptador del RecyclerView cuando los datos cambian.
        palabraViewModel = new ViewModelProvider(this).get(PalabraViewModel.class);
        palabraViewModel.getPalabra().observe(this, palabras ->
                adapter.submitList(palabras));

        // cuando pulsas el boton te lleva a la otra actividad
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener( view -> {
            Intent intent = new Intent(MainActivity.this, NuevaPalabra.class);
            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
        });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//comprueba que la solicitud que manda la otra activadad coincida y es un resultado ok
        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            //extrae la palabra que se ingreso en la otra acttividad y se crea un objeto (word) con esa palabra
            Palabra word = new Palabra(data.getStringExtra(NuevaPalabra.EXTRA_REPLY));
            //el metodo insert lo mete en la bd
            palabraViewModel.insert(word);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                   " No se guardo,porque es un campo vacío",
                    Toast.LENGTH_LONG).show();
        }
    }
}