package com.infoshareacademy.domain;

import com.infoshareacademy.domain.Recipe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecipeRepository {
    private List<Recipe> recipesList;
    private Set<String> categoriesList = new HashSet<>();
    private List<Recipe> favouritesRecipeList = new ArrayList<>();

    public List<Recipe> getRecipesList() {
        return recipesList;
    }

    public void setRecipesList(List<Recipe> recipesList) {
        this.recipesList = recipesList;
    }

    public Set<String> getCategoriesList() {
        return categoriesList;
    }

    public void setCategoriesList(Set<String> categoriesList) {
        this.categoriesList = categoriesList;
    }

    public List<Recipe> getFavouritesRecipeList() {
        return favouritesRecipeList;
    }

    public void setFavouritesRecipeList(List<Recipe> favouritesRecipeList) {
        this.favouritesRecipeList = favouritesRecipeList;
    }
}
