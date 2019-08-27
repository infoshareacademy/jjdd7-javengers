package com.infoshareacademy.menu;

import com.infoshareacademy.domain.Recipe;
import com.infoshareacademy.service.MatureVerifier;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.*;
import java.util.stream.Collectors;

public class ChoiceReader {

  private Scanner scanner = new Scanner(System.in);

  String makeChoice() {
    return scanner.nextLine();
  }

  //tu moze byc bug
  public int makeMenuChoice() {
    int userChoice = 0;
    String choiceFromMenu;
    System.out.println("Provide a number: ");
    choiceFromMenu = scanner.nextLine();

    if (NumberUtils.isCreatable(choiceFromMenu) && Integer.parseInt(choiceFromMenu) < 9
        && Integer.parseInt(choiceFromMenu) > 0) {
      userChoice = Integer.parseInt(choiceFromMenu);
    } else {
      System.out.println("Invalid choice, type one more time");
      makeMenuChoice();
    }
    return userChoice;
  }

  public List<String> userInputForListsCheck(List<String> inputList) {
    List<String> outputList = new ArrayList<>();
    Set<String> inputListToLower = new HashSet<>();
    String userSingleChoice = "";
    List<String> userChoiceList = new ArrayList<>();

    for (String singleString : inputList) {
      inputListToLower.add(singleString.toLowerCase().trim());
    }

    userSingleChoice = (scanner.nextLine());
    userChoiceList = Arrays.asList(userSingleChoice.split(","));
    ListIterator<String> listIterator = userChoiceList.listIterator();
    while (listIterator.hasNext()) {
      userSingleChoice = listIterator.next();
      while (!inputListToLower.contains(userSingleChoice.toLowerCase().trim())) {
        if (userSingleChoice.isEmpty()) {
          break;
        }
        if (userSingleChoice.trim().length() == 1 && userSingleChoice.trim().matches("[1-2]")) {
          return Collections.singletonList(userSingleChoice);
        } else if (userSingleChoice.trim().length() > 1 && userSingleChoice.trim().substring(0, 1)
            .equals("0")
            && userSingleChoice.trim().matches("[0-9]+")
            && Integer.parseInt(userSingleChoice.trim().substring(1)) < inputList.size()) {
          userSingleChoice = inputList.get(Integer.parseInt(userSingleChoice.trim().substring(1)));
          /*System.out.println("sprawdzenie co wychodzi z numerykow: " + userSingleChoice);*/
          break;
        }
        System.out.println(userSingleChoice
            + " is an invalid input. Please proceed with DRINKS LIST MENU valid options (exception: only single search available)");
        userSingleChoice = scanner.nextLine();
        if (userSingleChoice.isEmpty()) {
          break;
        }

      }
      if (userSingleChoice.isEmpty()) {
        outputList.remove(userSingleChoice);
      } else {
        outputList.add(userSingleChoice);
      }
      listIterator.set(userSingleChoice);
    }
    return outputList;
  }

  public List<String> userInputForDrinkNameCheck(List<Recipe> inputList) {

    List<String> outputList = new ArrayList<>();
    Set<String> inputListToLower = new HashSet<>();

    for (Recipe singleRecipe : inputList) {
      inputListToLower.add(singleRecipe.getName().toLowerCase().trim());
    }

    while (outputList.isEmpty()) {
      String userSingleChoice = (scanner.nextLine().trim().toLowerCase());
      if (userSingleChoice.trim().length() == 1 && userSingleChoice.trim().matches("[1-2]")) {
        outputList.add(userSingleChoice);
        break;
      }
      if (userSingleChoice.length() >= 2) {
        outputList = inputListToLower.stream()
            .filter(recipeName -> recipeName.contains(userSingleChoice))
            .collect(Collectors.toList());
      } else if (inputListToLower.stream()
          .anyMatch(recipeName -> recipeName.equals(userSingleChoice))) {
        outputList.add(userSingleChoice);
      } else {
        System.out.println("Invalid input. Please proceed with DRINKS LIST MENU valid options");
      }

    }
    return outputList;
  }

  public List<String> userInputForFinalPickFromList(List<Recipe> inputList) {
    String userSingleChoice = scanner.nextLine().toLowerCase().trim();
    String outputString = "";

    while (outputString.isEmpty()) {
      if (userSingleChoice.trim().length() == 1 && userSingleChoice.trim().matches("[1-3]")) {
        return Collections.singletonList(userSingleChoice);
      } else if (userSingleChoice.trim().length() > 1 && userSingleChoice.trim().substring(0, 1)
          .equals("0")
          && userSingleChoice.trim().matches("[0-9]+")
          && Integer.parseInt(userSingleChoice.trim().substring(1)) < inputList.size()) {

        outputString = (inputList.get(Integer.parseInt(userSingleChoice.trim().substring(1))))
            .getName();
        break;
      }
      String finalUserSingleChoice = userSingleChoice;
      if (inputList.stream().anyMatch(
          recipe -> recipe.getName().toLowerCase().trim().equals(finalUserSingleChoice))) {
        outputString = userSingleChoice;
        break;
      }
      System.out.println("Invalid input. Please proceed with DRINKS LIST MENU valid options");
      userSingleChoice = scanner.nextLine();
    }
    return Collections.singletonList(outputString);
  }

  public List<String> userInputForRecipeView() {
    String userSingleChoice = scanner.nextLine();
    if (userSingleChoice.trim().length() == 1 && userSingleChoice.trim().matches("[1-6]")) {
      return Collections.singletonList(userSingleChoice);
    } else {
      System.out.println("Invalid input. Please proceed with DRINKS LIST MENU valid options");
      userInputForRecipeView();
    }
    return Collections.singletonList(userSingleChoice);
  }

  public boolean confirmMature() {

    if (MatureVerifier.isAlreadyCheckedAndMature()) {
      return true;
    }
    String ageChoice;
    String choiceSave;

    System.out.println("Do you have over 18 years? (enter yes / no)");
    ageChoice = scanner.nextLine();
    if ("yes".equals(ageChoice.toLowerCase())) {
      System.out.println("Do you want to save your choice?");
      choiceSave = scanner.nextLine();
      if ("yes".equals(choiceSave.toLowerCase())) {
        MatureVerifier.setMature();
      }
      return true;
    }
    return false;
  }


}