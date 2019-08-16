package com.infoshareacademy.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.infoshareacademy.domain.Recipe;
import com.infoshareacademy.domain.RecipeRepository;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;
import java.util.stream.Collectors;

public class RecipeService {

    private List<Recipe> recipesList = RecipeRepository.getRecipesList();
    private List<Recipe> favouriteRecipesList = RecipeRepository.getFavouritesRecipeList();
    private List<String> categoryList = RecipeRepository.getCategoriesList();

    public List<Recipe> loadRecipesList() {
        DataParseService parser = new DataParseService();
        recipesList.addAll((List<Recipe>) parser.parseFile("drinks.json",
                new TypeReference<List<Recipe>>() {
                }, "drinks"));
        return recipesList;
    }

    public List<Recipe> loadFavouritesList() {
        DataParseService parser = new DataParseService();
        favouriteRecipesList.addAll((List<Recipe>) parser.parseFile("favourites.json",
                new TypeReference<List<Recipe>>() {
                }, "drinks"));
        return favouriteRecipesList;
    }

    public List<String> loadCategoriesList() {
        for (Recipe recipe:recipesList
             ) {
            String category =recipe.getRecipeCategory();
            if (!categoryList.contains(category)){
                categoryList.add(category);
            }
        }
        return categoryList;
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
        if (!recipesList.contains(recipe)) {
            recipesList.add(recipe);
        }
    }

    public void deleteRecipeFromList(String name) {
        for (Recipe recipe : recipesList
        ) {
            if (recipe.getName().equals(name)) {
                recipesList.remove(recipe);
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

    public List<Recipe> getRecipesList() {
        return recipesList;
    }

    public List<Recipe> getFavouriteRecipesList() {
        return favouriteRecipesList;
    }
}
