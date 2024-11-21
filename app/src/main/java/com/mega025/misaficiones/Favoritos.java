package com.mega025.misaficiones;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mega025.misaficiones.ui.fragments.PagginadorFav;
import com.mega025.misaficiones.ui.main.SectionsPagerAdapter;
import com.mega025.misaficiones.databinding.ActivityFavoritosBinding;

public class Favoritos extends AppCompatActivity {

    private ActivityFavoritosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFavoritosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        PagginadorFav paginador = new PagginadorFav(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(paginador);
    }
}