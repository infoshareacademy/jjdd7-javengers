package com.infoshareacademy.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.infoshareacademy.domain.Recipe;
import com.infoshareacademy.domain.RecipeRepository;
import com.infoshareacademy.properties.AppConfig;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class RecipeService {

    private static String SORT_TYPE = AppConfig.recipeSortType;
    public void loadRecipesList() {
        if (RecipeRepository.getRecipesList().isEmpty()) {
            RecipeRepository.getRecipesList().addAll((List<Recipe>) DataParseService.parseFile("drinks.json",
                    new TypeReference<List<Recipe>>() {
                    }, "drinks"));
            RecipeRepository.getRecipesList().stream().sorted(comparing(Recipe::getName)).collect(Collectors.toList());
            if (SORT_TYPE.equals("DESC")) {
                RecipeRepository.getRecipesList().sort(comparing(Recipe::getName, Comparator.reverseOrder()));
            } else {
                RecipeRepository.getRecipesList().sort(comparing(Recipe::getName));
            }
        }
    }
    public void loadFavouritesList() {
        if (RecipeRepository.getFavouritesRecipeList().isEmpty()) {
            RecipeRepository.getFavouritesRecipeList().addAll((List<Recipe>) DataParseService.parseFile("favourites.json",
                    new TypeReference<List<Recipe>>() {}, "drinks"));
            RecipeRepository.getFavouritesRecipeList().stream().sorted(comparing(Recipe::getName)).collect(Collectors.toList());
            if (SORT_TYPE.equals("DESC")) {
                RecipeRepository.getFavouritesRecipeList().sort(comparing(Recipe::getName, Comparator.reverseOrder()));
            } else {
                RecipeRepository.getFavouritesRecipeList().sort(comparing(Recipe::getName));
            }
        }
    }
    public void loadCategoriesList() {
        RecipeRepository.getCategoriesList().clear();
        List<String> tempList = new ArrayList<>();
        for (Recipe recipe : RecipeRepository.getRecipesList()
        ) {
            String category = recipe.getRecipeCategory();
            if (!RecipeRepository.getCategoriesList().contains(category)) {
                RecipeRepository.getCategoriesList().add(category);
            }
        }
        if (SORT_TYPE.equals("DESC")) {
            Collections.sort(RecipeRepository.getCategoriesList(), Collections.reverseOrder());
        } else {
            Collections.sort(RecipeRepository.getCategoriesList());
        }
    }
    public void loadIngredientsList() {
        RecipeRepository.getIngredientsList().clear();
        List<String> tempList = new ArrayList<>();
        for (Recipe recipe : RecipeRepository.getRecipesList()) {
            tempList.addAll(recipe.getIngredients().keySet());
        }
        RecipeRepository.getIngredientsList()
                .addAll(tempList.stream()
                        .map(String::toLowerCase)
                        .distinct()
                        .sorted()
                        .collect(Collectors.toList()));
    }

    public List<Recipe> findRecipeByName(List<Recipe> recipesList, List<String> userChoiceArrayList) {
        List<Recipe> outputList = new ArrayList<>();

        for (String userSingleChoice : userChoiceArrayList) {
            outputList.addAll(recipesList.stream()
                    .filter(r -> r.getName().toLowerCase().trim().equals(userSingleChoice.toLowerCase().trim()))
                    .collect(Collectors.toList()));
        }
        return outputList.stream().distinct().collect(Collectors.toList());
    }


    public List<Recipe> findRecipeByCategory(List<Recipe> recipesList, List<String> userChoiceArrayList) {
        List<Recipe> outputList = new ArrayList<>();

        for (String userSingleChoice : userChoiceArrayList) {
            outputList.addAll(recipesList.stream()
                    .filter(r -> r.getRecipeCategory().toLowerCase().trim().equals(userSingleChoice.toLowerCase().trim()))
                    .collect(Collectors.toList()));
        }
        return outputList.stream().distinct().collect(Collectors.toList());
    }

    public List<Recipe> findRecipeByIngredients(List<Recipe> recipesList, List<String> userChoiceArrayList) {

        List<Recipe> outputList = (recipesList.stream()
                .filter(r ->
                        (userChoiceArrayList.stream()
                                .allMatch(
                                        ingredient ->
                                                (" " + (r.getIngredients()
                                                        .keySet()) + " ")
                                                        .toString()
                                                        .replace(",", " ")
                                                        .replace("[", "")
                                                        .replace("]", "")
                                                        .toLowerCase()
                                                        .contains(" " + ingredient.trim() + " ")))))
                .collect(Collectors.toList());

        for (Recipe recipe : outputList) {
            System.out.println(recipe.getName() + "  " + recipe.getIngredients().keySet());

        }
        return outputList.stream().distinct().collect(Collectors.toList());
    }

    public void addRecipeToList(Recipe recipe) {
        if (!RecipeRepository.getRecipesList().contains(recipe)) {
            RecipeRepository.getRecipesList().add(recipe);
            System.out.println("Recipe successfully added");
        } else {
            System.out.println("These recipe is already on list of all recipes");
        }
        DataConvertToJsonService.parseJsonToFile(RecipeRepository.getRecipesList(), "drinks.json");
        loadCategoriesList();
        loadIngredientsList();
    }

    public void deleteRecipeFromList(String name) {
        Recipe recipeToDelete = null;
        boolean isRecipeOnList = false;
        for (Recipe recipe : RecipeRepository.getRecipesList()
        ) {
            if (recipe.getName().equals(name)) {
                recipeToDelete = recipe;
                System.out.println("Recipe successfully removed");
                isRecipeOnList = true;
            }
        }
        if (!isRecipeOnList) {
            System.out.println("There is no recipe with these name on list of all recipes");
        }
        RecipeRepository.getRecipesList().remove(recipeToDelete);
        RecipeRepository.getFavouritesRecipeList().remove(recipeToDelete);
        DataConvertToJsonService.parseJsonToFile(RecipeRepository.getRecipesList(), "drinks.json");
        loadCategoriesList();
        loadIngredientsList();
    }

    public void editRecipe(Map<String, Map<String, String>> editedRecipe, String name, String newDate) {
        Recipe recipeToEdit = null;
        Recipe recipeToRemoveFromFavourites = null;
        for (Recipe recipe : RecipeRepository.getRecipesList()
        ) {
            if (recipe.getName().equals(name)) {
                recipeToEdit = recipe;
            }
        }
        for (Map.Entry<String, Map<String, String>> recipeAttributes : editedRecipe.entrySet()) {
            assert recipeToEdit != null;
            if (recipeAttributes.getKey().equals(recipeToEdit.getName())) {
                recipeToEdit.setName(recipeAttributes.getValue().get("name"));
            }

            if (recipeAttributes.getKey().equals(recipeToEdit.getInstruction())) {
                recipeToEdit.setInstruction(recipeAttributes.getValue().get("instruction"));
            }
            if (recipeAttributes.getKey().equals(recipeToEdit.getGlassType())) {
                recipeToEdit.setGlassType(recipeAttributes.getValue().get("glassType"));
            }
            if (recipeAttributes.getKey().equals(recipeToEdit.getDrinkType())) {
                recipeToEdit.setDrinkType(recipeAttributes.getValue().get("drinkType"));
            }
            if (recipeAttributes.getKey().equals(recipeToEdit.getRecipeCategory())) {
                recipeToEdit.setRecipeCategory(recipeAttributes.getValue().get("category"));
            }
            Map<String, String> newIngredients = new HashMap<>();

            Map<String, String> ingredientsOfRecipeToEdit = recipeToEdit.getIngredients();

            for (Map.Entry<String, String> editedIngredients : ingredientsOfRecipeToEdit.entrySet()) {
                if (recipeAttributes.getKey().equals(editedIngredients.getKey())){
                    for (Map.Entry<String, String> changedIng : recipeAttributes.getValue().entrySet()) {
                        newIngredients.put(changedIng.getKey(), changedIng.getValue());
                    }
                } else {
                    newIngredients.put(editedIngredients.getKey(), editedIngredients.getValue());
                }
            }

            if (recipeAttributes.getKey().equals("@#$%^&")){
                Map<String, String> ingredients = recipeAttributes.getValue();
                for (Map.Entry<String, String> changedIng : ingredients.entrySet()) {
                    newIngredients.put(changedIng.getKey(),changedIng.getValue());
                }
            }
            recipeToEdit.setIngredients(newIngredients);

            for (Recipe recipe : RecipeRepository.getFavouritesRecipeList()
            ) {
                if (recipe.getName().equals(name)) {
                    recipeToRemoveFromFavourites = recipe;
                }
            }
            recipeToEdit.setModificationDate(newDate);
            RecipeRepository.getFavouritesRecipeList().remove(recipeToRemoveFromFavourites);
            RecipeRepository.getFavouritesRecipeList().add(recipeToEdit);
            DataConvertToJsonService.parseJsonToFile(RecipeRepository.getRecipesList(), "drinks.json");
            loadCategoriesList();
            loadIngredientsList();
        }
    }

    public void addOrRemoveRecipeToFavourites(String recipeName) {
        if (RecipeRepository.getFavouritesRecipeList().stream().anyMatch(recipe -> recipe.getName().equals(recipeName))) {
            List<Recipe> recipeToDelete = findRecipeByName(RecipeRepository
                    .getFavouritesRecipeList(), Collections.singletonList(recipeName));
            RecipeRepository.getFavouritesRecipeList().remove(recipeToDelete.get(0));
        } else {
            List<Recipe> recipeToDelete = findRecipeByName(RecipeRepository
                    .getRecipesList(), Collections.singletonList(recipeName));
            RecipeRepository.getFavouritesRecipeList().add(recipeToDelete.get(0));
        }
        DataConvertToJsonService.parseJsonToFile(RecipeRepository.getFavouritesRecipeList(), "favourites.json");
    }
}
