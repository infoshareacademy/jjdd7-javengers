package com.infoshareacademy;

import java.util.ArrayList;
import java.util.List;

public class FavouriteRecipeSearcher {

    List<RecipeDTO> favouritesRecipeList = new ArrayList<>();


    public List<RecipeDTO> addRecipeToFavourites(List<RecipeDTO> favouritesRecipeList, String name) {
        return null;
    }

    public List<RecipeDTO> deleteRecipeFromFavourites(List<RecipeDTO> favouritesRecipeList, String name) {
        return null;
    }

    public void setFavouritesRecipeList(List<RecipeDTO> favouritesRecipeList) {
        this.favouritesRecipeList = favouritesRecipeList;
    }

    public List<RecipeDTO> getFavouritesRecipeList() {
        return favouritesRecipeList;
    }

}
