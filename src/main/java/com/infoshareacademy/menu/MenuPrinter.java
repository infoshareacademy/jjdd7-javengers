package com.infoshareacademy.menu;

import com.infoshareacademy.service.ClearScreenService;
import org.apache.commons.text.WordUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MenuPrinter {

    public void printEntryMenu() throws IOException {

        System.out.println(GraphicContentFromFile.getGraphic("graphic.txt", StandardCharsets.US_ASCII));
        System.out.println
                ("\n=================================== MENU ===================================" +
                        "\nEnter 1 to search drink by name" +
                        "\nEnter 2 to search drink by category" +
                        "\nEnter 3 to search drink by ingredient" +
                        "\nEnter 4 to add drink to drink list" +
                        "\nEnter 5 to get list of all drinks" +
                        "\nEnter 6 to get your favourites list favourites" +
                        "\nEnter 7 to exit" +
                        "\n============================================================================");


    }

    void printMenuForDrinksByName() {

        System.out.println
                ("\n============================= DRINKS LIST MENU =============================" +
                        "\nEnter 1 to go back to main menu" +
                        "\nEnter 2 to exit" +
                        "\nOr enter a drink name (or at least 3 characters to find matching recipe):" +
                        "\n============================================================================");
    }


    void printMenuForDrinksByList(String listName) {

        String instruction = "Or enter List No or " + listName +" name(or more than one List No or " + listName +" divi- ded by a colon ',') to find recipes:";
        String wrappedInstruction = WordUtils.wrap(instruction, 77);


        System.out.println("\n============================= DRINKS LIST MENU =============================" +
                           "\nEnter 1 to back to main menu" +
                           "\nEnter 2 to exit");
        System.out.println(wrappedInstruction);
        System.out.println("============================================================================");
    }

    void printMenuForPickingARecipe() {

        System.out.println
                ("\n============================= DRINKS LIST MENU =============================" +
                        "\nEnter 1 to back to main menu" +
                        "\nEnter 2 to exit" +
                        "\nEnter 3 to go upper in the menu" +
                        "\nOr enter List No or Drink name to see a recipe: " +
                        "\n============================================================================");
    }


    void printMenuForFavourites() {

        System.out.println
                ("\n============================= YOUR FAVOURITES ===============================" +
                        "\nEnter 1 to back to main menu" +
                        "\nEnter 2 to exit" +
                        "\nEnter 3 [not implemented] toremove a drink from favourites list" +
                        "\nOr enter List No or Drink name to see a recipe: " +
                        "\n============================================================================");
    }

    void printMenuForRecipeView(String addOrRemove) {

        System.out.println
                ("\n============================== RECIPE MENU =================================" +
                        "\nEnter 1 to back to main menu" +
                        "\nEnter 2 to exit" +
                        "\nEnter 3 to go upper in the menu" +
                        "\nEnter 4 to " + addOrRemove + " drink to favourites" +
                        "\nEnter 5 to delete a recipe from Drinkopedia" +
                        "\nEnter 6 to edit a recipe " +
                        "\n============================================================================");
    }

    void printBreadcrumb(String level1, String level2, String level3, String level4) {
        System.out.println
                (level1 + "\\" + level2 + "\\" + level3 + "\\" + level4 + "\\" +
                        "\n============================================================================\n"
                );
    }

    void printBreadcrumb(String level1, String level2, String level3) {
        System.out.println
                (level1 + "\\" + level2 + "\\" + level3 + "\\" +
                        "\n============================================================================\n"
                );
    }

    void printBreadcrumb(String level1, String level2) {
        System.out.println
                (level1 + "\\" + level2 + "\\" +
                        "\n============================================================================\n"
                );
    }

    void printBreadcrumb(String level1) {
        System.out.println
                (level1 + "\\" +
                        "\n============================================================================\n"
                );
    }


    void endview() {
        System.out.println("\n============================================================================\n");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("     A place ");
        System.out.println("                        for ");
        System.out.println("                                          your ");
        System.out.println("                                                             advertisement ");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("     A place ");
        System.out.println("                        for ");
        System.out.println("                                          your ");
        System.out.println("                                                             advertisement ");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("\n============================================================================\n");
        System.out.println("                                                                by javengers ");


    }


}
