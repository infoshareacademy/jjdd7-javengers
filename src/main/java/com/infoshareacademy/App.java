package com.infoshareacademy;

public class App {
    public static void main(String[] args) {
        System.out.println("\t\tWelcome to Drinkopedia!\t\t\n");
        MenuPrinter menuPrinter = new MenuPrinter();
        ChoiceReader choiceReader = new ChoiceReader();
        menuPrinter.printEntryMenu();
        int choice = choiceReader.choiceMaker(6);
        menuPrinter.mainMenuService(choice);
    }
}
