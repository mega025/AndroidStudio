package com.mega025.retrofitexample;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class DrinksViewModel extends AndroidViewModel {

    private Drinks drinks;

    public DrinksViewModel(@NonNull Application application) {
        super(application);
    }
}
