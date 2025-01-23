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

        @SerializedName("strDrinkThumb")
        public String cocktailImageUrl;

        @SerializedName("idDrink")
        public String cocktailId;

        @SerializedName("strInstructions")
        public String intruciones;

        public String getIntruciones() {
            return intruciones;
        }

        public void setIntruciones(String intruciones) {
            this.intruciones = intruciones;
        }

        public String getCocktailName() {
            return cocktailName;
        }

        public void setCocktailName(String cocktailName) {
            this.cocktailName = cocktailName;
        }

        public String getCocktailImageUrl() {
            return cocktailImageUrl;
        }

        public void setCocktailImageUrl(String cocktailImageUrl) {
            this.cocktailImageUrl = cocktailImageUrl;
        }

        public String getCocktailId() {
            return cocktailId;
        }

        public void setCocktailId(String cocktailId) {
            this.cocktailId = cocktailId;
        }
    }

    public List<Cocktail> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Cocktail> drinks) {
        this.drinks = drinks;
    }
}
