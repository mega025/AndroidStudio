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

import java.util.ArrayList;

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


        ArrayList<Button> buttonArrayList = new ArrayList<>();
buttonArrayList.add(findViewById(R.id.buttonCero));
buttonArrayList.add(findViewById(R.id.buttonUno));
buttonArrayList.add(findViewById(R.id.buttonDos));
buttonArrayList.add(findViewById(R.id.buttonTres));
buttonArrayList.add(findViewById(R.id.buttonCuatro));
buttonArrayList.add(findViewById(R.id.buttonCinco));
buttonArrayList.add(findViewById(R.id.buttonSeis));
buttonArrayList.add(findViewById(R.id.buttonSiete));
buttonArrayList.add(findViewById(R.id.buttonOcoho));
buttonArrayList.add(findViewById(R.id.buttonNueve));
buttonArrayList.add(findViewById(R.id.buttonSuma));
buttonArrayList.add(findViewById(R.id.buttonResta));
buttonArrayList.add(findViewById(R.id.buttonMultiplicar));
buttonArrayList.add(findViewById(R.id.buttonDividir));
buttonArrayList.add(findViewById(R.id.buttonMasMenos));
buttonArrayList.add(findViewById(R.id.buttonCalcular));
buttonArrayList.add(findViewById(R.id.buttonPunto));
buttonArrayList.add(findViewById(R.id.buttonParentesis));
buttonArrayList.add(findViewById(R.id.buttonPorcentaje));


    Button buttonBorrar = findViewById(R.id.buttonBorrar);
    Button buttonEliminar = findViewById(R.id.buttonBorrarTodo);
        TextView Pantalla = findViewById(R.id.text);

        Pantalla.setText("");

        for (Button button : buttonArrayList){
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String textoPantalla = Pantalla.getText().toString();
                    textoPantalla += button.getText().toString();
                    Pantalla.setText(textoPantalla);
                }
            });
        }


       buttonBorrar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               for (int i = Pantalla.length() - 1 ; i >= 0; i--){
                  String linea;
                   Pantalla.

               }



           }
       });


    }
}