package com.mega025.first;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

public class register extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        TextInputLayout usuario = findViewById(R.id.registroUsarme);
        TextInputLayout contraseña = findViewById(R.id.registroContraseña);
        TextInputLayout contraseña2 = findViewById(R.id.registroContraseña2);
        Button registrarBoton = findViewById(R.id.loginBotonRegistrarse);
        TextInputLayout correo = findViewById(R.id.registroCorreo);

        registrarBoton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String usarUsuario  = String.valueOf(usuario.getEditText().getText());
                String usarContraseña  = String.valueOf(contraseña.getEditText().getText());
                String usarContraseña2  = String.valueOf(contraseña2.getEditText().getText());
                String gmail = String.valueOf(correo.getEditText().getText());

                if (!usarContraseña.equals(usarContraseña2)){
                    Toast toastcontraseña = Toast.makeText(getApplicationContext(), "Contraseña Incorrecta", Toast.LENGTH_LONG);
                    toastcontraseña.show();
                } else if (usarUsuario.equals("")) {
                    Toast toastusuario = Toast.makeText(getApplicationContext(), "Pon un usuario", Toast.LENGTH_LONG);
                    toastusuario.show();

                } else if (gmail.equals("")) {
                    Toast toastgmail = Toast.makeText(getApplicationContext(), "Pon un ussario", Toast.LENGTH_LONG);
                    toastgmail.show();
                } else {
                    Toast confirmado = Toast.makeText(getApplicationContext(), "Te has registrado correctamente", Toast.LENGTH_SHORT);
                    confirmado.show();
                    SharedPreferences preferences = getSharedPreferences("Usuario", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("usasrUsuario", usarUsuario);
                    editor.putString("usarContraseña", usarContraseña);
                    editor.putString("usarContraseña2", usarContraseña2);
                    editor.putString("usarCorreo", gmail);

                    editor.apply();
                    launchActivity();
                }


            }
        });


    }
    public void launchActivity(){
        Intent intent = new Intent(register.this,Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}