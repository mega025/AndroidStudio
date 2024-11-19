package com.mega025.misaficiones;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.mega025.misaficiones.databinding.ActivityAficionesBinding;
import com.mega025.misaficiones.ui.fragments.Paginador;

public class Aficiones extends AppCompatActivity {

    private ActivityAficionesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAficionesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Paginador paginador = new Paginador(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(paginador);
        }

        public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_sobre_mi, menu);
        return true;
        }

        public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int id = item.getItemId();
        if (id == R.id.favButton){
            Toast toast = Toast.makeText(this, "como me gusta mis aficciones", Toast.LENGTH_SHORT);
            toast.show();
        }
        if (id == R.id.aboutMeButton){
            Intent intent = new Intent(Aficiones.this, SobreMi.class);

                    startActivity(intent);
        }
        if (id == R.id.myCodeButton){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://github.com/mega025"));
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
        }
}