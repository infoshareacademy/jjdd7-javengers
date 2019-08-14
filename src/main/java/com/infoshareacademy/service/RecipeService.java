package com.infoshareacademy.service;

import com.infoshareacademy.DrinksDefaultApiArray;
import com.infoshareacademy.Parser;
import com.infoshareacademy.domain.Recipe;
import com.infoshareacademy.domain.RecipeRepository;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;
import java.util.Set;

public class RecipeService {

    RecipeRepository recipeRepository = new RecipeRepository();
    private List<Recipe> recipesList = recipeRepository.getRecipesList();
    private Set<String> categoriesList = recipeRepository.getCategoriesList();

    public List<Recipe> createRecipesList() {
        Parser parser = new Parser();
        recipesList = ((DrinksDefaultApiArray) parser.parseFile("drinks.json", DrinksDefaultApiArray.class)).getDrinks();
        return recipesList;
    }

    public Set<String> createCategoriesList(List<Recipe> recipesList) {
        for (Recipe recipe : recipesList) {
            categoriesList.add(recipe.getRecipeCategory());
        }
        return categoriesList;
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

    public List<Recipe> addRecipeToList(List<Recipe> recipesList, Recipe recipe) {
        throw new NotImplementedException("Not implemented yet");
    }

    public List<Recipe> deleteRecipeFromList(List<Recipe> recipesList, String name) {
        throw new NotImplementedException("Not implemented yet");
    }
}
