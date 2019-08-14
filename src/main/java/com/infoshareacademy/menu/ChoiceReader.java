package com.infoshareacademy.menu;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Scanner;

public class ChoiceReader {
    private Scanner scanner = new Scanner(System.in);

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
}