package com.mega025.palabraroom;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class PalabraViewModel  extends AndroidViewModel {
    private PalabraRepository mPalabraRepository;
    private final LiveData<List<Palabra>> mPalabra;

    public PalabraViewModel(@NonNull Application application) {
        super(application);
        mPalabraRepository = new PalabraRepository(application);
        mPalabra = mPalabraRepository.getAllPalabras();
    }

    LiveData<List<Palabra>> getPalabra(){
        return mPalabra;
    }

    public  void insert (Palabra palabra){
        mPalabraRepository.insert(palabra);
    }



}
