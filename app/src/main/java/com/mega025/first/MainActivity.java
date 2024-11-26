package com.mega025.first;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView Bienvenido = findViewById(R.id.welcomeText);


        SharedPreferences preferences = getSharedPreferences("Usuario",Context.MODE_PRIVATE);
        String name = preferences.getString("usasrUsuario","anonimo");


        Bienvenido.setText("Bienvenido a la mejor APP de senderismo " + name);


        Button callDialogButton  = findViewById(R.id.verMas);
        callDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(MainActivity.this)
                .setTitle("Hola " + name)
                .setMessage("¿Quieres cambiar de nombre ?")
                .setPositiveButton("si", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Snackbar.make(view, "cambiar nombre", Snackbar.LENGTH_SHORT)
                                .setAction("Cambiar", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Toast.makeText(MainActivity.this, "Clic", Toast.LENGTH_SHORT).show();

                                    }
                                }).show();

                    }


                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                materialAlertDialogBuilder.show();

            }
        });


        // dialog forma antigua
        Bienvenido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                dialogBuilder.setMessage("hola" + name);
                dialogBuilder.setCancelable(true);
                dialogBuilder.setPositiveButton("Si soy yo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                dialogBuilder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();
            }
        });

    }
}