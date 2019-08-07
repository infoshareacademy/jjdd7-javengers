package com.infoshareacademy;

import java.util.ArrayList;
import java.util.List;

public class RecipeSearcher {

    List<RecipeDTO> recipesList;
    List<String> categoriesList;



    public List<RecipeDTO> findRecipeByName() {

        return null;
    }

    public List<RecipeDTO> findRecipeByIngredients() {

        return null;
    }

    public String findRecipeByCategory(List categoriesList) {

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


    public List<RecipeDTO> addRecipeToList (){
        return null;
    }

    public List<RecipeDTO> deleteRecipeFromList(){
        return null;
    }


}
