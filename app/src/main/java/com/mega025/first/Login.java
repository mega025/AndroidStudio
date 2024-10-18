package com.mega025.first;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        Button logiButton = findViewById(R.id.loginBotonEntrar);
        Button loginRegistro = findViewById(R.id.loginBotonRegistrar);
        TextInputLayout Usuario = findViewById(R.id.loginUsarme);
        TextInputLayout contraseña = findViewById(R.id.loginContraseña);
        SharedPreferences preferences = getSharedPreferences("Usuario", Context.MODE_PRIVATE);

        logiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loginUsuario = String.valueOf(Usuario.getEditText().getText());
                String loginContraseña = String.valueOf(contraseña.getEditText().getText());
                String registroUsuario = preferences.getString("usasrUsuario","ANONIMO");
                String registroContraseña = preferences.getString("usarContraseña2","ANONIMO");


                if (!loginUsuario.equals(registroUsuario)){
                    Toast toastusuario = Toast.makeText(getApplicationContext(), "Pon un usuario", Toast.LENGTH_LONG);
                    toastusuario.show();
                } else if (!loginContraseña.equals(registroContraseña)) {
                    Toast toastcontraseña = Toast.makeText(getApplicationContext(), "Contraseña Incorrecta", Toast.LENGTH_LONG);
                    toastcontraseña.show();
                }else {
                    launchActivity();
                }


            }
        });
    loginRegistro.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            launchRegistro();
        }
    });

    }
    public void launchActivity(){
        Intent intent = new Intent(Login.this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    public void launchRegistro(){
        Intent intent = new Intent(Login.this,register.class);
        startActivity(intent);

    }
}