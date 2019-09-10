package com.infoshareacademy.mapper;

import com.infoshareacademy.domain.Ingredient;
import com.infoshareacademy.domain.api.RecipeApi;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class IngredientMapper {


  public List<Ingredient> mapIngredients(RecipeApi recipeApi) {

    List<Ingredient> ingredients = new ArrayList<>();

    recipeApi.getIngredients().entrySet().forEach(i -> {
      Ingredient ingredient = new Ingredient();
      ingredient.setName(i.getKey());
      ingredient.setMeasure(i.getValue());
      ingredients.add(ingredient);
    });

    return ingredients;

//    List<Ingredient> ingredientList = new ArrayList<>();
//    Map<String, String> ingredientsMap = recipeApi.getIngredients();
//
//    for (Map.Entry<String, String> singleIngredient : ingredientsMap.entrySet()) {
//
//      String name = singleIngredient.getKey();
//      String measure = singleIngredient.getValue();
//      //Is there a problem like nullPointerException??
//      List<Ingredient> foundIngredient = ingredientDaoBean.findIngredientByNameAndMeasure(name, measure);
//
//      if (foundIngredient.isEmpty()) {
//        Ingredient ingredient = new Ingredient();
//        ingredient.setName(name);
//        ingredient.setRecipes(new ArrayList<>());
//        ingredient.getRecipes().add(recipeMapper.mapRecipes(recipeApi));
//        ingredientDaoBean.addIngredient(ingredient);
//        ingredientList.add(ingredient);
//      } else if (foundIngredient.size()==1){
//        Ingredient i = foundIngredient.get(0);
//        i.getRecipes().add(recipeMapper.mapRecipes(recipeApi));
//        ingredientDaoBean.editIngredient(i);
//        ingredientList.add(i);
//      }else {
//        //todo
//      }
    }
//    return ingredientList;
//  }
}
