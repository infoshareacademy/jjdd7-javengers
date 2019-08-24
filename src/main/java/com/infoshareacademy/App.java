package com.infoshareacademy;

import com.infoshareacademy.menu.RecipeAddAndEditManager;
import com.infoshareacademy.menu.MenuManager;
import com.infoshareacademy.menu.MenuPrinter;
import com.infoshareacademy.menu.UserChoice;
import com.infoshareacademy.service.RecipeService;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        RecipeService recipeService = new RecipeService();
        recipeService.loadRecipesList();
        recipeService.loadFavouritesList();
        System.out.println("\n\t\t\t\t\tWelcome to Drinkopedia!");
        MenuManager menuManager = new MenuManager();
        MenuPrinter menuPrinter = new MenuPrinter();
        menuPrinter.printEntryMenu();
        UserChoice userChoice = new UserChoice();
        int choice = userChoice.makeMenuChoice();
        menuManager.chooseMainMenuOption(choice);
    }
}
