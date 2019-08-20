package com.infoshareacademy.menu;

import com.infoshareacademy.domain.Recipe;
import com.infoshareacademy.domain.RecipeRepository;
import com.infoshareacademy.properties.ConfigLoader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RecipeAddition {
    private ChoiceReader choiceReader = new ChoiceReader();
    private Scanner scanner = choiceReader.scanner;
    private int startIDNumber = 18000;

    public Recipe createNewRecipe() {
        Recipe recipe = new Recipe();
        recipe.setId(startIDNumber);
        startIDNumber++;
        recipe.setRecipeCategory(addRecipeAttributes());
        System.out.println("Enter name of recipe: ");
        recipe.setName(addRecipeName());
        System.out.println("Enter recipe instruction: ");
        recipe.setInstruction(addRecipeAttributes());
        System.out.println("Enter type of glass to serve this drink: ");
        recipe.setGlassType(addRecipeAttributes());
        System.out.println("Enter ingredients with its measure with format:\n " +
                "ingredient #1:measure #1, ingredient #2:measure #2 ... Maximum 15 ingredients");
        recipe.setIngredients(addIngredients());
        recipe.setModificationDate(getLocalDateTime());
        return recipe;
    }

    private String addRecipeAttributes() {
        return scanner.nextLine();
    }

    private String getLocalDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ConfigLoader.DATE_FORMAT_KEY);
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(formatter);
    }

    private String addRecipeName() {
        String name = scanner.nextLine();
        while (!checkNameIsOnRecipeList(name)) {
            System.out.println("This recipe name is already on all recipe list, enter new name: ");
            name = scanner.nextLine();
        }
        return name;
    }

    private boolean checkNameIsOnRecipeList(String name) {
        for (Recipe recipe : RecipeRepository.getRecipesList()
        ) {
            if (recipe.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    private Map<String, String> addIngredients() {
        String ingredients = scanner.nextLine();
        return Stream.of(ingredients.split(","))
                .map(elem -> elem.split(":"))
                .collect(Collectors.toMap(e -> e[0].trim(), e -> e[1].trim()));
    }
}
