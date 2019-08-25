package com.infoshareacademy.menu;

import com.infoshareacademy.domain.Recipe;
import com.infoshareacademy.domain.RecipeRepository;
import com.infoshareacademy.properties.AppConfig;
import com.infoshareacademy.properties.ConfigLoader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

class RecipeAddAndEditManager {
    private ChoiceReader userChoice = new ChoiceReader();
    private ListsPrinter listsPrinter = new ListsPrinter();
    private Scanner scanner = new Scanner(System.in);
    private int startIDNumber = 18000;

    Recipe createNewRecipe() {
        Recipe recipe = new Recipe();
        recipe.setId(startIDNumber);
        startIDNumber++;
        listsPrinter.printCategory(RecipeRepository.getCategoriesList());
        System.out.println("Enter recipe category (name) from list above or type your own:");
        recipe.setRecipeCategory(loadCategory(loadRecipeAttributes()));
        System.out.println("Enter name of recipe:");
        recipe.setName(addRecipeName());
        System.out.println("Enter recipe instruction:");
        recipe.setInstruction(loadInstruction());
        System.out.println("Enter type of glass to serve this drink:");
        recipe.setGlassType(loadRecipeAttributes());
        System.out.println("To choose drink type enter number of drinkType from list:");
        recipe.setDrinkType(getDrinkType());
        recipe.setIngredients(getListOfIngredients());
        recipe.setModificationDate(getLocalDateTime());
        return recipe;
    }

    private String loadRecipeAttributes() {
        String userInput = scanner.nextLine().toLowerCase().trim();
        while (userInput.length() < 2) {
            System.out.println("Your input is to short, type it one more time");
            userInput = scanner.nextLine().toLowerCase().trim();
        }
        return userInput;
    }

    private String loadCategory(String userInput){
        for (String category: RecipeRepository.getCategoriesList()){
            if (category.toLowerCase().equals(userInput)){
                return category;
            }
        }
        return userInput;
    }

    private String loadInstruction() {
        String userInput = scanner.nextLine().trim();
        while (userInput.length() < 5) {      // 5 because the shortest will be "do it"
            System.out.println("Your input is to short, type it one more time");
            userInput = scanner.nextLine().trim();
        }
        return userInput;
    }

    private String addRecipeName() {
        String name = loadRecipeAttributes();
        while (!checkNameIsOnRecipeList(name)) {
            System.out.println("This recipe name is already on all recipe list, enter new name: ");
            name = scanner.nextLine().trim();
        }
        return name;
    }

