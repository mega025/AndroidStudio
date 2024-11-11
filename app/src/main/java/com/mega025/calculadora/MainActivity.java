package com.mega025.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String ope = "";
    private TextView pantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pantalla = findViewById(R.id.text);


        ArrayList<Button> buttonArrayList = new ArrayList<>();
        buttonArrayList.add(findViewById(R.id.buttonCero));
        buttonArrayList.add(findViewById(R.id.buttonUno));
        buttonArrayList.add(findViewById(R.id.buttonDos));
        buttonArrayList.add(findViewById(R.id.buttonTres));
        buttonArrayList.add(findViewById(R.id.buttonCuatro));
        buttonArrayList.add(findViewById(R.id.buttonCinco));
        buttonArrayList.add(findViewById(R.id.buttonSeis));
        buttonArrayList.add(findViewById(R.id.buttonSiete));
        buttonArrayList.add(findViewById(R.id.buttonOcho));
        buttonArrayList.add(findViewById(R.id.buttonNueve));
        buttonArrayList.add(findViewById(R.id.buttonSuma));
        buttonArrayList.add(findViewById(R.id.buttonResta));
        buttonArrayList.add(findViewById(R.id.buttonMultiplicar));
        buttonArrayList.add(findViewById(R.id.buttonDividir));
        buttonArrayList.add(findViewById(R.id.buttonPunto));


        for (Button button : buttonArrayList) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String textoPantalla = pantalla.getText().toString();
                    textoPantalla += button.getText().toString();
                    pantalla.setText(textoPantalla);
                }
            });
        }


        Button buttonCalcular = findViewById(R.id.buttonCalcular);
        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              
                calcularResultado(view);
            }
        });

        Button buttonBorrar = findViewById(R.id.buttonBorrar);
        buttonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                borrarUltimoCaracter(view);
            }
        });


        Button buttonEliminar = findViewById(R.id.buttonBorrarTodo);
        buttonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpiarPantalla();
            }
        });
    }


    public void operar(View view) {
        if (!pantalla.getText().toString().isEmpty() && ope.isEmpty()) {
            Button boton = (Button) view;
            pantalla.setText(pantalla.getText().toString() + boton.getText().toString());
            ope = boton.getText().toString();
        }
    }

    public void calcularResultado(View view) {
        String[] operandos = pantalla.getText().toString().split("\\" + ope);
        if (operandos.length == 2) {
            double num1 = Double.parseDouble(operandos[0]);
            double num2 = Double.parseDouble(operandos[1]);
            double resultado = 0;

            switch (ope) {
                case "+":
                    resultado = num1 + num2;
                    break;
                case "-":
                    resultado = num1 - num2;
                    break;
                case "x":
                    resultado = num1 * num2;
                    break;
                case "÷":
                    resultado = num1 / num2;
                    break;
            }

            pantalla.setText(resultado % 1 == 0 ? String.valueOf((int) resultado) : String.valueOf(resultado));
            ope = "";
        }
    }

    public void borrarUltimoCaracter(View view) {
        String texto = pantalla.getText().toString();
        if (!texto.isEmpty()) {
            pantalla.setText(texto.substring(0, texto.length() - 1));
        }
    }

    public void limpiarPantalla() {
        pantalla.setText("");
        ope = "";
    }
}