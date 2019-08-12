package com.infoshareacademy;

import java.util.ArrayList;

public class DrinksDefaultApiArray {

    private ArrayList<RecipeDTO> drinks;

    public ArrayList<RecipeDTO> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<RecipeDTO> drinks) {
        this.drinks = drinks;
    }

    @Override
    public String toString() {
        return "ArrayParserTest{" +
                "drinks='" + drinks + '\'' +
                '}';
    }
}
