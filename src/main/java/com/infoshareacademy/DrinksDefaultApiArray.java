package com.infoshareacademy;

import com.infoshareacademy.domain.Recipe;

import java.util.ArrayList;

public class DrinksDefaultApiArray {

    private ArrayList<Recipe> drinks;

    public ArrayList<Recipe> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<Recipe> drinks) {
        this.drinks = drinks;
    }

    @Override
    public String toString() {
        return "ArrayParserTest{" +
                "drinks='" + drinks + '\'' +
                '}';
    }
}
