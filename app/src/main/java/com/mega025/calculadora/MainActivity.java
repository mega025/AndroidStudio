package com.mega025.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        Button button0 = findViewById(R.id.buttonCero);
        Button button1 = findViewById(R.id.buttonUno);
        Button button2 = findViewById(R.id.buttonDos);
        Button button3 = findViewById(R.id.buttonTres);
        Button button4 = findViewById(R.id.buttonCuatro);
        Button button5 = findViewById(R.id.buttonCinco);
        Button button6 = findViewById(R.id.buttonSeis);
        Button button7 = findViewById(R.id.buttonSiete);
        Button button8 = findViewById(R.id.buttonOcoho);
        Button button9 = findViewById(R.id.buttonNueve);
        Button buttonsuma = findViewById(R.id.buttonSuma);
        Button buttonresta = findViewById(R.id.buttonResta);
        Button buttonmultiplica = findViewById(R.id.buttonMultiplicar);
        Button buttondividir = findViewById(R.id.buttonDividir);
        Button buttonigual = findViewById(R.id.buttonCalcular);
        Button buttonmasmenos = findViewById(R.id.buttonMasMenos);
        Button buttonpunto = findViewById(R.id.buttonPunto);

        TextView Pantalla = findViewById(R.id.text);
        Pantalla.setText("0");

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoPantalla = (String) Pantalla.getText();
                textoPantalla += "0";
                Pantalla.setText(textoPantalla);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoPantalla = (String) Pantalla.getText();
                textoPantalla += "1";
                Pantalla.setText(textoPantalla);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoPantalla = (String) Pantalla.getText();
                textoPantalla += "2";
                Pantalla.setText(textoPantalla);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoPantalla = (String) Pantalla.getText();
                textoPantalla += "3";
                Pantalla.setText(textoPantalla);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoPantalla = (String) Pantalla.getText();
                textoPantalla += "4";
                Pantalla.setText(textoPantalla);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoPantalla = (String) Pantalla.getText();
                textoPantalla += "5";
                Pantalla.setText(textoPantalla);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoPantalla = (String) Pantalla.getText();
                textoPantalla += "6";
                Pantalla.setText(textoPantalla);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoPantalla = (String) Pantalla.getText();
                textoPantalla += "7";
                Pantalla.setText(textoPantalla);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoPantalla = (String) Pantalla.getText();
                textoPantalla += "8";
                Pantalla.setText(textoPantalla);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoPantalla = (String) Pantalla.getText();
                textoPantalla += "9";
                Pantalla.setText(textoPantalla);
            }
        });
        buttonsuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoPantalla = (String) Pantalla.getText();
                textoPantalla += "+";
                Pantalla.setText(textoPantalla);
            }
        });
        buttonresta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoPantalla = (String) Pantalla.getText();
                textoPantalla += "-";
                Pantalla.setText(textoPantalla);
            }
        });
        buttonmultiplica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoPantalla = (String) Pantalla.getText();
                textoPantalla += "x";
                Pantalla.setText(textoPantalla);
            }
        });
        buttondividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoPantalla = (String) Pantalla.getText();
                textoPantalla += "/";
                Pantalla.setText(textoPantalla);
            }
        });
        buttonigual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoPantalla = (String) Pantalla.getText();
                textoPantalla += "=";
                Pantalla.setText(textoPantalla);
            }
        });
        buttonmasmenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoPantalla = (String) Pantalla.getText();
                textoPantalla += "+/-";
                Pantalla.setText(textoPantalla);
            }
        });
        buttonpunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoPantalla = (String) Pantalla.getText();
                textoPantalla += ".";
                Pantalla.setText(textoPantalla);
            }
        });

    }
}