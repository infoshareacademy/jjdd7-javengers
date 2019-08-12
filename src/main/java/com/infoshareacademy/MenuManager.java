package com.infoshareacademy;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class MenuManager {
    private RecipeManager recipeManager = new RecipeManager();
    private ChoiceReader choiceReader = new ChoiceReader();
    private FavouriteRecipeSearcher favouriteRecipeSearcher =  new FavouriteRecipeSearcher();
    private ListsPrinter listsPrinter =  new ListsPrinter();
    private MenuPrinter menuPrinter = new MenuPrinter();
    private List<RecipeDTO> recipeDTOList = recipeManager.createRecipesList();
    private List<RecipeDTO>favouritesList = favouriteRecipeSearcher.getFavouritesRecipeList();
    private Set<String> categoryList = recipeManager.createCategoriesList(recipeDTOList);

    // there is no screen clear

    void chooseMainMenuOption(int choice) throws IOException {
        String userChoice;
        switch (choice) {
            case 1:
                System.out.println("\nEnter name to find drink: ");
                userChoice = choiceReader.makeChoice();
                System.out.println("There will be a method which search " + userChoice+ " from drink list by name" +
                        "\nWhat do you want to do with these drink\n");
                menuPrinter.printMenuForDrinksList();
                choice = choiceReader.makeMenuChoice();
                chooseDrinkListMenuOption(choice,userChoice);
                break;
            case 2:
                listsPrinter.printCategory(categoryList);
                System.out.println("\nEnter category to find recipes: ");
                userChoice = choiceReader.makeChoice();
                System.out.println("There will be a method which will print out the list of all drinks from " + userChoice + " category\n");
                menuPrinter.printMenuForDrinksList();
                choice = choiceReader.makeMenuChoice();
                chooseDrinkListMenuOption(choice,userChoice);
                break;
            case 3:
                System.out.println("\nEnter ingredient to find: ");
                userChoice = choiceReader.makeChoice();
                System.out.println("There will be a method which will print out all drinks that contain " + userChoice + " ingredient");
                menuPrinter.printMenuForDrinksList();
                choice = choiceReader.makeMenuChoice();
                chooseDrinkListMenuOption(choice,userChoice);
                break;
            case 4:
                System.out.println("Choose available category or enter a new category, \nto which your new recipe will be added");
                listsPrinter.printCategory(categoryList);
                userChoice = choiceReader.makeChoice();
                System.out.println("There will be methods used to get and print list of available categories," +
                        " \nchoose or add category and to add " + userChoice + " to drink list based on categories");
                break;
            case 5:
                System.out.println("\nEnter drink name to remove from recipe list");
                userChoice = choiceReader.makeChoice();
                System.out.println("There will be method to remove " + userChoice + " from drink list");
                break;
            case 6:
                listsPrinter.printAllRecipes(recipeDTOList);
                menuPrinter.printMenuForDrinksList();
                choice = choiceReader.makeMenuChoice();
                chooseDrinkListMenuOption(choice);
                break;
            case 7:
                listsPrinter.printAllRecipes(favouritesList);
                menuPrinter.printMenuForFavourites();
                choice = choiceReader.makeMenuChoice();
                chooseFavouritesMenuOption(choice);
                break;
            case 8:
                break;
            default:
                System.out.println("\n wrong choice, type one more time");
                menuPrinter.printEntryMenu();
                choice = choiceReader.makeMenuChoice();
                chooseMainMenuOption(choice);
                break;
        }
    }


    private void chooseDrinkListMenuOption(int choice) throws IOException {
        String userChoice;
        ChoiceReader choiceReader = new ChoiceReader();
        switch (choice) {
            case 1:
                System.out.println("\nEnter drink name to remove from drink list");
                userChoice = choiceReader.makeChoice();
                System.out.println("There will be used the method to remove " + userChoice + " from drink list");

                break;
            case 2:
                System.out.println("\nEnter drink name to add to favourites");
                userChoice = choiceReader.makeChoice();
                System.out.println("There will be used the method to add " + userChoice + " to favourite");
                break;
            case 3:
                menuPrinter.printEntryMenu();
                choice = choiceReader.makeMenuChoice();
                chooseMainMenuOption(choice);
                break;
            case 4:
                break;
            default:
                System.out.println("\nwrong choice");
                menuPrinter.printMenuForDrinksList();
                choice = choiceReader.makeMenuChoice();
                chooseDrinkListMenuOption(choice);
                break;
        }
    }

    private void chooseDrinkListMenuOption(int choice, String userChoice) throws IOException {
        switch (choice) {
            case 1:
                System.out.println("There will be used the method to remove " + userChoice + " from drink list");
                break;
            case 2:
                System.out.println("There will be used the method to add " + userChoice + " to favourite");
                break;
            case 3:
                menuPrinter.printEntryMenu();
                choice = choiceReader.makeMenuChoice();
                chooseMainMenuOption(choice);
                break;
            case 4:
                break;
            default:
                System.out.println("\nwrong choice");
                menuPrinter.printMenuForDrinksList();
                choice = choiceReader.makeMenuChoice();
                chooseDrinkListMenuOption(choice);
                break;
        }
    }

    private void chooseFavouritesMenuOption(int choice) throws IOException {
        String nameOfDrink;
        ChoiceReader choiceReader = new ChoiceReader();
        switch (choice) {
            case 1:
                System.out.println("\nEnter drink name");
                nameOfDrink = choiceReader.makeChoice();
                System.out.println("There will be method to add" + nameOfDrink + " to favourites");
                break;
            case 2:
                System.out.println("\nEnter drink name");
                nameOfDrink = choiceReader.makeChoice();
                System.out.println("There will be method to remove" + nameOfDrink + " from favourites");
                break;
            case 3:
                menuPrinter.printEntryMenu();
                choice = choiceReader.makeMenuChoice();
                chooseMainMenuOption(choice);
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
}
