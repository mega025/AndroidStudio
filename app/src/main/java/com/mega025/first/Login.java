package com.mega025.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        Button logiButton = findViewById(R.id.loginBotonEntrar);
        TextView loginRegistro = findViewById(R.id.loginBotonRegistrar);

        logiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity();
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