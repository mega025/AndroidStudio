package com.mega025.misaficiones.ui.fragments;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.mega025.misaficiones.Favorito;

import java.util.List;

public class PagginadorFav extends FragmentPagerAdapter {

    private final Context mContext;

    public PagginadorFav(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        List<Fragment> favoritos = Favorito.getInstance().getFavoritos();
        return favoritos.get(position);
    }

    @Override
    public int getCount() {
        return Favorito.getInstance().getFavoritos().size();
    }
}