package com.infoshareacademy;
import Parser.RecipeDTO;
import org.apache.commons.lang3.NotImplementedException;


import java.util.ArrayList;
import java.util.List;

public class FavouriteRecipeSearcher {

    List<RecipeDTO> favouritesRecipeList = new ArrayList<>();


    public List<RecipeDTO> addRecipeToFavourites(List<RecipeDTO> favouritesRecipeList, String name) {
        throw new NotImplementedException("Not implemented yet");
    }

    public List<RecipeDTO> deleteRecipeFromFavourites(List<RecipeDTO> favouritesRecipeList, String name) {
        throw new NotImplementedException("Not implemented yet");
    }

    public List<RecipeDTO> getFavouritesRecipeList() {
        return favouritesRecipeList;
    }
}
