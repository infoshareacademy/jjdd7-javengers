package com.infoshareacademy.menu;

import com.infoshareacademy.service.ClearScreenService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MenuPrinter {

    public void printEntryMenu() throws IOException {

        System.out.println(GraphicContentFromFile.getGraphic("graphic.txt", StandardCharsets.US_ASCII));
        System.out.println
                 ("=================================== MENU ===================================" +
                "\nEnter 1 to search drink by name" +
                "\nEnter 2 to search drink by category" +
                "\nEnter 3 to search drink by ingredient" +
                "\nEnter 4 to add drink to drink list" +
                "\nEnter 5 to get list of all drinks" +
                "\nEnter 6 to get your favourites list favourites" +
                "\nEnter 7 to exit" +
                "\n============================================================================");


    }

    void printMenuForDrinksByName(){

        System.out.println
                 ("============================= DRINKS LIST MENU =============================" +
                "\nEnter 1 to go back to main menu" +
                "\nEnter 2 to exit" +
                "\nOr enter a drink name (or at least 3 characters to find matching recipe):" +
                "\n============================================================================");
    }


    void printMenuForDrinksByList(String listName){

        System.out.println
                 ("============================= DRINKS LIST MENU =============================" +
                "\nEnter 1 to back to main menu" +
                "\nEnter 2 to exit" +
                "\nOr enter List No or " + listName + " name(or more than one List No or " + listName +
                        " divided by a colon ',') to find recipes: " +
                "\n============================================================================");
    }

    void printMenuForPickingARecipe(){

        System.out.println
                 ("============================= DRINKS LIST MENU =============================" +
                "\nEnter 1 to back to main menu" +
                "\nEnter 2 to exit" +
                "\nEnter 3 to go upper in the menu" +
                "\nOr enter List No or Drink name to see a recipe: " +
                "\n============================================================================");
    }




    void printMenuForFavourites(){

        System.out.println
                ("============================= YOUR FAVOURITES ===============================" +
                "\nEnter 1 to back to main menu" +
                "\nEnter 2 to exit" +
                "\nEnter 3 [not implemented] toremove a drink from favourites list" +
                "\nOr enter List No or Drink name to see a recipe: " +
                "\n============================================================================");
    }

    void printMenuForRecipeView(String addOrRemove){

        System.out.println
                 ("============================== RECIPE MENU =================================" +
                "\nEnter 1 to back to main menu" +
                "\nEnter 2 to exit" +
                "\nEnter 3 to go upper in the menu" +
                "\nEnter 4 to "+ addOrRemove+" drink to favourites" +
                "\nEnter 5 to delete a recipe from Drinkopedia" +
                "\nEnter 6 to edit a recipe " +
                "\n============================================================================");
    }


}
