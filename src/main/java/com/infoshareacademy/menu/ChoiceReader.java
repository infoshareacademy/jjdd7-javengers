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


    public List<String> userListMenuChoice(List<String> categoryList, String listName) {

        List<String> outputArrayList = new ArrayList<>();
        Set<String> categoryListToLower = new HashSet<>();
        String userSingleChoice = "";

        for (String setOfStrings : categoryList) {
            categoryListToLower.add(setOfStrings.toLowerCase().trim());
        }

        System.out.println("\nEnter "+ listName +" (or more than one "+listName+" divided by a colon ',') to find recipes: ");
        List<String> userChoiceArrayList = Arrays.asList(scanner.nextLine().split(","));

        ListIterator<String> listIterator = userChoiceArrayList.listIterator();
        while(listIterator.hasNext()){
            userSingleChoice = listIterator.next();
            while(!categoryListToLower.contains(userSingleChoice.toLowerCase().trim())) {
                System.out.println(userSingleChoice + " is not a valid "+listName+". Please input the correct one or hit enter to remove wrongly typed "+listName);
                userSingleChoice = scanner.nextLine();
                if (userSingleChoice.isEmpty()){
                    break;
                }
                else if (userSingleChoice.trim().equals(
                                "0"+categoryList.get(categoryList.indexOf(userSingleChoice)))){
                    break;
                }
            }
            if (userSingleChoice.isEmpty()) {
                outputArrayList.remove(userSingleChoice);
            } else {
                outputArrayList.add(userSingleChoice);
            }
            listIterator.set(userSingleChoice);
        }
        return  outputArrayList;
    }
}