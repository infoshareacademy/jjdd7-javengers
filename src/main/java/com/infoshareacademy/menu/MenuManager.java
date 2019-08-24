package com.infoshareacademy.menu;

import com.infoshareacademy.domain.Recipe;
import com.infoshareacademy.domain.RecipeRepository;
import com.infoshareacademy.service.ClearScreenService;
import com.infoshareacademy.service.RecipeService;

import java.io.IOException;
import java.util.List;


public class MenuManager {
    private RecipeService recipeManager = new RecipeService();
    private ChoiceReader choiceReader = new ChoiceReader();
    private ListsPrinter listsPrinter = new ListsPrinter();
    private MenuPrinter menuPrinter = new MenuPrinter();
    RecipeAddAndEditManager recipeAddition = new RecipeAddAndEditManager();


    public void chooseMainMenuOption(int choice) throws IOException, InterruptedException {

        List<String> userChoiceSecond;
        switch (choice) {
            case 1:
                ClearScreenService.cleanConsole();
                listsPrinter.printImage();
                menuPrinter.printMenuForDrinksByName();
                userChoiceSecond = choiceReader.userInputForDrinkNameCheck(RecipeRepository.getRecipesList());
                if (userChoiceSecond.size() == 1 && userChoiceSecond.get(0).matches("[0-9]")) {
                    numericMenuChoices(userChoiceSecond.get(0));
                } else {
                    ClearScreenService.cleanConsole();
                    listsPrinter.printAllRecipes(recipeManager.findRecipeByName(RecipeRepository
                            .getRecipesList(), userChoiceSecond));
                    menuPrinter.printMenuForPickingARecipe();
                    List<String> userChoiceMidle = choiceReader.userInputForFinalPickFromList(recipeManager.findRecipeByName(RecipeRepository
                            .getRecipesList(), userChoiceSecond));
                    if (userChoiceMidle.size() == 1 && userChoiceMidle.get(0).matches("[0-9]")) {
                        numericMenuChoices(userChoiceMidle.get(0));
                    } else {
                        ClearScreenService.cleanConsole();
                        listsPrinter.printRecipe(recipeManager.findRecipeByName(RecipeRepository
                                .getRecipesList(), userChoiceMidle));
                        menuPrinter.printMenuForRecipeView();
                        List<String> userChoiceFinal = choiceReader.userInputForRecipeView();
                        numericMenuChoices(userChoiceFinal.get(0), recipeManager.findRecipeByName(RecipeRepository
                                .getRecipesList(), userChoiceMidle));
                    }
                }

                break;
            case 2:
                ClearScreenService.cleanConsole();
                listsPrinter.printCategory(RecipeRepository.getCategoriesList());
                menuPrinter.printMenuForDrinksByList("category");
                userChoiceSecond = choiceReader.userInputForListsCheck(RecipeRepository.getCategoriesList());
                if (userChoiceSecond.size() == 1 && userChoiceSecond.get(0).matches("[0-9]")) {
                    numericMenuChoices(userChoiceSecond.get(0));
                } else {
                    ClearScreenService.cleanConsole();
                    listsPrinter.printAllRecipes(recipeManager.findRecipeByCategory(RecipeRepository
                            .getRecipesList(), userChoiceSecond));
                    menuPrinter.printMenuForPickingARecipe();
                    List<String> userChoiceMidle = choiceReader.userInputForFinalPickFromList(recipeManager.findRecipeByCategory(RecipeRepository
                            .getRecipesList(), userChoiceSecond));
                    if (userChoiceMidle.size() == 1 && userChoiceMidle.get(0).matches("[0-9]")) {
                        numericMenuChoices(userChoiceMidle.get(0));
                    } else {
                        ClearScreenService.cleanConsole();
                        listsPrinter.printRecipe(recipeManager.findRecipeByName(RecipeRepository
                                .getRecipesList(), userChoiceMidle));
                        menuPrinter.printMenuForRecipeView();
                        List<String> userChoiceFinal = choiceReader.userInputForRecipeView();
                        numericMenuChoices(userChoiceFinal.get(0), recipeManager.findRecipeByName(RecipeRepository
                                .getRecipesList(), userChoiceMidle));
                    }
                }

                break;
            case 3:
                ClearScreenService.cleanConsole();
                listsPrinter.printCategory(RecipeRepository.getIngredientsList());
                menuPrinter.printMenuForDrinksByList("ingredient");
                userChoiceSecond = choiceReader.userInputForListsCheck(RecipeRepository.getIngredientsList());
                if (userChoiceSecond.size() == 1 && userChoiceSecond.get(0).matches("[0-9]")) {
                    numericMenuChoices(userChoiceSecond.get(0));
                } else {
                    //toDO
                    ClearScreenService.cleanConsole();
                    listsPrinter.printAllRecipes(recipeManager.findRecipeByIngredients(RecipeRepository
                            .getRecipesList(), userChoiceSecond));
                    menuPrinter.printMenuForPickingARecipe();
                    List<String> userChoiceMidle = choiceReader.userInputForFinalPickFromList(recipeManager.findRecipeByIngredients(RecipeRepository
                            .getRecipesList(), userChoiceSecond));
                    if (userChoiceMidle.size() == 1 && userChoiceMidle.get(0).matches("[0-9]")) {
                        numericMenuChoices(userChoiceMidle.get(0));
                    } else {
                        ClearScreenService.cleanConsole();
                        listsPrinter.printRecipe(recipeManager.findRecipeByName(RecipeRepository
                                .getRecipesList(), userChoiceMidle));
                        menuPrinter.printMenuForRecipeView();
                        List<String> userChoiceFinal = choiceReader.userInputForRecipeView();
                        numericMenuChoices(userChoiceFinal.get(0), recipeManager.findRecipeByName(RecipeRepository
                                .getRecipesList(), userChoiceMidle));
                    }
                }
                break;
            case 4:
                ClearScreenService.cleanConsole();
                listsPrinter.printCategory(RecipeRepository.getCategoriesList());
                System.out.println("Enter category name of recipe from list or specify your own: ");
                recipeManager.addRecipeToList(recipeAddition.createNewRecipe());
                printMainMenuService();
                break;
            /*case 5: - to do wywalenia ale moze jeszcze sie przydac w favouritach w drzewku nizej
                System.out.println("\nEnter drink name to remove from recipe list");
                userChoice = choiceReader.makeChoice();
                System.out.println("\nThere will be method to remove " + userChoice + " from drink list\n");
                printMainMenuService();
                break;*/
            case 5:
                ClearScreenService.cleanConsole();
                listsPrinter.printAllRecipes(RecipeRepository.getRecipesList());
                menuPrinter.printMenuForPickingARecipe();
                /*List<String> userChoiceMidle byl wczesniej*/
                userChoiceSecond = choiceReader.userInputForFinalPickFromList(RecipeRepository.getRecipesList());
                if (userChoiceSecond.size() == 1 && userChoiceSecond.get(0).matches("[0-9]")) {
                    numericMenuChoices(userChoiceSecond.get(0));
                } else {
                    ClearScreenService.cleanConsole();
                    listsPrinter.printRecipe(recipeManager.findRecipeByName(RecipeRepository
                            .getRecipesList(), userChoiceSecond));
                    menuPrinter.printMenuForRecipeView();
                    List<String> userChoiceFinal = choiceReader.userInputForRecipeView();
                    numericMenuChoices(userChoiceFinal.get(0));
                }
                break;
            case 6:
                //toDO
                listsPrinter.printAllRecipes(RecipeRepository.getFavouritesRecipeList());
                printMenuForFavouritesService();
                break;
            case 7:
                break;
            default:
                System.out.println("\n wrong choice, type one more time");
                printMainMenuService();

        }
    }

