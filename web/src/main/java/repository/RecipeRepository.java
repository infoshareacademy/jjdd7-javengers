package repository;

import domain.Recipe;
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
        if (recipesList.size() ==0){
            fillRepositoryWithDefaultValues();
        }
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

    public static void fillRepositoryWithDefaultValues(){

        Recipe recipe1 = new Recipe();
        recipe1.setId(1);
        recipe1.setName("252");
        recipe1.setRecipeCategory("Shot");
        recipe1.setDrinkType("Alcoholic");
        recipesList.add(recipe1);

        Recipe recipe2 = new Recipe();
        recipe2.setId(2);
        recipe2.setName("Kir");
        recipe2.setRecipeCategory("Ordinary Drink");
        recipe2.setDrinkType("Optional alcohol");
        recipesList.add(recipe2);

    }
}