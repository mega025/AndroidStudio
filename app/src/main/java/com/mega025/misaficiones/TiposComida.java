package com.mega025.misaficiones;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.mega025.misaficiones.databinding.ActivityTiposComidaBinding;
import com.mega025.misaficiones.ui.fragments.PaginadorComidas;

public class TiposComida extends AppCompatActivity {

    private ActivityTiposComidaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTiposComidaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        PaginadorComidas paginadorComidas = new PaginadorComidas(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(paginadorComidas);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

    }
}