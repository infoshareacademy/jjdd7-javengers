package com.infoshareacademy.menu;


import com.infoshareacademy.properties.AppConfig;
import com.infoshareacademy.service.MatureVerifier;

import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

public class ChoiceReader {

  private Scanner scanner = new Scanner(System.in);
  private static String DATE_FORMATTER = AppConfig.dateFormat;



  public int makeMenuChoice() {
    int userChoice = 0;
    String choiceFromMenu;
    System.out.println("Provide a number: ");
    choiceFromMenu = scanner.nextLine();

    if (NumberUtils.isCreatable(choiceFromMenu)) {
      userChoice = Integer.parseInt(choiceFromMenu);
    } else {
      System.out.println("Invalid choice, type one more time");
      makeMenuChoice();
    }

    return userChoice;
  }

  String makeChoice() {
    return scanner.nextLine();
  }

  public boolean confirmMature() {

    if (MatureVerifier.isAlreadyCheckedAndMature()) {
      return  true;
    }
    String ageChoice;
    String choiceSave;

    System.out.println("Do you have 18 years? ");
    ageChoice = scanner.nextLine();
    if ("yes".equals(ageChoice.toLowerCase())) {
      System.out.println("Do you want to save your age?");
      choiceSave = scanner.nextLine();
      if ("yes".equals(choiceSave.toLowerCase())) {
        MatureVerifier.setMature();
      }
      return true;
    }
    return false;
  }
}



