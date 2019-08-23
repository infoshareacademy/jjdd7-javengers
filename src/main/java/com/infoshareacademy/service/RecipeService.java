package com.infoshareacademy.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.infoshareacademy.domain.Recipe;
import com.infoshareacademy.domain.RecipeRepository;
import org.apache.commons.lang3.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RecipeService {

    public void loadRecipesList() {
        if (RecipeRepository.getRecipesList().isEmpty()) {
            RecipeRepository.getRecipesList().addAll((List<Recipe>) DataParseService.parseFile("drinks.json",
                    new TypeReference<List<Recipe>>() {
                    }, "drinks"));
            RecipeRepository.getRecipesList().sort(Comparator.comparing(Recipe::getName));
        }
    }

    public void loadFavouritesList() {
        if (RecipeRepository.getFavouritesRecipeList().isEmpty()) {
            RecipeRepository.getFavouritesRecipeList().addAll((List<Recipe>) DataParseService.parseFile("favourites.json",
                    new TypeReference<List<Recipe>>() {
                    }, "drinks"));
        }
    }

    public void loadCategoriesList() {
        RecipeRepository.getCategoriesList().clear();
        for (Recipe recipe : RecipeRepository.getRecipesList()
        ) {
            String category = recipe.getRecipeCategory();
            if (!RecipeRepository.getCategoriesList().contains(category)) {
                RecipeRepository.getCategoriesList().add(category);
            }
        }
    }

    public void loadIngredientsList() {
        RecipeRepository.getIngredientsList().clear();
        List<String> tempList = new ArrayList<>();
        for (Recipe recipe : RecipeRepository.getRecipesList()) {
            tempList.addAll(recipe.getIngredients().keySet());
            }
        RecipeRepository.getIngredientsList()
                .addAll(tempList.stream()
                        .map(String::toLowerCase)
                        .distinct()
                        .sorted()
                        .collect(Collectors.toList()));
    }



    public List<Recipe> findRecipeByName(List<Recipe> recipesList, List<String> userChoiceArrayList) {
        List<Recipe> outputList = new ArrayList<>();

        for (String userSingleChoice: userChoiceArrayList) {
            outputList.addAll(recipesList.stream()
                    .filter(r -> r.getName().toLowerCase().trim().equals(userSingleChoice.toLowerCase().trim()))
                    .collect(Collectors.toList()));
        }
        return outputList.stream().distinct().collect(Collectors.toList());

    }

    public List<Recipe> findRecipeByIngredients(List<Recipe> recipesList, List<String> userChoiceArrayList) {

        List<Recipe> outputList = new ArrayList<>();
        /*List<String> userChoyceArrayListToLower = new ArrayList<>();
        for(Recipe recipe : recipesList){
            for (String s : recipe.getIngredients().keySet()) {
                String s1 = s.trim().toLowerCase();
            }
            //System.out.println(recipe.getIngredients().keySet());
        }*/


        //userChoiceArrayList.add("milk");

        //for (String userSingleChoice: userChoiceArrayList) {
        outputList = (recipesList.stream()
                .filter(r ->
                        (userChoiceArrayList.stream()
                                .allMatch(
                                        ingredient ->
                                                (r.getIngredients()
                                                        .keySet()).toString().toLowerCase().contains(ingredient.trim())))))
                .collect(Collectors.toList());

        for (Recipe recipe : outputList) {
            System.out.println(recipe.getIngredients().keySet());

        }
            return outputList.stream().distinct().collect(Collectors.toList());
    }







    public List<Recipe> findRecipeByCategory(List<Recipe> recipesList, List<String> userChoiceArrayList) {
        List<Recipe> outputList = new ArrayList<>();

        for (String userSingleChoice: userChoiceArrayList) {
            outputList.addAll(recipesList.stream()
                    .filter(r -> r.getRecipeCategory().toLowerCase().trim().equals(userSingleChoice.toLowerCase().trim()))
                    .collect(Collectors.toList()));
        }
        return outputList.stream().distinct().collect(Collectors.toList());

    }

    public void addRecipeToList(Recipe recipe) {
        throw new NotImplementedException("Not implemented yet");
    }

    public void deleteRecipeFromList(String name) {
        throw new NotImplementedException("Not implemented yet");
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