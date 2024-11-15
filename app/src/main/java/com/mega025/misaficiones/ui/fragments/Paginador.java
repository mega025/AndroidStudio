package com.mega025.misaficiones.ui.fragments;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.mega025.misaficiones.fr.aficiones.Comer;
import com.mega025.misaficiones.fr.aficiones.Dormir;

public class Paginador extends FragmentPagerAdapter {
    private final Context mContext;
    public Paginador(Context context , FragmentManager fm){
        super(fm);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Comer();
            case 1:
                return new Dormir();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
