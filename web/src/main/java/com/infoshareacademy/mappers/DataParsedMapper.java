package com.infoshareacademy.mappers;

import com.infoshareacademy.domain.Category;
import com.infoshareacademy.domain.Ingredient;
import com.infoshareacademy.domain.Recipe;
import com.infoshareacademy.domain.RecipeForParser;
import com.infoshareacademy.service.ParserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class DataParsedMapper {

    @Inject
    ParserService parserService;

    private List<RecipeForParser> recipesList =
            (List<RecipeForParser>) parserService.parseFile();

    public List<Recipe> mapToRecipesList(){
        Recipe recipe = new Recipe();
        Ingredient ingredient = new Ingredient();
        Category category = new Category();
        List<Recipe> recipesEntity = new ArrayList<>();

        for (RecipeForParser recipes : recipesList
             ) {
            recipe.setName(recipes.getName());
            recipe.setModificationDate(recipes.getModificationDate());
//            recipe.setDrinkType(recipes.getDrinkType()); TODO
            recipe.setGlassType(recipes.getGlassType());
            recipe.setInstruction(recipes.getInstruction());

            List<Ingredient> ingredientsList = new ArrayList<>();

            Map<String, String> ingredients = recipes.getIngredients();
            for (Map.Entry<String, String> entry : ingredients.entrySet()) {
                ingredient.setName(entry.getKey());
//                ingredient.setMeasure(entry.getValue()); TODO
                ingredientsList.add(ingredient);
            }

            recipe.setIngredients(ingredientsList);
            recipesEntity.add(recipe);

            category.setName(recipes.getRecipeCategory());
            recipe.setCategory(category);
        }
        return recipesEntity;
    }

    public List<Ingredient> mapIngredientList() { //TODO
        Ingredient ingredient = new Ingredient();
        List<Ingredient> ingredientsEntity = new ArrayList<>();
        List<Recipe> recipesWithTheseIngredient = new ArrayList<>();

        for (RecipeForParser recipes : recipesList
        ) {
            Map<String, String> ingredients = recipes.getIngredients();

            for (Map.Entry<String, String> entry : ingredients.entrySet()) {

                ingredient.setName(entry.getKey());
//                ingredient.setMeasure(entry.getValue()); TODO
            }

//            List<Recipe>recipesList = mapToRecipesList();
//            for (Recipe recipe : recipesList
//            ) {
//                if (recipes.getName().equals(recipe.getName())){
//
//                }
//            }

        }
        return ingredientsEntity;
    }

    public List<Category> mapCategoriesList() { //TODO będę wdzięczna za pomoc:)
        Category category = new Category();
        List<Category> categoriesEntity = new ArrayList<>();
        for (RecipeForParser recipe : recipesList
        ) {

            category.setName(recipe.getRecipeCategory());

        }
        return categoriesEntity;
    }
}
