package repository;

import com.infoshareacademy.domain.Recipe;
import java.util.ArrayList;
import java.util.List;

public class RecipeRepository {
    private static List<Recipe> recipesList = new ArrayList<>();
    private static List<String> categoriesList = new ArrayList<>();
    private static List<String> ingredientsList = new ArrayList<>();
    private static List<Recipe> favouritesRecipeList = new ArrayList<>();

    private RecipeRepository() {
    }

    public static List<Recipe> getRecipesList() {
        return recipesList;
    }

    public static List<String> getCategoriesList() {
        return categoriesList;
    }

    public static List<String> getIngredientsList() {
        return ingredientsList;
    }

    public static List<Recipe> getFavouritesRecipeList() {
        return favouritesRecipeList;
    }
}