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


    public void chooseMainMenuOption(int choice) throws IOException, InterruptedException {

        String userChoice;
        List<String> userChoiceSecond;
        switch (choice) {
            case 1:
                ClearScreenService.cleanConsole();
                listsPrinter.printImage();
                menuPrinter.printMenuForDrinksByName();
                userChoiceSecond = choiceReader.userInputForDrinkNameCheck(RecipeRepository.getRecipesList());
                if (userChoiceSecond.size() == 1 && userChoiceSecond.get(0).matches("[0-9]")) {
                    numericMenuChoicesMiddle(userChoiceSecond.get(0));
                } else {
                    middleMenuViewActions(recipeManager.findRecipeByName(RecipeRepository.getRecipesList(), userChoiceSecond));
                }

                break;
            case 2:
                ClearScreenService.cleanConsole();
                listsPrinter.printCategory(RecipeRepository.getCategoriesList());
                menuPrinter.printMenuForDrinksByList("category");
                userChoiceSecond = choiceReader.userInputForListsCheck(RecipeRepository.getCategoriesList());
                if (userChoiceSecond.size() == 1 && userChoiceSecond.get(0).matches("[0-9]")) {
                    numericMenuChoicesMiddle(userChoiceSecond.get(0));
                } else {
                    middleMenuViewActions(recipeManager.findRecipeByCategory(RecipeRepository
                            .getRecipesList(), userChoiceSecond));
                }

                break;
            case 3:
                ClearScreenService.cleanConsole();
                listsPrinter.printCategory(RecipeRepository.getIngredientsList());
                menuPrinter.printMenuForDrinksByList("ingredient");
                userChoiceSecond = choiceReader.userInputForListsCheck(RecipeRepository.getIngredientsList());
                if (userChoiceSecond.size() == 1 && userChoiceSecond.get(0).matches("[0-9]")) {
                    numericMenuChoicesMiddle(userChoiceSecond.get(0));
                } else {
                    ClearScreenService.cleanConsole();
                    middleMenuViewActions(recipeManager.findRecipeByIngredients(RecipeRepository
                            .getRecipesList(), userChoiceSecond));
                }
                break;
            case 4:
                ClearScreenService.cleanConsole();
                listsPrinter.printCategory(RecipeRepository.getCategoriesList());
                System.out.println("\nChoose available category or enter a new category, \n" +
                        "to which your new recipe will be added\n");
                userChoice = choiceReader.makeChoice();
                System.out.println("\nThere will be method used to  add" + userChoice
                        + " to drink list based on categories\n");
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
                userChoiceSecond = choiceReader.userInputForFinalPickFromList(RecipeRepository.getRecipesList());
                if (userChoiceSecond.size() == 1 && userChoiceSecond.get(0).matches("[0-9]")) {
                    numericMenuChoicesUnderTop(userChoiceSecond.get(0));
                } else {
                    lowestMenuViewActions(userChoiceSecond, RecipeRepository.getRecipesList());
                }
                break;
            case 6:
                ClearScreenService.cleanConsole();
                listsPrinter.printAllRecipes(RecipeRepository.getFavouritesRecipeList());
                menuPrinter.printMenuForFavourites();
                userChoiceSecond = choiceReader.userInputForFinalPickFromList(RecipeRepository.getFavouritesRecipeList());
                if (userChoiceSecond.size() == 1 && userChoiceSecond.get(0).matches("[0-9]")) {
                    numericMenuChoicesUnderTop(userChoiceSecond.get(0));
                } else {
                    lowestMenuViewActions(userChoiceSecond, RecipeRepository.getRecipesList());
                }
                break;
            case 7:
                exitFromMenu();
                break;
            default:
                System.out.println("\n wrong choice, type one more time");
                printMainMenuService();
        }
    }


    private void printMainMenuService() throws IOException, InterruptedException {
        menuPrinter.printEntryMenu();
        int choice = choiceReader.makeMenuChoice();
        chooseMainMenuOption(choice);
    }

    private void middleMenuViewActions(List<Recipe> listToLook ) throws IOException, InterruptedException {
        ClearScreenService.cleanConsole();
        listsPrinter.printAllRecipes(listToLook);
        menuPrinter.printMenuForPickingARecipe();
        List<String> userChoiceMidle = choiceReader.userInputForFinalPickFromList(listToLook);
        if (userChoiceMidle.size() == 1 && userChoiceMidle.get(0).matches("[0-9]")) {
            numericMenuChoicesMiddle(userChoiceMidle.get(0));
        } else {
            lowestMenuViewActions(userChoiceMidle,listToLook);
        }
    }

    private void lowestMenuViewActions(List<String> userChoiceFromUpperMenu, List<Recipe> listToLook) throws IOException, InterruptedException {
        ClearScreenService.cleanConsole();
        listsPrinter.printRecipe(recipeManager.findRecipeByName(RecipeRepository
                .getRecipesList(), userChoiceFromUpperMenu));
        if (RecipeRepository.getFavouritesRecipeList().stream().anyMatch(recipe -> recipe.getName()
                .equals(recipeManager.findRecipeByName(RecipeRepository
                        .getRecipesList(), userChoiceFromUpperMenu).get(0).getName()))) {
            menuPrinter.printMenuForRecipeView("remove");
        }
        else {
            menuPrinter.printMenuForRecipeView("add");
        }
        List<String> userChoiceFinal = choiceReader.userInputForRecipeView();
        numericMenuChoicesLowest(userChoiceFinal.get(0), recipeManager.findRecipeByName(RecipeRepository
                .getRecipesList(), userChoiceFromUpperMenu).get(0).getName(), listToLook);
    }

    private void numericMenuChoicesUnderTop(String menuChoice) throws IOException, InterruptedException {
        ClearScreenService.cleanConsole();
        switch (menuChoice) {
            case "1":
                menuPrinter.printEntryMenu();
                int choice = choiceReader.makeMenuChoice();
                chooseMainMenuOption(choice);
                break;
            case "2":
                exitFromMenu();
        }
    }

    private void numericMenuChoicesMiddle(String menuChoice) throws IOException, InterruptedException {
        ClearScreenService.cleanConsole();
        switch (menuChoice) {
            case "1":
                menuPrinter.printEntryMenu();
                int choice = choiceReader.makeMenuChoice();
                chooseMainMenuOption(choice);
                break;
            case "2":
                exitFromMenu();
        }
    }

    private void numericMenuChoicesLowest(String menuChoice, String recipe, List<Recipe> listToLook) throws
            IOException, InterruptedException {
        ClearScreenService.cleanConsole();
        switch (menuChoice) {
            case "1":
                ClearScreenService.cleanConsole();
                menuPrinter.printEntryMenu();
                int choice = choiceReader.makeMenuChoice();
                chooseMainMenuOption(choice);
                break;
            case "2":
                exitFromMenu();
            case "3":
                middleMenuViewActions(listToLook);
            case "4":
                ClearScreenService.cleanConsole();
                recipeManager.addOrRemoveRecipeToFavourites(recipe);
                menuPrinter.printEntryMenu();
                choice = choiceReader.makeMenuChoice();
                chooseMainMenuOption(choice);
                break;
        }
    }

    private void exitFromMenu() {ClearScreenService.cleanConsole();
        ClearScreenService.cleanConsole();
        System.out.println("Miejsce na Twoja Reklame ");
        System.out.println("Miejsce na Twoja Reklame ");
        System.out.println("Miejsce na Twoja Reklame ");
        System.out.println("Miejsce na Twoja Reklame ");
        System.out.println("Miejsce na Twoja Reklame ");
        System.out.println("Miejsce na Twoja Reklame ");
        //wyparsowanie listy drinow
        //wyparsowanie listy ulubionych
        System.exit(0);
    }

}

