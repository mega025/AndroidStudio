package com.mega025.misaficiones;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class Favorito {
    private static Favorito instance;
    private final List<Fragment> favoritos;

    private Favorito() {
        favoritos = new ArrayList<>();
    }

    public static Favorito getInstance() {
        if (instance == null) {
            instance = new Favorito();
        }
        return instance;
    }

    public void añadirFavorito(Fragment fr) {
        if (!favoritos.contains(fr)){
            favoritos.add(fr);
        }
    }

    public List getFavoritos() {
        return favoritos;
    }
}
