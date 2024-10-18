package com.mega025.first;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView Bienvenido = findViewById(R.id.welcomeText);
        TextView parrafo = findViewById(R.id.addedText);

        SharedPreferences preferences = getSharedPreferences("Usuario",Context.MODE_PRIVATE);
        String name = preferences.getString("usarUsuario","anonimo");
        String contraseña = preferences.getString("usarContraseña","contraseña");

        Bienvenido.setText("Bienvenido " + name);
        parrafo.setText("prueba p " + contraseña);
    }
}