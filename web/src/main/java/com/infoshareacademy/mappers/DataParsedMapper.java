package com.infoshareacademy.mappers;

import com.infoshareacademy.domain.Category;
import com.infoshareacademy.domain.Ingredient;
import com.infoshareacademy.domain.Recipe;
import com.infoshareacademy.domain.RecipeForParser;
import com.infoshareacademy.service.ParserService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class DataParsedMapper {

    @Inject
    ParserService parserService;

    private List<RecipeForParser> recipes =
            (List<RecipeForParser>) parserService.parseFile();

    public List<Recipe> mapToRecipesList(){
        Recipe recipe = new Recipe();
        List<Recipe>recipesList = new ArrayList<>();
        for (RecipeForParser recipes:recipes
             ) {
            recipe.setName(recipes.getName());
            recipe.setModificationDate(recipes.getModificationDate());
            recipe.setDrinkType(recipes.getDrinkType());
            recipe.setGlassType(recipes.getGlassType());
            recipe.setInstruction(recipes.getInstruction());
            recipesList.add(recipe);
        }
        return recipesList;
    }

//    public List<Ingredient> mapIngredientList(){
//
//        for (RecipeForParser recipe:recipes
//        ) {
//
//        }
//
//    }
//
//    public List<Category> mapCategoriesList(){
//        for (RecipeForParser recipe:recipes
//        ) {
//
//        }
//
//    }
}
