package com.infoshareacademy.menu;

import com.infoshareacademy.domain.Recipe;
import org.apache.commons.lang3.math.NumberUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChoiceReader {
    private Scanner scanner = new Scanner(System.in);
    private int startIDNumber = 18000;
    private static final String DATE_FORMATTER = "yyyy-MM-dd HH:mm:ss";

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

    public Recipe createNewRecipe() {
        Recipe recipe = new Recipe();
        recipe.setId(startIDNumber);
        System.out.println("Enter category of recipe: ");
        String recipeCategory = scanner.nextLine();
        recipe.setRecipeCategory(recipeCategory);
        System.out.println("Enter name of recipe: ");
        String name = scanner.nextLine();
        recipe.setName(name);
        System.out.println("Enter recipe instruction: ");
        String instruction = scanner.next();
        recipe.setInstruction(instruction);
        scanner.nextLine();
        System.out.println("Enter type of glass to serve this drink: ");
        String glassType = scanner.nextLine();
        recipe.setGlassType(glassType);
        System.out.println("Enter ingredients with its measure: ");
        Map<String, String> ingredientsMap = new HashMap<>();
        String ingredients = scanner.nextLine();
        //stream
        recipe.setIngredients(ingredientsMap);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        LocalDateTime localDateTime = LocalDateTime.now();
        String formatDateTime = localDateTime.format(formatter);
        recipe.setModificationDate(formatDateTime);
        startIDNumber++;
        return recipe;
    }
}