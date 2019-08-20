package com.infoshareacademy.menu;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.*;

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

        if (NumberUtils.isCreatable(choiceFromMenu)) {
            userChoice = Integer.parseInt(choiceFromMenu);
        } else {
            System.out.println("Invalid choice, type one more time");
            makeMenuChoice();
        }

        return userChoice;
    }


    public List<String> userInputForListsCheck(List<String> inputList, String listName) {

        List<String> outputList = new ArrayList<>();
        Set<String> inputListToLower = new HashSet<>();
        String userSingleChoice = "";


        for (String singleString : inputList) {
            inputListToLower.add(singleString.toLowerCase().trim());
        }

        System.out.println("\nEnter List No or " + listName + " name(or more than one List No or " + listName +
                " divided by a colon ',') to find recipes: ");
        List<String> userChoiceList = Arrays.asList(scanner.nextLine().split(","));

        ListIterator<String> listIterator = userChoiceList.listIterator();
        while (listIterator.hasNext()) {
            userSingleChoice = listIterator.next();
            while (!inputListToLower.contains(userSingleChoice.toLowerCase().trim())) {
                if (userSingleChoice.trim().substring(0, 1).equals("0")
                        && userSingleChoice.trim().matches("[0-9]+")
                        && Integer.parseInt(userSingleChoice.substring(1)) < inputList.size()) {
                    userSingleChoice = inputList.get(Integer.parseInt(userSingleChoice.substring(1)));
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
}