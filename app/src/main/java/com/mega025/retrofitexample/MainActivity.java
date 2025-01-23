package com.mega025.retrofitexample;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Drinks.Cocktail> lista;
    RecyclerView principal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        principal = findViewById(R.id.Cocktails);
        principal.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        showDrinks();
    }

    public void showDrinks(){

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.edit);
                String filtroguardado = editText.getText().toString();
                Call<Drinks> call = ApiClient.getClient().create(ApiInterface.class).getDrinksByLicour(filtroguardado);
                call.enqueue(new Callback<Drinks>() {
                    @Override
                    public void onResponse(Call<Drinks> call, Response<Drinks> response) {
                        if (response.isSuccessful()){
                            Drinks drinks =response.body();
                            lista = drinks.getDrinks();
                            DrinksRVAdapter adapter = new DrinksRVAdapter(lista);
                            principal.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<Drinks> call, Throwable throwable) {
                        Toast.makeText(MainActivity.this,"error", Toast.LENGTH_SHORT);
                    }
                });
            }
        });

    }
}