    String loadRecipeName(String name) {
        while (checkNameIsOnRecipeList(name)) {
            System.out.println("There is no recipe with these name on recipes list, type one more time: ");
            name = scanner.nextLine().trim();
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

    private String getDrinkType() {
        System.out.println("1. Alcoholic\n2. Non alcoholic\n3. Optional alcohol\nEnter number");
        String userInput = scanner.nextLine().trim();
        String drinkType = "";
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
                getDrinkType();
                break;
        }
        return drinkType;
    }

    private Map<String, String> getListOfIngredients() {
        Map<String, String> ingredients = new HashMap<>();
        System.out.println("Enter ingredient and its measure\nInput format: ingredient measure");
        String[] oneIngredient = getIngredientWithMeasure();
        ingredients.putIfAbsent(oneIngredient[0].trim(), oneIngredient[1].trim());
        String userInput;
        int maximumIngredientsNumber = 15;
        do {
            System.out.println("do you want to add next ingredient?\nenter: y / n");
            userInput = scanner.nextLine().toLowerCase().trim();
            if (userInput.equals("n")) {
                break;
            }
            while (!userInput.equals("y") && !userInput.equals("n")) {
                System.out.println("invalid input, enter y or n");
                userInput = scanner.nextLine().toLowerCase();
            }
            System.out.println("Enter ingredient and its measure\nInput format: ingredient measure");
            oneIngredient = getIngredientWithMeasure();
            ingredients.putIfAbsent(oneIngredient[0].trim(), oneIngredient[1].trim());
        } while (userInput.equals("y") && ingredients.size() < maximumIngredientsNumber); //prevent to add more then 15 ingredients
        return ingredients;
    }

    private String[] getIngredientWithMeasure() {
        String userInput = scanner.nextLine();
        String[] ingredientAndMeasure = userInput.split(" ");
        while (ingredientAndMeasure.length < 2 || ingredientAndMeasure[0].trim().isEmpty() || ingredientAndMeasure[1].trim().isEmpty()) {
            System.out.println("invalid format of input\nEnter ingredient measure");
            userInput = scanner.nextLine();
            ingredientAndMeasure = userInput.split(" ");
        }
        return ingredientAndMeasure;
    }

    String getLocalDateTime() { //TODO have to use Klaudia method
        new ConfigLoader().loadAppConfig();
        String DATE_FORMATTER = AppConfig.dateFormat;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(formatter);
    }

    Map<String, Map<String, String>> editRecipe(String drinkName) {
        Map<String, Map<String, String>> editedAttributes = new HashMap<>();
        System.out.println("What do you want to edit?\n");
        System.out.println("1. Name\n2. Instruction\n3. Category\n4. Drink type"
                + "\n5. Type of glass\n6. Ingredients\n7. exit");
        System.out.println("\nEnter number");
        String userInput = scanner.nextLine().trim();
        String userChoice;
        Recipe recipe = getRecipeFromList(drinkName);
        do {
            switch (userInput) {
                case "1":
                    System.out.println("Enter new name of recipe:");
                    String name = addRecipeName();
                    Map<String, String> newAttribute = new HashMap<>();
                    newAttribute.put("name", name);
                    editedAttributes.putIfAbsent(recipe.getName(), newAttribute);
                    break;
                case "2":
                    System.out.println("Enter new recipe instruction:");
                    String instruction = loadInstruction();
                    Map<String, String> newAttribute1 = new HashMap<>();
                    newAttribute1.put("instruction", instruction);
                    editedAttributes.putIfAbsent(recipe.getInstruction(), newAttribute1);
                    break;
                case "3":
                    System.out.println("Enter new recipe category from list or type your own:");
                    listsPrinter.printCategory(RecipeRepository.getCategoriesList());
                    String category = loadRecipeAttributes();
                    Map<String, String> newAttribute2 = new HashMap<>();
                    newAttribute2.put("category", category);
                    editedAttributes.putIfAbsent(recipe.getRecipeCategory(), newAttribute2);
                    break;
                case "4":
                    System.out.println("To edit drink type enter number of drinkType from list:");
                    String drinkType = getDrinkType();
                    Map<String, String> newAttribute3 = new HashMap<>();
                    newAttribute3.put("drinkType", drinkType);
                    editedAttributes.putIfAbsent(recipe.getDrinkType(), newAttribute3);
                    break;
                case "5":
                    System.out.println("Enter new type of glass to serve this drink:");
                    String glassType = loadRecipeAttributes();
                    Map<String, String> newAttribute4 = new HashMap<>();
                    newAttribute4.put("glassType", glassType);
                    editedAttributes.putIfAbsent(recipe.getGlassType(), newAttribute4);
                    break;
                case "6":
                    for (Map.Entry<String, Map<String, String>> ingredientNumber : editIngredients(drinkName).entrySet()) {
                        editedAttributes.putIfAbsent(ingredientNumber.getKey(), ingredientNumber.getValue());
                    }
                    break;
                case "7":
                    break;
                default:
                    System.out.println("Invalid input, type one more time ");
                    editRecipe(drinkName);
                    break;
            }
            System.out.println("do you wan to edit something more? Enter y /n ");
            userChoice = validateUserInput(scanner.nextLine().toLowerCase().trim());
            if (userChoice.equals("n")) {
                break;
            }
            System.out.println("What do you want to edit?\n");
            System.out.println("1. Name\n2. Instruction\n3. Category\n4. Drink type\n5. Type of glass\n6. Ingredients");
            System.out.println("\nEnter number");
            userInput = scanner.nextLine().trim();
        } while (userChoice.equals("y"));
        System.out.println(editedAttributes);
        return editedAttributes;
    }

    private Recipe getRecipeFromList(String name) {
        Recipe drinkRecipe = null;
        for (Recipe recipe : RecipeRepository.getRecipesList()
        ) {
            if (recipe.getName().equals(name)) {
                drinkRecipe = recipe;
            }
        }
        return drinkRecipe;
    }

    private Map<String, Map<String, String>> editIngredients(String drinkName) {
        Map<String, Map<String, String>> editedIngredients = new HashMap<>();
        Map<Integer, Map<String, String>> ingredients = getIngredientsWithIndex(getIngredients(drinkName));
        String userInput = "y";
        int ingredientSize = ingredients.size();
        while (userInput.equals("y") && ingredientSize > 0) {
            System.out.println("\nWhich ingredient would you like to edit?\n");
            listsPrinter.printIngredients(ingredients);
            System.out.println();
            int ingredientNumber = userChoice.makeMenuChoice();
            while (!ingredients.containsKey(ingredientNumber)) {
                System.out.println("invalid number, there is no number of ingredient on list:");
                listsPrinter.printIngredients(ingredients);
                System.out.println();
                ingredientNumber = userChoice.makeMenuChoice();
            }
            String ingredientName = null;
            Map<String,String> ingredientsOfCurrentRecipe = ingredients.get(ingredientNumber);
            for (Map.Entry<String, String> recipeIngredients : ingredientsOfCurrentRecipe.entrySet()) {
                ingredientName = recipeIngredients.getKey();
            }
            System.out.println("Enter ingredient and its measure\nInput format: \"ingredient\" \"measure\"");
            String[] ingredientArray = getIngredientWithMeasure();
            Map<String, String> ingredientsToEdit = new HashMap<>();
            ingredientsToEdit.put(ingredientArray[0].trim(), ingredientArray[1].trim());
            editedIngredients.putIfAbsent(ingredientName, ingredientsToEdit);
            if (ingredientSize > 1) {
                System.out.println("Do you want to edit next ingredient? Enter y / n");
                userInput = validateUserInput(scanner.nextLine().toLowerCase().trim());
            }
            --ingredientSize;
        }
        //TODO create a method to add ingredients to existing/edited  to reach max 15 ingredients
        return editedIngredients;
    }

    private String validateUserInput(String userChoice) {
        while (!userChoice.equals("y") && !userChoice.equals("n")) {
            System.out.println("invalid input, enter y or n");
            userChoice = scanner.nextLine().toLowerCase();
        }
        return userChoice;
    }

    private Map<String, String> getIngredients(String drinkName) {
        List<Map<String, String>> ingredients = RecipeRepository.getRecipesList().stream()
                .filter(recipe -> recipe.getName().equals(drinkName))
                .map(Recipe::getIngredients)
                .collect(Collectors.toList());
        return ingredients.get(0);
    }

    private Map<Integer, Map<String, String>> getIngredientsWithIndex(Map<String, String> ingredients) {
        Map<Integer, Map<String, String>> ingredientsWithIndex = new HashMap<>();
        int index = 1;
        for (Map.Entry<String, String> ingredientNumber : ingredients.entrySet()) {
            Map<String, String> recipeIngredients = new HashMap<>();
            recipeIngredients.put(ingredientNumber.getKey(), ingredientNumber.getValue());
            ingredientsWithIndex.put(index++, recipeIngredients);
        }
        System.out.println(ingredientsWithIndex);
        return ingredientsWithIndex;
    }
}