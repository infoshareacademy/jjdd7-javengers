package com.infoshareacademy;

import java.util.InputMismatchException;
import java.util.Scanner;

class ChoiceReader {
    private int yourChoice;
    private String yourChoiceName;
    private Scanner scanner = new Scanner(System.in);


    int choiceMaker(int numberOfChoices) {
        try {
            yourChoice = scanner.nextInt();
        } catch (InputMismatchException e) {
        }
        return yourChoice;
    }

    String choiceMaker() {
        try {
            yourChoiceName = scanner.nextLine();
        } catch (InputMismatchException e) {
        }
        return yourChoiceName;
    }

}