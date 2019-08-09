package com.infoshareacademy;

import org.apache.commons.lang3.NotImplementedException;


import java.util.ArrayList;
import java.util.List;

public class FavouriteRecipeSearcher {

    List<RecipeDTO> favouritesRecipeList = new ArrayList<>();

    public FavouriteRecipeSearcher(List<RecipeDTO> favouritesRecipeList) {
        this.favouritesRecipeList = favouritesRecipeList;
    }

    public List<RecipeDTO> addRecipeToFavourites(List<RecipeDTO> favouritesRecipeList, String name) {
        throw new NotImplementedException("This is method not implemented yet");
    }

    public List<RecipeDTO> deleteRecipeFromFavourites(List<RecipeDTO> favouritesRecipeList, String name) {
        throw new NotImplementedException("This is method not implemented yet");
    }

    public List<RecipeDTO> getFavouritesRecipeList() {
        return favouritesRecipeList;
    }
}
