package com.infoshareacademy.mapper;

import com.infoshareacademy.dao.IngredientDaoBean;
import com.infoshareacademy.domain.Ingredient;
import com.infoshareacademy.domain.api.RecipeApi;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class IngredientMapper {

  @EJB
  private IngredientDaoBean ingredientDaoBean;

  @EJB
  private RecipeMapper recipeMapper;

  public List<Ingredient> mapIngredients(RecipeApi recipeApi) {

    List<Ingredient> ingredientList = new ArrayList<>();
    Map<String, String> ingredientsMap = recipeApi.getIngredients();

    for (Map.Entry<String, String> singleIngredient : ingredientsMap.entrySet()) {

      String name = singleIngredient.getKey();
      String measure = singleIngredient.getValue();
      Ingredient foundIngredient = ingredientDaoBean.findIngredient(name, measure);

      if (foundIngredient == null) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(name);
        ingredient.setRecipes(new ArrayList<>());
        ingredient.getRecipes().add(recipeMapper.mapRecipes(recipeApi));
        ingredientDaoBean.addIngredient(ingredient);
        ingredientList.add(ingredient);
      } else {
        foundIngredient.getRecipes().add(recipeMapper.mapRecipes(recipeApi));
        ingredientDaoBean.editIngredient(foundIngredient);
        ingredientList.add(foundIngredient);
      }
    }
    return ingredientList;
  }
}
