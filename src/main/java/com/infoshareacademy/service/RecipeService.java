package com.infoshareacademy.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.infoshareacademy.domain.Recipe;
import com.infoshareacademy.domain.RecipeRepository;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;
import java.util.stream.Collectors;

public class RecipeService {

    public List<Recipe> loadRecipesList() {
        if(RecipeRepository.getRecipesList().isEmpty()){
            DataParseService parser = new DataParseService();
            RecipeRepository.getRecipesList().addAll((List<Recipe>) parser.parseFile("drinks.json",
                    new TypeReference<List<Recipe>>() {
                    }, "drinks"));
        }
        return RecipeRepository.getRecipesList();
    }

    public List<Recipe> loadFavouritesList() {
        DataParseService parser = new DataParseService();
        RecipeRepository.getFavouritesRecipeList().addAll((List<Recipe>) parser.parseFile("favourites.json",
                new TypeReference<List<Recipe>>() {
                }, "drinks"));
        return RecipeRepository.getFavouritesRecipeList();
    }

    public List<String> loadCategoriesList() {
        if(RecipeRepository.getRecipesList().isEmpty()){
            loadRecipesList();
        }
        for (Recipe recipe:RecipeRepository.getRecipesList()
             ) {
            String category =recipe.getRecipeCategory();
            if (!RecipeRepository.getCategoriesList().contains(category)){
                RecipeRepository.getCategoriesList().add(category);
            }
        }
        return RecipeRepository.getCategoriesList();
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
        }
    }

    public void deleteRecipeFromList(String name) {
        for (Recipe recipe : RecipeRepository.getRecipesList()
        ) {
            if (recipe.getName().equals(name)) {
                RecipeRepository.getRecipesList().remove(recipe);
            }
        }
    }

    public void editRecipeList(Recipe drinkRecipe, String name) {
        throw new NotImplementedException("Not implemented yet");
    }

    public List<Recipe> addRecipeToFavourites(List<Recipe> favouritesRecipeList, String name) {
        throw new NotImplementedException("Not implemented yet");
    }

    public List<Recipe> deleteRecipeFromFavourites(List<Recipe> favouritesRecipeList, String name) {
        throw new NotImplementedException("Not implemented yet");
    }

    /*public List<Recipe> getRecipesList() {
        return RecipeRepository.getRecipesList();
    }

    public List<Recipe> getFavouriteRecipesList() {
        return favouriteRecipesList;
    }*/
}
