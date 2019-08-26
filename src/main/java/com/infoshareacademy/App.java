package com.infoshareacademy;

import com.infoshareacademy.menu.ChoiceReader;
import com.infoshareacademy.menu.MenuManager;
import com.infoshareacademy.menu.MenuPrinter;
import com.infoshareacademy.properties.ConfigLoader;
import com.infoshareacademy.service.ClearScreenService;
import com.infoshareacademy.service.RecipeService;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException {
        ClearScreenService.cleanConsole();
        new ConfigLoader().loadAppConfig();
        RecipeService recipeService = new RecipeService();
        recipeService.loadRecipesList();
        recipeService.loadCategoriesList();
        recipeService.loadIngredientsList();
        recipeService.loadFavouritesList();
        MenuManager menuManager = new MenuManager();
        ChoiceReader choiceReader = new ChoiceReader();
        MenuPrinter menuPrinter = new MenuPrinter();
        menuPrinter.printEntryMenu();
        int choice = choiceReader.makeMenuChoice();
        menuManager.chooseMainMenuOption(choice);


    }
}
