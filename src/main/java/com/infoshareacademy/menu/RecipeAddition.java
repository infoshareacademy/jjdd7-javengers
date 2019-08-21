package com.infoshareacademy.menu;

import com.infoshareacademy.domain.Recipe;
import com.infoshareacademy.domain.RecipeRepository;
import com.infoshareacademy.properties.AppConfig;
import com.infoshareacademy.properties.ConfigLoader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RecipeAddition {
    private ChoiceReader choiceReader = new ChoiceReader();
    private Scanner scanner = choiceReader.scanner;
    private int startIDNumber = 18000;
    private int maximumIngredientsNumber = 15;

    public Recipe createNewRecipe() {
        Recipe recipe = new Recipe();
        recipe.setId(startIDNumber);
        startIDNumber++;
        recipe.setRecipeCategory(loadRecipeAttributes()); //TODO Add method to print out category list
        System.out.println("Enter name of recipe:");
        recipe.setName(addRecipeName());
        System.out.println("Enter recipe instruction:");
        recipe.setInstruction(loadRecipeAttributes());
        System.out.println("Enter type of glass to serve this drink:");
        recipe.setGlassType(loadRecipeAttributes());
        System.out.println("To choose drink type enter number of drinkType from list:");
        recipe.setDrinkType(loadDrinkType());
        recipe.setIngredients(getFullListOfIngredients());
        recipe.setModificationDate(getLocalDateTime());
        return recipe;
    }

    private String loadDrinkType(){
        System.out.println("1. Alcoholic\n2. Non alcoholic\n3. Optional alcohol");
        String userInput = scanner.nextLine().trim();
        String drinkType ="";
        switch (userInput) {
            case "1":
                drinkType = "Alcoholic";
                break;
            case "2":
                drinkType = "Non alcoholic";
                break;
            case "3":
                drinkType = "Optional alcohol";
                break;
            default:
                System.out.println("Invalid input, type one more time ");
                loadDrinkType();
                break;
        }
        return drinkType;
    }

    private String loadRecipeAttributes(){
        String userInput = scanner.nextLine().trim();
        while (userInput.length()<1){
            System.out.println("Your input is to short, type it one more time");
            userInput = scanner.nextLine().trim();
        }
        return userInput;
    }


    private String getLocalDateTime() { //TODO have to use Klaudia method
        new ConfigLoader().loadAppConfig();
        String DATE_FORMATTER = AppConfig.dateFormat;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
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

    private Map<String, String> getFullListOfIngredients(){
        Map<String, String> listOfIngredients = getListOfIngredients();
        for (int i = listOfIngredients.size(); i<maximumIngredientsNumber ;i++ ){
            listOfIngredients.put("","");
        }
        System.out.println(listOfIngredients);
        return listOfIngredients;
    }

    private Map<String, String> getListOfIngredients() {
        Map<String, String> ingredients = new HashMap<>();
        System.out.println("Enter ingredient and its measure\nInput format: ingredient measure");
        String[]ingredient = loadIngredientWithMeasure();
        ingredients.putIfAbsent(ingredient[0].trim(),ingredient[1].trim());
        String userInput;
        do {
            System.out.println("do you want to add next ingredient?\nenter: y / n");
            userInput = scanner.nextLine().toLowerCase();
            if (userInput.equals("n")) {
                break;
            }
            while (!userInput.equals("y")&&!userInput.equals("n")){
                System.out.println("invalid input, enter y or n");
                userInput = scanner.nextLine().toLowerCase();
            }
            System.out.println("Enter ingredient and its measure\nInput format: ingredient measure");
            ingredient = loadIngredientWithMeasure();
            ingredients.putIfAbsent(ingredient[0].trim(),ingredient[1].trim());
        }while (userInput.equals("y") && ingredients.size()<maximumIngredientsNumber); //prevent to add more then 15 ingredients
        System.out.println(ingredients);
        return ingredients;
    }

    private String[] loadIngredientWithMeasure() {
        String userInput = scanner.nextLine();
        String[] ingredientAndMeasure = userInput.split(" ");
        while (ingredientAndMeasure.length<2||ingredientAndMeasure[0].trim().isEmpty() || ingredientAndMeasure[1].trim().isEmpty() ){
            System.out.println("invalid format of input\nEnter ingredient measure");
            userInput = scanner.nextLine();
            ingredientAndMeasure = userInput.split(" ");
        }
        return ingredientAndMeasure;
    }
}