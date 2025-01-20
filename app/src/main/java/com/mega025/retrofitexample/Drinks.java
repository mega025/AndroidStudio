package com.mega025.retrofitexample;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Drinks {
    @SerializedName("drinks")
    List<Cocktail> drinks = new ArrayList<>();

    public class Cocktail{
        @SerializedName("strDrink")
        public String cocktailName;

        @SerializedName("strDrinksThum")
public  String cocktailImageUrl;

        @SerializedName("idDrink")
        public String cocktailId;

    }

    public List<Cocktail> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Cocktail> drinks) {
        this.drinks = drinks;
    }
}
