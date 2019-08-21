package com.infoshareacademy.menu;

import com.infoshareacademy.domain.RecipeRepository;
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
        List<String> userChoiceArrayList;
        switch (choice) {
            case 1:
                System.out.println("\nEnter name to find drink: ");
                userChoice = choiceReader.makeChoice();
                listsPrinter.printRecipe(recipeManager.findRecipeByName(RecipeRepository.getRecipesList(),userChoice));
                printMenuForDrinkService(userChoice);

                break;
            case 2:

                listsPrinter.printCategory(RecipeRepository.getCategoriesList());
                userChoiceArrayList = choiceReader.userInputForListsCheck(RecipeRepository.getCategoriesList(), "category");
                listsPrinter.printAllRecipes(recipeManager.findRecipeByCategory(RecipeRepository.getRecipesList(), userChoiceArrayList));
                printMenuForDrinkService(userChoiceArrayList.toString());

                break;
            case 3:
                System.out.println("\nEnter ingredient to find: ");
                userChoice = choiceReader.makeChoice();
                System.out.println("\nThere will be a method which will print out all drinks that contain "
                        + userChoice + " ingredient\n");
                printMenuForDrinkService(userChoice);
                printMainMenuService();
                break;
            case 4:
                listsPrinter.printCategory(RecipeRepository.getCategoriesList());
                System.out.println("\nChoose available category or enter a new category, \n" +
                        "to which your new recipe will be added\n");
                userChoice = choiceReader.makeChoice();
                System.out.println("\nThere will be method used to  add" + userChoice
                        + " to drink list based on categories\n");
                printMainMenuService();
                break;
            case 5:
                System.out.println("\nEnter drink name to remove from recipe list");
                userChoice = choiceReader.makeChoice();
                System.out.println("\nThere will be method to remove " + userChoice + " from drink list\n");
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


    private void chooseDrinkListMenuOption(int choice) throws IOException, InterruptedException {
        String userChoice;
        ChoiceReader choiceReader = new ChoiceReader();
        switch (choice) {
            case 1:
                System.out.println("\nEnter drink name to remove from drink list");
                userChoice = choiceReader.makeChoice();
                System.out.println("\nThere will be used the method to remove " + userChoice + " from drink list\n");
                printMainMenuService();
                break;
            case 2:
                System.out.println("\nEnter drink name to add to favourites");
                userChoice = choiceReader.makeChoice();
                System.out.println("There will be used the method to add " + userChoice + " to favourite\n");
                printMainMenuService();
                break;
            case 3:
                printMainMenuService();
                break;
            case 4:
                break;
            default:
                System.out.println("\nwrong choice");
                printMenuForDrinkService();
                break;
        }
    }

    private void chooseDrinkListMenuOption(int choice, String userChoice) throws IOException, InterruptedException {
        switch (choice) {
            case 1:
                System.out.println("\nThere will be used the method to remove " + userChoice + " from drink list\n");
                printMainMenuService();
                break;
            case 2:
                System.out.println("\nThere will be used the method to add " + userChoice + " to favourite\n");
                printMainMenuService();
                break;
            case 3:
                printMainMenuService();
                break;
            case 4:
                break;
            default:
                System.out.println("\nwrong choice");
                printMenuForDrinkService();
                break;
        }
    }

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

    private void printMenuForDrinkService(String userChoice) throws IOException, InterruptedException {
        menuPrinter.printMenuForDrinksList();
        int choice = choiceReader.makeMenuChoice();
        chooseDrinkListMenuOption(choice, userChoice);
    }

    private void printMenuForDrinkService() throws IOException, InterruptedException {
        menuPrinter.printMenuForDrinksList();
        int choice = choiceReader.makeMenuChoice();
        chooseDrinkListMenuOption(choice);
    }

    private void printMenuForFavouritesService() throws IOException, InterruptedException {
        menuPrinter.printMenuForFavourites();
        int choice = choiceReader.makeMenuChoice();
        chooseFavouritesMenuOption(choice);
    }
}
