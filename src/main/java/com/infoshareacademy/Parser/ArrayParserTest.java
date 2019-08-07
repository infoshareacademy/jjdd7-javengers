package com.infoshareacademy.Parser;

import java.util.ArrayList;

public class ArrayParserTest {

    private ArrayList<ParserTest> drinks;

    public ArrayList<ParserTest> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<ParserTest> drinks) {
        this.drinks = drinks;
    }

    @Override
    public String toString() {
        return "ParserTest{" +
                "drinks='" + drinks + '\''  +
                '}';
    }
}
