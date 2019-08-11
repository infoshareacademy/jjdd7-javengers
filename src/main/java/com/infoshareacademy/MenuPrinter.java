package com.infoshareacademy;

public class MenuPrinter {

    void printEntryMenu() {
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

    void printMenuForDrinksList() {
        System.out.println("=========== DRINKS LIST MENU ==========="+
                "\nEnter 1 to remove drink from drink list" +
                "\nEnter 2 to add your drink to favourites" +
                "\nEnter 3 to back to main menu" +
                "\nEnter 4 to exit\n"+
                "==========================================");
    }

    void printMenuForFavourites() {
        System.out.println("============ YOUR FAVOURITES =============" +
                "\nEnter 1 to add drink to favourites" +
                "\nEnter 2 to remove drink from favourites" +
                "\nEnter 3 to back to main menu" +
                "\nEnter 4 to exit\n"+
                "==========================================");
    }

}
