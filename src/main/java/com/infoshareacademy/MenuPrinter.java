package com.infoshareacademy;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MenuPrinter {

    void printEntryMenu() throws IOException {
        System.out.println(GraphicContentFromFile.getGraphic( "graphic.txt", StandardCharsets.US_ASCII));
        System.out.println("================ MENU ================" +
                "\nEnter 1 to search drink by name" +
                "\nEnter 2 to search drink by category" +
                "\nEnter 3 to search drink by ingredient" +
                "\nEnter 4 to add drink to drink list" +
                "\nEnter 5 to remove drink from drink list" +
                "\nEnter 6 to get list of drinks" +
                "\nEnter 7 to get your favourites" +
                "\nEnter 8 to exit\n"+
                "=======================================");
    }

    void printMenuForDrinksList() throws IOException {
        System.out.println(GraphicContentFromFile.getGraphic( "graphic.txt", StandardCharsets.US_ASCII));
        System.out.println("=========== DRINKS LIST MENU ==========="+
                "\nEnter 1 to remove drink from drink list" +
                "\nEnter 2 to add your drink to favourites" +
                "\nEnter 3 to back to main menu" +
                "\nEnter 4 to exit\n"+
                "==========================================");
    }

    void printMenuForFavourites() throws IOException {
        System.out.println(GraphicContentFromFile.getGraphic( "graphic.txt", StandardCharsets.US_ASCII));
        System.out.println("============ YOUR FAVOURITES =============" +
                "\nEnter 1 to add drink to favourites" +
                "\nEnter 2 to remove drink from favourites" +
                "\nEnter 3 to back to main menu" +
                "\nEnter 4 to exit\n"+
                "==========================================");
    }

}
