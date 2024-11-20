package com.mega025.misaficiones;

import android.os.Bundle;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.mega025.misaficiones.ui.fragments.PaginadorSobreMi;
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