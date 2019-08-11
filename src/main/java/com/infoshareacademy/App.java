package com.infoshareacademy;

import Parser.DrinksDefaultApiArray;
import Parser.Parser;

import java.lang.reflect.Array;

public class App {
    public static void main(String[] args) {


        System.out.println( "\t\tWelcome to Drinkopedia!\t\t\n" );
        MenuService menuService = new MenuService();
        ChoiceReader choiceReader = new ChoiceReader();
        menuService.printEntryMenu();
        int choice = choiceReader.makeMenuChoice();
        menuService.chooseMainMenuOption( choice );


    }



}



