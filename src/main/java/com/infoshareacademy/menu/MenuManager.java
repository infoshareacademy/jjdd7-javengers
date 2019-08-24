package com.infoshareacademy.menu;

import com.infoshareacademy.domain.RecipeRepository;
import com.infoshareacademy.service.RecipeService;

import java.io.IOException;


public class MenuManager {
    private RecipeService recipeService = new RecipeService();
    private RecipeAddAndEditManager recipeAddAndEditManager = new RecipeAddAndEditManager();
    private ListsPrinter listsPrinter = new ListsPrinter();
    private MenuPrinter menuPrinter = new MenuPrinter();
    private UserChoice userChoice = new UserChoice();

    public void chooseMainMenuOption(int choice) throws IOException {
        String userChoice;
        switch (choice) {
            case 1:
                System.out.println("\nEnter name to find drink: ");
                userChoice = recipeAddAndEditManager.loadRecipeAttributes();
                System.out.println("\nThere will be a method which search " + userChoice + " from drink list by name" +
                        "\nWhat do you want to do with these drink\n");
                printMenuForDrinkService(userChoice);
                printMainMenuService();
                break;
            case 2:
                listsPrinter.printCategory(RecipeRepository.getCategoriesList());
                System.out.println("\nEnter category to find recipes: ");
                userChoice = recipeAddAndEditManager.loadRecipeAttributes();
                System.out.println("\nThere will be a method which will print out the list of all drinks from "
                        + userChoice + " category\n");
                printMenuForDrinkService(userChoice);
                printMainMenuService();
                break;
            case 3:
                System.out.println("\nEnter ingredient to find: ");
                userChoice = recipeAddAndEditManager.loadRecipeAttributes();
                System.out.println("\nThere will be a method which will print out all drinks that contain "
                        + userChoice + " ingredient\n");
                printMenuForDrinkService(userChoice);
                printMainMenuService();
                break;
            case 4:
                listsPrinter.printCategory(RecipeRepository.getCategoriesList());
                System.out.println("Enter category of recipe from list or specify your own: ");
                UserChoice recipeAddition = new UserChoice();
                recipeService.addRecipeToList(recipeAddAndEditManager.createNewRecipe());
                printMainMenuService();
                break;
            case 5:
                System.out.println("\nEnter drink name to remove from recipe list");
                userChoice = recipeAddAndEditManager.loadRecipeAttributes();
                recipeService.deleteRecipeFromList(userChoice);
                printMainMenuService();
                break;
            case 6:
                listsPrinter.printAllRecipes(RecipeRepository.getRecipesList());
                printMenuForDrinkService();
                break;
            case 7:
                listsPrinter.printAllRecipes(RecipeRepository.getFavouritesRecipeList());
                printMenuForFavouritesService();
                break;
            case 8:
                break;
            default:
                System.out.println("\n wrong choice, type one more time");
                printMainMenuService();
                break;
        }
    }


    private void chooseDrinkListMenuOption(int choice) throws IOException {
        String userChoice;
        RecipeAddAndEditManager recipeAddAndEditManager = new RecipeAddAndEditManager();
        switch (choice) {
            case 1:
                System.out.println("\nEnter drink name to remove from recipe list");
                userChoice = recipeAddAndEditManager.loadRecipeAttributes();
                recipeService.deleteRecipeFromList(userChoice);
                printMainMenuService();
                break;
            case 2:
                System.out.println("\nEnter drink name to add to favourites");
                userChoice = recipeAddAndEditManager.loadRecipeAttributes();
                System.out.println("There will be used the method to add " + userChoice + " to favourite\n");
                printMainMenuService();
                break;
            case 3:
                System.out.println("Which recipe do you want to edit, enter name: ");
                userChoice = recipeAddAndEditManager.loadRecipeAttributes();
                while (recipeAddAndEditManager.isRecipeOnRecipesList(userChoice)){
                    System.out.println("There is no recipe with these name, type one more time");
                    userChoice = recipeAddAndEditManager.loadRecipeAttributes();
                }
                recipeService.editRecipe(recipeAddAndEditManager.editRecipe(userChoice),userChoice, recipeAddAndEditManager.getLocalDateTime());
                printMainMenuService();
                break;
            case 4:
                printMainMenuService();
                break;
            case 5:
                break;
            default:
                System.out.println("\nwrong choice");
                printMenuForDrinkService();
                break;
        }
    }

    private void chooseDrinkListMenuOption(int choice, String userChoice) throws IOException {
        switch (choice) {
            case 1:
                System.out.println("\nEnter drink name to remove from recipe list");
                userChoice = recipeAddAndEditManager.loadRecipeAttributes();
                recipeService.deleteRecipeFromList(userChoice);
                printMainMenuService();
                break;
            case 2:
                System.out.println("\nEnter drink name to add to favourites");
                userChoice = recipeAddAndEditManager.loadRecipeAttributes();
                System.out.println("There will be used the method to add " + userChoice + " to favourite\n");
                printMainMenuService();
                break;
            case 3:
                System.out.println("Which recipe do you want to edit, enter name: ");
                userChoice = recipeAddAndEditManager.loadRecipeAttributes();
                while (recipeAddAndEditManager.isRecipeOnRecipesList(userChoice)){
                    System.out.println("There is no recipe with these name, type one more time");
                    userChoice = recipeAddAndEditManager.loadRecipeAttributes();
                }
                recipeService.editRecipe(recipeAddAndEditManager.editRecipe(userChoice),userChoice, recipeAddAndEditManager.getLocalDateTime());
                printMainMenuService();
                break;
            case 4:
                printMainMenuService();
                break;
            case 5:
                break;
            default:
                System.out.println("\nwrong choice");
                printMenuForDrinkService();
                break;
        }
    }

    private void chooseFavouritesMenuOption(int choice) throws IOException {
        String nameOfDrink;
        RecipeAddAndEditManager recipeAddAndEditManager = new RecipeAddAndEditManager();
        switch (choice) {
            case 1:
                System.out.println("\nEnter drink name");
                nameOfDrink = recipeAddAndEditManager.loadRecipeAttributes();
                System.out.println("There will be method to add" + nameOfDrink + " to favourites\n");
                printMainMenuService();
                break;
            case 2:
                System.out.println("\nEnter drink name");
                nameOfDrink = recipeAddAndEditManager.loadRecipeAttributes();
                System.out.println("There will be method to remove" + nameOfDrink + " from favourites\n");
                printMainMenuService();
                break;
            case 3:
                printMainMenuService();
                break;
            case 4:
                break;
            default:
                System.out.println("\nwrong choice");
                menuPrinter.printMenuForFavourites();
                choice = userChoice.makeMenuChoice();
                chooseFavouritesMenuOption(choice);
                break;
        }
    }

    private void printMainMenuService() throws IOException {
        menuPrinter.printEntryMenu();
        int choice = userChoice.makeMenuChoice();
        chooseMainMenuOption(choice);
    }

    private void printMenuForDrinkService(String userInput) throws IOException {
        menuPrinter.printMenuForDrinksList();
        int choice = userChoice.makeMenuChoice();
        chooseDrinkListMenuOption(choice, userInput);
    }

    private void printMenuForDrinkService() throws IOException {
        menuPrinter.printMenuForDrinksList();
        int choice = userChoice.makeMenuChoice();
        chooseDrinkListMenuOption(choice);
    }

    private void printMenuForFavouritesService() throws IOException {
        menuPrinter.printMenuForFavourites();
        int choice = userChoice.makeMenuChoice();
        chooseFavouritesMenuOption(choice);
    }
}
