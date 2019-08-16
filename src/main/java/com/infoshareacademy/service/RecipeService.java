package com.infoshareacademy.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.infoshareacademy.domain.Recipe;
import com.infoshareacademy.domain.RecipeRepository;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;
import java.util.stream.Collectors;

public class RecipeService {

    public static final List<String> CATEGORIES_LIST = RecipeRepository.getCategoriesList();
    public static final List<Recipe> RECIPES_LIST = RecipeRepository.getRecipesList();
    public static final List<Recipe> FAVOURITES_RECIPE_LIST = RecipeRepository.getFavouritesRecipeList();

    public List<Recipe> loadRecipesList() {
        if (RECIPES_LIST.isEmpty()) {
            DataParseService parser = new DataParseService();
            RECIPES_LIST.addAll((List<Recipe>) parser.parseFile("drinks.json",
                    new TypeReference<List<Recipe>>() {
                    }, "drinks"));
        }
        return RECIPES_LIST;
    }

    public List<Recipe> loadFavouritesList() {
        DataParseService parser = new DataParseService();
        FAVOURITES_RECIPE_LIST.addAll((List<Recipe>) parser.parseFile("favourites.json",
                new TypeReference<List<Recipe>>() {
                }, "drinks"));
        return FAVOURITES_RECIPE_LIST;
    }

    public List<String> loadCategoriesList() {
        if (RECIPES_LIST.isEmpty()) {
            loadRecipesList();
        }
        for (Recipe recipe : RECIPES_LIST
        ) {
            String category = recipe.getRecipeCategory();
            if (!CATEGORIES_LIST.contains(category)) {
                CATEGORIES_LIST.add(category);
            }
        }
        return CATEGORIES_LIST;
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
        if (!RECIPES_LIST.contains(recipe)) {
            RECIPES_LIST.add(recipe);
        }
    }

    public void deleteRecipeFromList(String name) {
        for (Recipe recipe : RECIPES_LIST
        ) {
            if (recipe.getName().equals(name)) {
                RECIPES_LIST.remove(recipe);
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
}

