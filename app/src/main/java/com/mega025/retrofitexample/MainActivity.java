package com.mega025.retrofitexample;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TextView principal = findViewById(R.id.principal);
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Drinks> call = apiInterface.getDrinksByLicour("Gin");
        call.enqueue(new Callback<Drinks>() {
            @Override
            public void onResponse(Call<Drinks> call, Response<Drinks> response) {
                Log.d("Código", response.code()+ "");
                Drinks drinks = response.body();
                String todaLaInformacion ="";
                for (Drinks.Cocktail cocktail : drinks.drinks){
                    todaLaInformacion += cocktail.cocktailName + "\n";
                }
                Log.d("TodaLaInfo", todaLaInformacion);
                principal.setText(todaLaInformacion);
            }

            @Override
            public void onFailure(Call<Drinks> call, Throwable throwable) {
                Log.d("CALL -> mal", throwable.toString());

            }
        });
    }
}