package com.infoshareacademy;

import org.apache.commons.lang3.NotImplementedException;

import java.util.HashSet;
import java.util.List;
import java.util.List;
import java.util.Set;


public class RecipeManager {

    private List<RecipeDTO> recipesList;
    private HashSet<String> categoriesList = new HashSet<>();
    private Parser parser = new Parser();

    public List<RecipeDTO>  createRecipesList(){
        recipesList = ((DrinksDefaultApiArray) parser.parseFile("drinks.json", DrinksDefaultApiArray.class)).getDrinks();
        return recipesList;
    }

    public HashSet<String> createCategoriesList(List<RecipeDTO> recipesList){
        for (RecipeDTO recipe:recipesList
             ) {
            categoriesList.add(recipe.getRecipeCategory());
        }
        return categoriesList;
    }

    public List<RecipeDTO> findRecipeByName(List<RecipeDTO> recipesList, String name) {
        throw new NotImplementedException( "Not implemented yet" );
    }

    public List<RecipeDTO> findRecipeByIngredients(List<RecipeDTO> recipesList, String ingredientName) {
        throw new NotImplementedException( "Not implemented yet" );
    }

    public List<RecipeDTO> findRecipeByCategory(List<RecipeDTO> recipesList, String recipeCategory) {
        throw new NotImplementedException( "Not implemented yet" );
    }


    public List<RecipeDTO> addRecipeToList(List<RecipeDTO> recipesList, RecipeDTO recipeDTO) {
        throw new NotImplementedException( "Not implemented yet" );
    }


    public List<RecipeDTO> deleteRecipeFromList(List<RecipeDTO> recipesList, String name) {
        throw new NotImplementedException( "Not implemented yet" );
    }


    public void setRecipesList(List<RecipeDTO> recipesList) {
        this.recipesList = recipesList;
    }

    public void setCategoriesList(HashSet<String> categoriesList) {
        this.categoriesList = categoriesList;
    }


    public List<RecipeDTO> getRecipesList() {
        return recipesList;
    }

    public HashSet<String> getCategoriesList() {
        return categoriesList;
    }

}
