//package com.infoshareacademy.mapper;
//
//import com.infoshareacademy.domain.Category;
//import com.infoshareacademy.domain.api.RecipeApi;
//import org.junit.jupiter.api.Test;
//
//import java.util.*;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class CategoryMapperTest {
//
//    private CategoryMapper sut = new CategoryMapper();
//
//    @Test
//    void shouldReturnEmptyCategoriesForEmptyRecipes() {
//        List<RecipeApi> recipes = new ArrayList<>();
//
//        List<Category> entityRecipes = sut.mapCategories(recipes);
//
//        assertTrue(entityRecipes.isEmpty());
//    }
//
//    @Test
//    void shouldReturnValidCategoriesForRecipes() {
//        RecipeApi recipeApi = new RecipeApi();
//        recipeApi.setId(1);
//        recipeApi.setDrinkType("alcoholic");
//        recipeApi.setGlassType("glass");
//        recipeApi.setRecipeCategory("shot");
//        recipeApi.setInstruction("do it something");
//        Map<String,String> ingredients = new HashMap<>();
//        ingredients.put("vodka","22l");
//        ingredients.put("gin","1111111oz");
//        recipeApi.setIngredients(ingredients);
//        recipeApi.setModificationDate("2000-01-01 09:01:01");
//        List<RecipeApi> recipes = new ArrayList<>();
//        recipes.add(recipeApi);
//
//        Category c1 = new Category();
//        c1.setId(0L);
//        c1.setName("shot");
//        c1.setRecipes();
//        List<Category> categories = new ArrayList<>();
//
//
//        List<Category> entityRecipes = sut.mapCategories(recipes);
//
//        assertTrue(entityRecipes.isEmpty());
//    }
//}