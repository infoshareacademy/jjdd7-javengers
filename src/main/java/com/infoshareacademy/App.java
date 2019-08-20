package com.infoshareacademy;

import com.infoshareacademy.menu.ChoiceReader;
import com.infoshareacademy.menu.MenuManager;
import com.infoshareacademy.menu.MenuPrinter;
import com.infoshareacademy.properties.ConfigLoader;
import java.io.IOException;

public class App {

  public static void main(String[] args) throws IOException {
    System.out.println("\n\t\t\t\t\tWelcome to Drinkopedia!");
    MenuManager menuManager = new MenuManager();
    ChoiceReader choiceReader = new ChoiceReader();
    MenuPrinter menuPrinter = new MenuPrinter();
    menuPrinter.printEntryMenu();
    int choice = choiceReader.makeMenuChoice();
    menuManager.chooseMainMenuOption(choice);

    new ConfigLoader().loadAppConfig();

  }
}