package com.infoshareacademy;

import org.apache.commons.lang3.NotImplementedException;

import java.util.List;


public class RecipeManager {

    List<RecipeDTO> recipesList;
    List<String> categoriesList;


    public void printAllNamesFromRecipe(List<RecipeDTO> recipesList, String name) {

        throw new NotImplementedException("Not implemented yet");    }


    public List<RecipeDTO> findRecipeByName(List<RecipeDTO> recipesList, String name) {
        throw new NotImplementedException("Not implemented yet");
    }

    public List<RecipeDTO> findRecipeByIngredients(List<RecipeDTO> recipesList, String ingredientName) {
        throw new NotImplementedException("This is method not implemented yet");
    }

    public List<RecipeDTO> findRecipeByCategory(List<RecipeDTO> recipesList, String recipeCategory) {
        throw new NotImplementedException("This is method not implemented yet");
    }


    public List<RecipeDTO> addRecipeToList(List<RecipeDTO> recipesList, String name) {
        throw new NotImplementedException("This is method not implemented yet");
    }


    public List<RecipeDTO> deleteRecipeFromList(List<RecipeDTO> recipesList, String name) {
        throw new NotImplementedException("This is method not implemented yet");
    }


    public void setRecipesList(List<RecipeDTO> recipesList) {
        this.recipesList = recipesList;
    }

    public void setCategoriesList(List<String> categoriesList) {
        this.categoriesList = categoriesList;
    }


    public List<RecipeDTO> getRecipesList() {
        return recipesList;
    }

    public List<String> getCategoriesList() {
        return categoriesList;
    }

}
