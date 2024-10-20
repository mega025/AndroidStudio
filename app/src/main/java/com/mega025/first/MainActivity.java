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


        SharedPreferences preferences = getSharedPreferences("Usuario",Context.MODE_PRIVATE);
        String name = preferences.getString("usasrUsuario","anonimo");


        Bienvenido.setText("Bienvenido a la mejor de APP de senderismo " + name);


    }
}