    //do zaorania
    private void chooseFavouritesMenuOption(int choice) throws IOException, InterruptedException {
        String nameOfDrink;
        ChoiceReader choiceReader = new ChoiceReader();
        switch (choice) {
            case 1:
                System.out.println("\nEnter drink name");
                nameOfDrink = choiceReader.makeChoice();
                System.out.println("There will be method to add" + nameOfDrink + " to favourites\n");
                printMainMenuService();
                break;
            case 2:
                System.out.println("\nEnter drink name");
                nameOfDrink = choiceReader.makeChoice();
                System.out.println("There will be method to remove" + nameOfDrink + " from favourites\n");
                printMainMenuService();
                break;
            case 3:
                System.out.println("\nEnter drink name to remove from recipe list");
                String userChoice = recipeAddition.loadRecipeAttributes();
                recipeManager.deleteRecipeFromList(userChoice);
                printMainMenuService();
                printMainMenuService();
                break;
            case 4:
                break;
            default:
                System.out.println("\nwrong choice");
                menuPrinter.printMenuForFavourites();
                choice = choiceReader.makeMenuChoice();
                chooseFavouritesMenuOption(choice);
                break;
        }
    }

    private void printMainMenuService() throws IOException, InterruptedException {
        menuPrinter.printEntryMenu();
        int choice = choiceReader.makeMenuChoice();
        chooseMainMenuOption(choice);
    }

    //do zaorania
    private void printMenuForFavouritesService() throws IOException, InterruptedException {
        menuPrinter.printMenuForFavourites();
        int choice = choiceReader.makeMenuChoice();
        chooseFavouritesMenuOption(choice);
    }


    private void numericMenuChoices(String menuChoice) throws IOException, InterruptedException {
        ClearScreenService.cleanConsole();
        switch (menuChoice) {
            case "1":
                menuPrinter.printEntryMenu();
                int choice = choiceReader.makeMenuChoice();
                chooseMainMenuOption(choice);
                break;
            case "2":
                System.exit(0);

        }
    }

    private void numericMenuChoices(String menuChoice, List<Recipe> recipe) throws
            IOException, InterruptedException {
        ClearScreenService.cleanConsole();
        switch (menuChoice) {
            case "1":
                menuPrinter.printEntryMenu();
                int choice = choiceReader.makeMenuChoice();
                chooseMainMenuOption(choice);
                break;
            case "2":
                System.exit(0);
            case "3":
                System.out.println("\nEnter drink name to remove from recipe list");
                String userChoice = recipeAddition.loadRecipeAttributes();
                recipeManager.deleteRecipeFromList(userChoice);
                printMainMenuService();
                System.exit(0);
            case "4":
                //miejsce na add/remove from Favourites
                System.exit(0);
        }
    }
}