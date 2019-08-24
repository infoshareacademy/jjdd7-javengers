package com.infoshareacademy.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.infoshareacademy.domain.Recipe;
import com.infoshareacademy.domain.RecipeRepository;
import org.apache.commons.lang3.NotImplementedException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeService {

    public void loadRecipesList() {
        if (RecipeRepository.getRecipesList().isEmpty()) {
            RecipeRepository.getRecipesList().addAll((List<Recipe>) DataParseService.parseFile("drinks.json",
                    new TypeReference<List<Recipe>>() {
                    }, "drinks"));
        }
    }

    public void loadFavouritesList() {
        if (RecipeRepository.getFavouritesRecipeList().isEmpty()) {
            RecipeRepository.getFavouritesRecipeList().addAll((List<Recipe>) DataParseService.parseFile("favourites.json",
                    new TypeReference<List<Recipe>>() {
                    }, "drinks"));
        }
    }

    public List<Recipe> findRecipeByName(List<Recipe> recipesList, String name) {
        throw new NotImplementedException("Not implemented yet");
    }

    public List<Recipe> findRecipeByIngredients(List<Recipe> recipesList, String ingredientName) {
        throw new NotImplementedException("Not implemented yet");
    }

    public List<Recipe> findRecipeByCategory(List<Recipe> recipesList, String recipeCategory) {
        throw new NotImplementedException("Not implemented yet");
    }

    public void addRecipeToList(Recipe recipe) {
        if (!RecipeRepository.getRecipesList().contains(recipe)) {
            RecipeRepository.getRecipesList().add(recipe);
            System.out.println("Recipe successfully added");
        } else {
            System.out.println("These recipe is already on list of all recipes");
        }
        DataConvertToJsonService.parseJsonToFile(RecipeRepository.getRecipesList(), "drinks.json");
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

        if (!isRecipeOnList){
            System.out.println("There is no recipe with these name on list of all recipes");
        }

        RecipeRepository.getRecipesList().remove(recipeToDelete);
        DataConvertToJsonService.parseJsonToFile(RecipeRepository.getRecipesList(), "drinks.json");
    }

    public void editRecipe(Map<String, Map<String, String>> editedRecipe, String name, String newDate) {
        Recipe recipeToEdit = null;
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
                if (recipeAttributes.getKey().equals(editedIngredients.getKey())) {
                    for (Map.Entry<String, String> changedIng : recipeAttributes.getValue().entrySet()) {
                        newIngredients.put(changedIng.getKey(), changedIng.getValue());
                    }
                } else {
                    newIngredients.put(editedIngredients.getKey(), editedIngredients.getValue());
                }
            }

            System.out.println(newIngredients);
            recipeToEdit.setIngredients(newIngredients);
            recipeToEdit.setModificationDate(newDate);
            DataConvertToJsonService.parseJsonToFile(RecipeRepository.getRecipesList(), "drinks.json");
        }
    }

    public List<Recipe> addRecipeToFavourites(List<Recipe> favouritesRecipeList, String name) {
        throw new NotImplementedException("Not implemented yet");
    }

    public List<Recipe> deleteRecipeFromFavourites(List<Recipe> favouritesRecipeList, String name) {
        throw new NotImplementedException("Not implemented yet");
    }
}