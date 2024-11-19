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

import com.mega025.misaficiones.ui.fragments.PaginadorSobreMi;
import com.mega025.misaficiones.ui.main.SectionsPagerAdapter;
import com.mega025.misaficiones.databinding.ActivitySobreMiBinding;

public class SobreMi extends AppCompatActivity {

    private ActivitySobreMiBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySobreMiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        PaginadorSobreMi sobreMi = new PaginadorSobreMi(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sobreMi);
    }
}