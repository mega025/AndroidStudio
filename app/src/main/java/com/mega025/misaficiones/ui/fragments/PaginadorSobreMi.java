package com.mega025.misaficiones.ui.fragments;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.mega025.misaficiones.fr.aficiones.Datos;
import com.mega025.misaficiones.fr.aficiones.Foto;
import com.mega025.misaficiones.fr.aficiones.Informacion;

public class PaginadorSobreMi extends FragmentPagerAdapter {
    private final Context mContext;
    public PaginadorSobreMi(Context context, FragmentManager fm){
        super(fm);
        mContext = context;
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Datos();
            case 1:
                return new Foto();
            case 2:
                return new Informacion();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
