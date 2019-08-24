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
                        if (RecipeRepository.getFavouritesRecipeList().stream().anyMatch(recipe -> recipe.getName()
                                .equals(recipeManager.findRecipeByName(RecipeRepository
                                        .getRecipesList(), userChoiceMidle).get(0).getName()))) {
                            menuPrinter.printMenuForRecipeView("remove");
                        }
                        else {
                            menuPrinter.printMenuForRecipeView("add");
                        }
                        List<String> userChoiceFinal = choiceReader.userInputForRecipeView();
                        numericMenuChoices(userChoiceFinal.get(0), recipeManager.findRecipeByName(RecipeRepository
                                .getRecipesList(), userChoiceMidle).get(0).getName());
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
                        if (RecipeRepository.getFavouritesRecipeList().stream().anyMatch(recipe -> recipe.getName()
                                .equals(recipeManager.findRecipeByName(RecipeRepository
                                        .getRecipesList(), userChoiceMidle).get(0).getName()))) {
                            menuPrinter.printMenuForRecipeView("remove");
                        }
                        else {
                            menuPrinter.printMenuForRecipeView("add");
                        }
                        List<String> userChoiceFinal = choiceReader.userInputForRecipeView();
                        numericMenuChoices(userChoiceFinal.get(0), recipeManager.findRecipeByName(RecipeRepository
                                .getRecipesList(), userChoiceMidle).get(0).getName());
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
                        if (RecipeRepository.getFavouritesRecipeList().stream().anyMatch(recipe -> recipe.getName()
                                .equals(recipeManager.findRecipeByName(RecipeRepository
                                        .getRecipesList(), userChoiceMidle).get(0).getName()))) {
                            menuPrinter.printMenuForRecipeView("remove");
                        }
                        else {
                            menuPrinter.printMenuForRecipeView("add");
                        }
                        List<String> userChoiceFinal = choiceReader.userInputForRecipeView();
                        numericMenuChoices(userChoiceFinal.get(0), recipeManager.findRecipeByName(RecipeRepository
                                .getRecipesList(), userChoiceMidle).get(0).getName());
                    }
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
                /*List<String> userChoiceMidle byl wczesniej*/
                userChoiceSecond = choiceReader.userInputForFinalPickFromList(RecipeRepository.getRecipesList());
                if (userChoiceSecond.size() == 1 && userChoiceSecond.get(0).matches("[0-9]")) {
                    numericMenuChoices(userChoiceSecond.get(0));
                } else {
                    ClearScreenService.cleanConsole();
                    listsPrinter.printRecipe(recipeManager.findRecipeByName(RecipeRepository
                            .getRecipesList(), userChoiceSecond));
                    if (RecipeRepository.getFavouritesRecipeList().stream().anyMatch(recipe -> recipe.getName()
                            .equals(recipeManager.findRecipeByName(RecipeRepository
                                    .getRecipesList(), userChoiceSecond).get(0).getName()))) {
                        menuPrinter.printMenuForRecipeView("remove");
                    }
                    else {
                        menuPrinter.printMenuForRecipeView("add");
                    }
                    List<String> userChoiceFinal = choiceReader.userInputForRecipeView();
                    numericMenuChoices(userChoiceFinal.get(0), recipeManager.findRecipeByName(RecipeRepository
                            .getRecipesList(), userChoiceSecond).get(0).getName());
                }
                break;
            case 6:
                ClearScreenService.cleanConsole();
                listsPrinter.printAllRecipes(RecipeRepository.getFavouritesRecipeList());
                menuPrinter.printMenuForFavourites();
                userChoiceSecond = choiceReader.userInputForFinalPickFromList(RecipeRepository.getFavouritesRecipeList());
                if (userChoiceSecond.size() == 1 && userChoiceSecond.get(0).matches("[0-9]")) {
                    numericMenuChoices(userChoiceSecond.get(0));
                } else {
                    ClearScreenService.cleanConsole();
                    listsPrinter.printRecipe(recipeManager.findRecipeByName(RecipeRepository
                            .getRecipesList(), userChoiceSecond));
                    if (RecipeRepository.getFavouritesRecipeList().stream().anyMatch(recipe -> recipe.getName()
                            .equals(recipeManager.findRecipeByName(RecipeRepository
                                    .getRecipesList(), userChoiceSecond).get(0).getName()))) {
                        menuPrinter.printMenuForRecipeView("remove");
                    }
                    else {
                        menuPrinter.printMenuForRecipeView("add");
                    }
                    List<String> userChoiceFinal = choiceReader.userInputForRecipeView();
                    numericMenuChoices(userChoiceFinal.get(0), recipeManager.findRecipeByName(RecipeRepository
                            .getRecipesList(), userChoiceSecond).get(0).getName());
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

    //do zaorania
    private void printMenuForFavouritesService() throws IOException, InterruptedException {
        menuPrinter.printMenuForFavourites();
        int choice = choiceReader.makeMenuChoice();
        //chooseFavouritesMenuOption(choice);
    }

    private void lowestMenuViewActions(List<String> userChoiceMidle) throws IOException, InterruptedException {
        ClearScreenService.cleanConsole();
        listsPrinter.printRecipe(recipeManager.findRecipeByName(RecipeRepository
                .getRecipesList(), userChoiceMidle));
        if (RecipeRepository.getFavouritesRecipeList().stream().anyMatch(recipe -> recipe.getName()
                .equals(recipeManager.findRecipeByName(RecipeRepository
                        .getRecipesList(), userChoiceMidle).get(0).getName()))) {
            menuPrinter.printMenuForRecipeView("remove");
        }
        else {
            menuPrinter.printMenuForRecipeView("add");
        }
        List<String> userChoiceFinal = choiceReader.userInputForRecipeView();
        numericMenuChoices(userChoiceFinal.get(0), recipeManager.findRecipeByName(RecipeRepository
                .getRecipesList(), userChoiceMidle).get(0).getName());
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
                exitFromMenu();
        }
    }

    private void numericMenuChoices(String menuChoice, String recipe) throws
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
                ClearScreenService.cleanConsole();
                System.out.println("Miejsce na Twoja Reklame ");
                System.out.println("Miejsce na Twoja Reklame ");
                System.out.println("Miejsce na Twoja Reklame ");
                System.out.println("Miejsce na Twoja Reklame ");
                System.out.println("Miejsce na Twoja Reklame ");
                System.out.println("Miejsce na Twoja Reklame ");
                System.exit(0);
            case "3":
                //miejsce na delete from Drinkopedia
                exitFromMenu();
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

