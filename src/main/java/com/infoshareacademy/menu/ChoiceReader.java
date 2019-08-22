package com.infoshareacademy.menu;

import com.infoshareacademy.domain.Recipe;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.*;
import java.util.stream.Collectors;

public class ChoiceReader {
    private Scanner scanner = new Scanner(System.in);

    String makeChoice() {
        return scanner.nextLine();
    }


    public int makeMenuChoice() {
        int userChoice = 0;
        String choiceFromMenu;
        System.out.println("Provide a number: ");
        choiceFromMenu = scanner.nextLine();

        if (NumberUtils.isCreatable(choiceFromMenu) && Integer.parseInt(choiceFromMenu)<9 && Integer.parseInt(choiceFromMenu)>0) {
            userChoice = Integer.parseInt(choiceFromMenu);
        } else {
            System.out.println("Invalid choice, type one more time");
            makeMenuChoice();
        }
        return userChoice;
    }


    public List<String> userInputForListsCheck(List<String> inputList, String listName) {

        //jest bug jak pomylona pierwsza nazwa drinka i wciskamy enter!!

        List<String> outputList = new ArrayList<>();
        Set<String> inputListToLower = new HashSet<>();
        String userSingleChoice = "";

        for (String singleString : inputList) {
            inputListToLower.add(singleString.toLowerCase().trim());
        }

        List<String> userChoiceList = Arrays.asList(scanner.nextLine().split(","));
        ListIterator<String> listIterator = userChoiceList.listIterator();
        while (listIterator.hasNext()) {
            userSingleChoice = listIterator.next();
            while (!inputListToLower.contains(userSingleChoice.toLowerCase().trim())) {
                if (userSingleChoice.equals("1")){
                    return Arrays.asList(userSingleChoice);
                }
                if (userChoiceList.equals("2")) {
                    return Arrays.asList(userSingleChoice);
                }

                if (userSingleChoice.trim().substring(0, 1).equals("0")
                        && userSingleChoice.trim().matches("[0-9]+")
                        && Integer.parseInt(userSingleChoice.trim().substring(1)) < inputList.size()) {
                    userSingleChoice = inputList.get(Integer.parseInt(userSingleChoice.trim().substring(1)));
                    break;
                }
                System.out.println(userSingleChoice + " is not a valid " + listName +
                        ". Please input the correct List No or " + listName +
                        " or hit enter to remove wrongly typed " + listName);
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


    public List<String> userInputForDrinkNameCheck(List<Recipe> inputList, String listName) {

        List<String> outputList = new ArrayList<>();
        Set<String> inputListToLower = new HashSet<>();

        for (Recipe singleRecipe : inputList) {
            inputListToLower.add(singleRecipe.getName().toLowerCase().trim());
        }

        while (outputList.isEmpty()) {
            //System.out.println("\nEnter a drink name (or at least 3 characters to find matching recipe ");
            String userSingleChoice = (scanner.nextLine().trim().toLowerCase());
            if (userSingleChoice.equals("1")) {
                outputList.add(userSingleChoice);
                break;
            }
            if (userSingleChoice.equals("2")) {
                outputList.add(userSingleChoice);
                break;
            }
            if (userSingleChoice.length() >= 3) {
                outputList = inputListToLower.stream().filter(recipeName -> recipeName.contains(userSingleChoice)).collect(Collectors.toList());
            }
            if (userSingleChoice.length() < 3 && inputListToLower.stream().anyMatch(recipeName -> recipeName.equals(userSingleChoice))) {
                outputList.add(userSingleChoice);
            } else {
                System.out.println("No such input");
            }

        }
        return outputList;
    }


    public String userInputForFinalPickFromList(List<Recipe> inputList) {

        String userSingleChoice = scanner.nextLine().toLowerCase().trim();
        String outputString="";

        while (outputString.isEmpty()) {
            if (userSingleChoice.equals("1")) {
                return userSingleChoice;
            }
            if (userSingleChoice.equals("2")) {
                return userSingleChoice;
            }

            if (userSingleChoice.trim().substring(0, 1).equals("0")
                    && userSingleChoice.trim().matches("[0-9]+")
                    && Integer.parseInt(userSingleChoice.trim().substring(1)) < inputList.size()) {

                outputString = String.valueOf(inputList.get(Integer.parseInt(userSingleChoice.trim().substring(1))));
                break;
            }
            System.out.println(userSingleChoice + " is not a valid Drink name Please input the correct List No or " +
                    "or hit enter to remove wrongly typed  listName");
            userSingleChoice = scanner.nextLine();
            if (userSingleChoice.isEmpty()) {
                break;
            }
        }
        return outputString;
    }



}