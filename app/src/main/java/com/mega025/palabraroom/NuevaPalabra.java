package com.mega025.palabraroom;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.mega025.palabraroom.R;

public class NuevaPalabra extends AppCompatActivity {

//constante para pasar de vuelta las palabras que se guarde aquí a otra actividad
    public static final String EXTRA_REPLY = "com.mega025.palabraroom.MainActivity";

    private EditText mEditWordView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_palabra);
        mEditWordView = findViewById(R.id.edit_word);
//Detectar clics, donde se crea un Intent para enviar datos devuelta a la actividad donde esta el boton
        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            // si esta vacio se cancela la accion ya que no hay palabra.
            if (TextUtils.isEmpty(mEditWordView.getText())) {
                setResult(RESULT_CANCELED, replyIntent);

            } else {
                //Almacena el texto en palabra
                String palabra = mEditWordView.getText().toString();
                // replyIntent pilla el texto almacenado en palabra
                replyIntent.putExtra(EXTRA_REPLY, palabra);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}