package com.infoshareacademy;

import java.util.List;

class MenuManager {
    private RecipeManager recipeManager = new RecipeManager();
    private ChoiceReader choiceReader = new ChoiceReader();
    private FavouriteRecipeSearcher favouriteRecipeSearcher =  new FavouriteRecipeSearcher();
    private ListsPrinter listsPrinter =  new ListsPrinter();
    private MenuPrinter menuPrinter = new MenuPrinter();
    List<RecipeDTO> recipeDTOList = recipeManager.createRecipesList();
    List<RecipeDTO>favouritesList = favouriteRecipeSearcher.getFavouritesRecipeList();
    List<String>categoryList = recipeManager.getCategoriesList();

    void chooseMainMenuOption(int choice) {
        String userChoice;
        switch (choice) {
            case 1:
                System.out.println("Enter name to find drink: ");
                userChoice = choiceReader.makeChoice();
                System.out.println("There will be a method which search " + userChoice+ " from drink list by name" +
                        "\nWhat do you want to do with these drink\n");
                menuPrinter.printMenuForDrinksList();
                choice = choiceReader.makeMenuChoice();
                chooseDrinkListMenuOption(choice,userChoice);
                break;
            case 2:
                listsPrinter.printCategory(categoryList);
                System.out.println("Enter category to find recipes: ");
                userChoice = choiceReader.makeChoice();
                System.out.println("There will be a method which search " + userChoice + " from drink list by category" +
                        "\nWhat do you want to do with these drink\n");
                menuPrinter.printMenuForDrinksList();
                choice = choiceReader.makeMenuChoice();
                chooseDrinkListMenuOption(choice,userChoice);
                break;
            case 3:
                System.out.println("Enter ingredient to find: ");
                userChoice = choiceReader.makeChoice();
                System.out.println("There will be a method which search" + userChoice + "from drink list by ingredient");
                menuPrinter.printMenuForDrinksList();
                choice = choiceReader.makeMenuChoice();
                chooseDrinkListMenuOption(choice,userChoice);
                break;
            case 4:
                System.out.println("There are available categories, choose category or enter a new category");
                listsPrinter.printCategory(categoryList);
                userChoice = choiceReader.makeChoice();
                System.out.println("There will be used the methods to get and print list of available categories," +
                        " \nchoose or add category and to add " + userChoice + " to drink list based on categories");
                break;
            case 5:
                System.out.println("Enter drink name to remove from recipe list");
                userChoice = choiceReader.makeChoice();
                System.out.println("There will be used the method to remove " + userChoice + " from drink list");
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
                System.out.println("wrong choice, type one more time");
                menuPrinter.printEntryMenu();
                choice = choiceReader.makeMenuChoice();
                chooseMainMenuOption(choice);
                break;
        }
    }


    private void chooseDrinkListMenuOption(int choice) {
        String userChoice;
        ChoiceReader choiceReader = new ChoiceReader();
        switch (choice) {
            case 1:
                System.out.println("Enter drink name to remove from drink list");
                userChoice = choiceReader.makeChoice();
                System.out.println("There will be used the method to remove " + userChoice + " from drink list");
                break;
            case 2:
                System.out.println("Enter drink name to add to favourites");
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
                System.out.println("wrong choice");
                menuPrinter.printMenuForDrinksList();
                choice = choiceReader.makeMenuChoice();
                chooseDrinkListMenuOption(choice);
                break;
        }
    }

    private void chooseDrinkListMenuOption(int choice, String userChoice) {
        switch (choice) {
            case 1:
                System.out.println("There will be used the method to remove " + userChoice + " from drink list");
                break;
            case 2:
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
                System.out.println("wrong choice");
                menuPrinter.printMenuForDrinksList();
                choice = choiceReader.makeMenuChoice();
                chooseDrinkListMenuOption(choice);
                break;
        }
    }

    private void chooseFavouritesMenuOption(int choice) {
        String nameOfDrink;
        ChoiceReader choiceReader = new ChoiceReader();
        switch (choice) {
            case 1:
                System.out.println("Enter drink name");
                nameOfDrink = choiceReader.makeChoice();
                System.out.println("There will be method to add" + nameOfDrink + " to favourites");
                break;
            case 2:
                System.out.println("Enter drink name");
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
                System.out.println("wrong choice");
                menuPrinter.printMenuForFavourites();
                choice = choiceReader.makeMenuChoice();
                chooseFavouritesMenuOption(choice);
                break;
        }
    }
}
