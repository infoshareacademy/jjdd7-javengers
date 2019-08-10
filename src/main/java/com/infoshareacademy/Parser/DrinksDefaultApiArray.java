package com.infoshareacademy.Parser;

import java.util.ArrayList;

public class DrinksDefaultApiArray {

    //class Field
    private ArrayList<ParserTest> drinks;

    //getters & setters
    //if used for other text file need to change the line below!!
    public ArrayList<ParserTest> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<ParserTest> drinks) {
        this.drinks = drinks;
    }

    @Override
    public String toString() {
        return "ArrayParserTest{" +
                "drinks='" + drinks + '\'' +
                '}';
    }
}
