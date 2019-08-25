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
    private RecipeAddAndEditManager recipeAddition = new RecipeAddAndEditManager();


    public void chooseMainMenuOption(int choice) throws IOException, InterruptedException {

        switch (choice) {
            case 1:
                recipeByNameMenuViewActions();
                break;
            case 2:
                recipeByCategoryViewActions();
                break;
            case 3:
                recipeByIngredientViewActions();
                break;
            case 4:
                ClearScreenService.cleanConsole();
                recipeManager.addRecipeToList(recipeAddition.createNewRecipe());
                printMainMenuService();
                break;
            case 5:
                recipeByRecipeListViewActions();
                break;
            case 6:
                recipeByFavouritesListViewActions();
                break;
            case 7:
                exitFromMenu();
                break;
            default:
                System.out.println("\n wrong choice, type one more time");
                printMainMenuService();
        }
    }

    //tu jest bug ze dwa razy cos tam trzeba robic
    private void printMainMenuService() throws IOException, InterruptedException {
        ClearScreenService.cleanConsole();
        menuPrinter.printBreadcrumb("main menu");
        menuPrinter.printEntryMenu();
        int choice = choiceReader.makeMenuChoice();
        chooseMainMenuOption(choice);
    }

    private void recipeByNameMenuViewActions() throws IOException, InterruptedException {
        ClearScreenService.cleanConsole();
        menuPrinter.printBreadcrumb("main menu","by name");
        listsPrinter.printImage();
        menuPrinter.printMenuForDrinksByName();
        List<String> userChoiceFromUpperMenu = choiceReader.userInputForDrinkNameCheck(RecipeRepository.getRecipesList());
        if (userChoiceFromUpperMenu.size() == 1 && userChoiceFromUpperMenu.get(0).matches("[0-9]")) {
            numericMenuChoicesUnderTop(userChoiceFromUpperMenu.get(0));
        } else {
            middleMenuViewActions((recipeManager.findRecipeByName(RecipeRepository.getRecipesList(), userChoiceFromUpperMenu)), "name");
        }
    }

    private void recipeByCategoryViewActions() throws IOException, InterruptedException {
        ClearScreenService.cleanConsole();
        menuPrinter.printBreadcrumb("main menu","category");
        listsPrinter.printCategory(RecipeRepository.getCategoriesList());
        menuPrinter.printMenuForDrinksByList("category");
        List<String> userChoiceFromUpperMenu = choiceReader.userInputForListsCheck(RecipeRepository.getCategoriesList());
        if (userChoiceFromUpperMenu.size() == 1 && userChoiceFromUpperMenu.get(0).matches("[0-9]")) {
            numericMenuChoicesUnderTop(userChoiceFromUpperMenu.get(0));
        } else {
            middleMenuViewActions(recipeManager.findRecipeByCategory(RecipeRepository
                    .getRecipesList(), userChoiceFromUpperMenu), "category");
        }
    }

    private void recipeByIngredientViewActions() throws IOException, InterruptedException {
        ClearScreenService.cleanConsole();
        menuPrinter.printBreadcrumb("main menu","ingredient");
        listsPrinter.printCategory(RecipeRepository.getIngredientsList());
        menuPrinter.printMenuForDrinksByList("ingredient");
        List<String> userChoiceFromUpperMenu = choiceReader.userInputForListsCheck(RecipeRepository.getIngredientsList());
        if (userChoiceFromUpperMenu.size() == 1 && userChoiceFromUpperMenu.get(0).matches("[0-9]")) {
            numericMenuChoicesUnderTop(userChoiceFromUpperMenu.get(0));
        } else {
            ClearScreenService.cleanConsole();
            middleMenuViewActions((recipeManager.findRecipeByIngredients(RecipeRepository
                    .getRecipesList(), userChoiceFromUpperMenu)), "ingredient");
        }
    }


    private void recipeByRecipeListViewActions() throws IOException, InterruptedException {
        ClearScreenService.cleanConsole();
        menuPrinter.printBreadcrumb("main menu","all drinks");
        listsPrinter.printAllRecipes(RecipeRepository.getRecipesList());
        menuPrinter.printMenuForPickingARecipe();
        List<String> userChoiceFromUpperMenu = choiceReader.userInputForFinalPickFromList(RecipeRepository.getRecipesList());
        if (userChoiceFromUpperMenu.size() == 1 && userChoiceFromUpperMenu.get(0).matches("[0-9]")) {
            numericMenuChoicesUnderTop(userChoiceFromUpperMenu.get(0));
        } else {
            lowestMenuViewActions(userChoiceFromUpperMenu, RecipeRepository.getRecipesList(), "all drinks");
        }

    }

    private void recipeByFavouritesListViewActions() throws IOException, InterruptedException {
        ClearScreenService.cleanConsole();
        menuPrinter.printBreadcrumb("main menu","favourites");
        listsPrinter.printAllRecipes(RecipeRepository.getFavouritesRecipeList());
        menuPrinter.printMenuForFavourites();
        List<String> userChoiceFromUpperMenu = choiceReader.userInputForFinalPickFromList(RecipeRepository.getFavouritesRecipeList());
        if (userChoiceFromUpperMenu.size() == 1 && userChoiceFromUpperMenu.get(0).matches("[0-9]")) {
            numericMenuChoicesUnderTop(userChoiceFromUpperMenu.get(0));
        } else {
            lowestMenuViewActions(userChoiceFromUpperMenu, RecipeRepository.getRecipesList(), "favourites");
        }
    }


    private void middleMenuViewActions(List<Recipe> listToLook, String upperMenuName) throws IOException, InterruptedException {
        ClearScreenService.cleanConsole();
        menuPrinter.printBreadcrumb("main menu", upperMenuName, upperMenuName+" - limited by pick");
        listsPrinter.printAllRecipes(listToLook);
        menuPrinter.printMenuForPickingARecipe();
        List<String> userChoiceMidle = choiceReader.userInputForFinalPickFromList(listToLook);
        if (userChoiceMidle.size() == 1 && userChoiceMidle.get(0).matches("[0-9]")) {
            //tu siedzi chujec
            numericMenuChoicesMiddle(userChoiceMidle.get(0), upperMenuName);
        } else {
            lowestMenuViewActions(userChoiceMidle, listToLook, upperMenuName);
        }
    }

    private void lowestMenuViewActions(List<String> userChoiceFromUpperMenu, List<Recipe> listToLook, String upperMenuName) throws IOException, InterruptedException {
        ClearScreenService.cleanConsole();
        menuPrinter.printBreadcrumb("main menu", upperMenuName, upperMenuName+" - limited by pick", "recipe name: "+ userChoiceFromUpperMenu.get(0));
        listsPrinter.printRecipe(recipeManager.findRecipeByName(RecipeRepository
                .getRecipesList(), userChoiceFromUpperMenu));
        if (RecipeRepository.getFavouritesRecipeList().stream().anyMatch(recipe -> recipe.getName()
                .equals(recipeManager.findRecipeByName(RecipeRepository
                        .getRecipesList(), userChoiceFromUpperMenu).get(0).getName()))) {
            menuPrinter.printMenuForRecipeView("remove");
        } else {
            menuPrinter.printMenuForRecipeView("add");
        }
        List<String> userChoiceFinal = choiceReader.userInputForRecipeView();
        numericMenuChoicesLowest(userChoiceFinal.get(0), recipeManager.findRecipeByName(RecipeRepository
                .getRecipesList(), userChoiceFromUpperMenu).get(0).getName(), listToLook, upperMenuName);
    }


    private void numericMenuChoicesUnderTop(String menuChoice) throws IOException, InterruptedException {
        ClearScreenService.cleanConsole();
        switch (menuChoice) {
            case "1":
                printMainMenuService();
            case "2":
                exitFromMenu();
            case "3":
                printMainMenuService();
        }
    }

    private void numericMenuChoicesMiddle(String menuChoice, String upperMenuName) throws IOException, InterruptedException {
        ClearScreenService.cleanConsole();
        switch (menuChoice) {
            case "1":
                menuPrinter.printEntryMenu();
                int choice = choiceReader.makeMenuChoice();
                chooseMainMenuOption(choice);
                break;
            case "2":
                exitFromMenu();
            case "3":
                if (upperMenuName.equals("name")) {
                    recipeByNameMenuViewActions();
                    break;
                }
                if (upperMenuName.equals("category")) {
                    recipeByCategoryViewActions();
                    break;
                }
                if (upperMenuName.equals("ingredient")) {
                    recipeByIngredientViewActions();
                    break;
                }
                if (upperMenuName.equals("favourites")) {
                    printMainMenuService();
                }
                if (upperMenuName.equals("all drinks")) {
                    printMainMenuService();
                }
        }
    }

    private void numericMenuChoicesLowest(String menuChoice, String recipe, List<Recipe> listToLook, String upperMenuName) throws
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
                middleMenuViewActions(listToLook, upperMenuName);
            case "4":
                ClearScreenService.cleanConsole();
                recipeManager.addOrRemoveRecipeToFavourites(recipe);
                if (upperMenuName.equals("favourites")) {
                    recipeByFavouritesListViewActions();
                }
                if (upperMenuName.equals("all drinks")) {
                    recipeByRecipeListViewActions();
                }
                if (upperMenuName.equals("name")) {
                    middleMenuViewActions(listToLook, upperMenuName);
                    break;
                }
                if (upperMenuName.equals("category")) {
                    middleMenuViewActions(listToLook, upperMenuName);
                    break;
                }
                if (upperMenuName.equals("ingredient")) {
                    middleMenuViewActions(listToLook, upperMenuName);
                    break;
                }

            case "5":
                recipeManager.deleteRecipeFromList(recipeAddition.loadRecipeName(recipe));
                printMainMenuService();
                break;
            case "6":
                String date = recipeAddition.getLocalDateTime();
                String name = recipeAddition.loadRecipeName(recipe);
                recipeManager.editRecipe(recipeAddition.editRecipe(name),name,date);
                printMainMenuService();
        }
    }

    private void exitFromMenu() {
        ClearScreenService.cleanConsole();
        menuPrinter.endview();
        System.exit(0);
    }

}
