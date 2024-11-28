package com.mega025.first;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
                // crear la mini ventana en medio de la pantalla
                MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(MainActivity.this)
                        .setTitle("Hola "+ name )
                        .setMessage("¿Estan bien tu nombre y apellido?")
                        .setPositiveButton("Ese no es mi nombre", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // mensaje que te sale abajo durante un rato
                                Snackbar.make(view, "¿Desea cambiar su nombre?", Snackbar.LENGTH_SHORT)
                                        .setAction("Cambiar", new View.OnClickListener() {

                                            @Override
                                            public void onClick(View view) {
                                                LayoutInflater linf = LayoutInflater.from(MainActivity.this); // creas una bolsa en la pantalla para guardar lo que vayas a usar
                                                final View inflator = linf.inflate(R.layout.cambiar_nombre, null); //Pones lo que necesitas en la bolsa
                                                MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(MainActivity.this)
                                                        .setTitle("Cambiar nombre")
                                                        .setView(inflator)

                                                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {

                                                            @Override
                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                EditText cambioDeNombreTexto = inflator.findViewById(R.id.cambioDeNombreTexto); // coges de la bolsa lo mas necesario
                                                                String nombreReal = cambioDeNombreTexto.getText().toString();

                                                                SharedPreferences preferences = getSharedPreferences("Usuario", Context.MODE_PRIVATE); //abres el armario
                                                                SharedPreferences.Editor editor = preferences.edit(); // cambias los datos dentro del armario ( es privado)
                                                                editor.putString("name", nombreReal); // confirmas los cambios que has hecho
                                                                Bienvenido.setText("Hola "+nombreReal); // alguien abre el armario pero solo puede ver sus datos cambiado o sin cambiar
                                                            }
                                                        });
                                                materialAlertDialogBuilder.show();
                                            }
                                        })
                                        .show();
                            }
                        })

                        .setNegativeButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

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