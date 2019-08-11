package com.infoshareacademy;

public class App {
    public static void main(String[] args) {
        System.out.println("\t\tWelcome to Drinkopedia!\t\t\n");
        MenuManager menuManager = new MenuManager();
        ChoiceReader choiceReader = new ChoiceReader();
        MenuPrinter menuPrinter = new MenuPrinter();
        menuPrinter.printEntryMenu();
        int choice = choiceReader.makeMenuChoice();
        menuManager.chooseMainMenuOption(choice);
    }
}
