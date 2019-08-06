package com.infoshareacademy;

class MenuPrinter {

    void printEntryMenu() {
        System.out.println("================ MENU ================" +
                "\nEnter 1 to search drink by name" +
                "\nEnter 2 to search drink by category" +
                "\nEnter 3 to search drink by ingredient" +
                "\nEnter 4 to get full list of drinks" +
                "\nEnter 5 to get your favourites" +
                "\nEnter 6 to exit\n");
    }

    void mainMenuService(int choice) {
        String nameOfDrink;
        ChoiceReader choiceReader = new ChoiceReader();
        switch (choice) {
            case 1:
                System.out.println("Enter name to find: ");
                nameOfDrink = choiceReader.choiceMaker();
                System.out.println("There will be a method which search " + nameOfDrink + " from drink list by name");
                break;
            case 2:
                System.out.println("Enter category to find: ");
                nameOfDrink = choiceReader.choiceMaker();
                System.out.println("There will be a method which search " + nameOfDrink + " from drink list by category");
                break;
            case 3:
                System.out.println("Enter ingredient to find: ");
                nameOfDrink = choiceReader.choiceMaker();
                System.out.println("There will be a method which search " + nameOfDrink + " from drink list by ingredient");
                break;
            case 4:
                System.out.println("There will be a method which print all drink names from drink list");
                printMenuForDrinksList();
                choice = choiceReader.choiceMaker(7);
                menuForDrinkListService(choice);
                break;
            case 5:
                System.out.println("There will be a method which print all drink names from drink list");
                printMenuForFavourites();
                choice = choiceReader.choiceMaker(4);
                menuForFavouritesService(choice);
                break;
            case 6:
                break;
            default:
                System.out.println("wrong choice, type one more time");
                printEntryMenu();
                choice = choiceReader.choiceMaker(6);
                mainMenuService(choice);
                break;
        }
    }

    void printMenuForDrinksList() {
        System.out.println("=========== DRINKS LIST MENU ===========" +
                "\nEnter 1 to get recipe" +
                "\nEnter 2 to add drink to favourites" +
                "\nEnter 3 to remove drink from favourites" +
                "\nEnter 4 to add your drink to drink list" +
                "\nEnter 5 to remove drink from drink list" +
                "\nEnter 6 to back to main menu" +
                "\nEnter 7 to exit\n");
    }

    void menuForDrinkListService(int choice) {
        String nameOfDrink;
        ChoiceReader choiceReader = new ChoiceReader();
        switch (choice) {
            case 1:
                System.out.println("Enter drink name");
                nameOfDrink = choiceReader.choiceMaker();
                System.out.println("There will be used the method to print out " + nameOfDrink + " drink recipe");
                break;
            case 2:
                System.out.println("Enter drink name");
                nameOfDrink = choiceReader.choiceMaker();
                System.out.println("There will be used the methods to get and print list of available categories," +
                        " \nchoose or add category and to add " + nameOfDrink + " to drink list based on categories");
                break;
            case 3:
                System.out.println("Enter drink name");
                nameOfDrink = choiceReader.choiceMaker();
                System.out.println("There will be used the method to remove " + nameOfDrink + " from drink list");
                break;
            case 4:
                System.out.println("Enter drink name");
                nameOfDrink = choiceReader.choiceMaker();
                System.out.println("There will be used the method to add " + nameOfDrink + " to favourite");
                break;
            case 5:
                System.out.println("Enter drink name");
                nameOfDrink = choiceReader.choiceMaker();
                System.out.println("There will be used the method to remove " + nameOfDrink + " from favourites");
                break;
            case 6:
                printEntryMenu();
                choice = choiceReader.choiceMaker(6);
                mainMenuService(choice);
                break;
            case 7:
                break;
            default:
                System.out.println("wrong choice");
                break;
        }
    }

    void printMenuForFavourites() {
        System.out.println("============ YOUR FAVOURITES =============" +
                "\nEnter 1 to add drink to favourites" +
                "\nEnter 2 to remove drink from favourites" +
                "\nEnter 3 to back to main menu" +
                "\nEnter 4 to exit\n");
    }

    void menuForFavouritesService(int choice) {
        String nameOfDrink;
        ChoiceReader choiceReader = new ChoiceReader();
        switch (choice) {
            case 1:
                System.out.println("Enter drink name");
                nameOfDrink = choiceReader.choiceMaker();
                System.out.println("There will be method to add" + nameOfDrink + " to favourites");
                break;
            case 2:
                System.out.println("Enter drink name");
                nameOfDrink = choiceReader.choiceMaker();
                System.out.println("There will be method to remove" + nameOfDrink + " from favourites");
                break;
            case 3:
                printEntryMenu();
                choice = choiceReader.choiceMaker(6);
                mainMenuService(choice);
                break;
            case 4:
                break;
            default:
                System.out.println("wrong choice");
                break;
        }
    }
}
