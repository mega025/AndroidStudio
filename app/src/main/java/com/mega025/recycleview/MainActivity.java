package com.mega025.recycleview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mega025.recycleview.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
        ArrayList<HistoricEventModel> historicEvents = new ArrayList<>();
        ArrayList<VideojuegosModel> videojuegosModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RecyclerView historicalRecycleView = findViewById(R.id.recycleViewHistoricEvents);
        setVideojuegos();

        HistoricEventRVAdapter adapter = new HistoricEventRVAdapter(this, historicEvents);

        VideojuegosRVAdapter adapter1 = new VideojuegosRVAdapter(this, videojuegosModels);
        historicalRecycleView.setAdapter(adapter1);
        historicalRecycleView.setLayoutManager(new LinearLayoutManager(this));



    }

    private void setHistoricEvents(){
        String [] eventNames = getResources().getStringArray(R.array.historic_event_names);
        String [] eventDates = getResources().getStringArray(R.array.historic_event_dates);
        String [] eventLocation = getResources().getStringArray(R.array.historic_event_location);

        for (int i = 0; i < eventNames.length; i++) {
            historicEvents.add(new HistoricEventModel(
                    eventNames[i],
                    eventDates[i],
                    eventLocation[i]
            )
            );
            
        }
    }

    private void setVideojuegos() {
        String[] preguntas = getResources().getStringArray(R.array.Preguntas);
        String[] respuestas = getResources().getStringArray(R.array.Respuestas);


        ArrayList<String[]> opcionesList = new ArrayList<>();
        opcionesList.add(new String[]{"Tetris", "Minecraft", "GTA V", "Call of Duty"}); // ¿Cuál es el juego más vendido de todos los tiempos?
        opcionesList.add(new String[]{ "Zelda","Link", "Epona", "Ganon"}); // ¿Cuál es el personaje principal de la saga The Legend of Zelda?
        opcionesList.add(new String[]{"Epic Games", "Ubisoft", "EA Sports", "Valve"}); // ¿Qué compañía desarrolló el juego Fortnite?
        opcionesList.add(new String[]{"Shigeru Miyamoto", "Hideo Kojima", "Satoru Iwata", "Yuji Naka"}); // ¿Cómo se llama el creador de Super Mario Bros?
        opcionesList.add(new String[]{"Charmander", "Squirtle", "Bulbasaur", "Pikachu"}); // ¿Cuál es el Pokémon inicial tipo fuego en la primera generación?
        opcionesList.add(new String[]{"PlayStation", "Nintendo 64", "Sega Saturn", "Dreamcast"}); // ¿Qué consola fue la primera en usar CDs en lugar de cartuchos?
        opcionesList.add(new String[]{"Hideo Kojima", "Shigeru Miyamoto", "Gabe Newell", "Todd Howard"}); // ¿Cómo se llama el creador de Metal Gear Solid?
        opcionesList.add(new String[]{"PUBG", "Fortnite", "Free Fire", "Apex Legends"}); // ¿Qué saga de videojuegos popularizó el género Battle Royale?
        opcionesList.add(new String[]{"Fallout", "Skyrim", "Mass Effect", "Cyberpunk 2077"}); // ¿En qué juego se utiliza la herramienta llamada "Pip-Boy"?
        opcionesList.add(new String[]{"PlayStation", "Sega CD", "Nintendo CD", "Philips CD-i"}); // ¿Qué nombre tenía la primera consola de videojuegos de Sony?
        opcionesList.add(new String[]{"Tetris", "Minecraft", "Candy Crush", "Puyo Puyo"}); // ¿En qué videojuego debes destruir líneas de bloques para ganar?
        opcionesList.add(new String[]{"World of Warcraft", "League of Legends", "Elder Scrolls Online", "Guild Wars"}); // ¿Qué videojuego incluye los reinos de Azeroth, Kalimdor y Northrend?
        opcionesList.add(new String[]{"Los Santos", "Liberty City", "Vice City", "San Fierro"}); // ¿Cómo se llama la ciudad principal en Grand Theft Auto V?
        opcionesList.add(new String[]{"Animal Crossing", "Harvest Moon", "Stardew Valley", "The Sims"}); // ¿Qué juego de Nintendo incluye un pueblo lleno de animales antropomórficos?
        opcionesList.add(new String[]{"Zebes", "SR388", "Tallon IV", "Brinstar"}); // ¿En qué planeta se desarrolla la mayoría de los juegos de la saga Metroid?

        for (int i = 0; i < preguntas.length; i++) {
            ArrayList<String> opciones = new ArrayList<>(List.of(opcionesList.get(i)));
            videojuegosModels.add(new VideojuegosModel(
                    preguntas[i],
                    respuestas[i],
                    opciones
            ));
        }
    }

}
