package com.infoshareacademy;

public class App {
    public static void main(String[] args) {
        System.out.println("\t\tWelcome to Drinkopedia!\t\t\n");
        MenuService menuService = new MenuService();
        ChoiceReader choiceReader = new ChoiceReader();
        menuService.printEntryMenu();
        int choice = choiceReader.makeMenuChoice();
        menuService.chooseMainMenuOption(choice);
    }
}
