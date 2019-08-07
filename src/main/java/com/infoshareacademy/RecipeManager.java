package com.infoshareacademy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RecipeManager {

    List<RecipeDTO> recipesList;
    List<String> categoriesList;


    public String printAllNamesFromRecipe(List<RecipeDTO> recipesList, String name) {
        return null;
    }


    public List<RecipeDTO> findRecipeByName(List<RecipeDTO> recipesList, String name) {

        return null;
    }


    public List<RecipeDTO> findRecipeByIngredients(List<RecipeDTO> recipesList, String ingredientName) {

        return null;
    }

    public List<RecipeDTO> findRecipeByCategory(List<RecipeDTO> recipesList, String recipeCategory) {

        return null;
    }

    public List<RecipeDTO> addRecipeToList(List<RecipeDTO> recipesList, String name) {
        return null;
    }

    public List<RecipeDTO> deleteRecipeFromList(List<RecipeDTO> recipesList, String name) {
        return null;
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
