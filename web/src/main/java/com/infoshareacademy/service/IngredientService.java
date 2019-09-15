package com.infoshareacademy.service;

import com.infoshareacademy.dao.IngredientDaoBean;
import com.infoshareacademy.domain.entity.Ingredient;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class IngredientService {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @EJB
  private IngredientDaoBean ingredientDaoBean;

  public void loadIngredient(List<Ingredient> ingredients) {
    ingredientDaoBean.loadIngredient(ingredients);
  }

  public void addIngredient(Ingredient ingredient) {
    ingredientDaoBean.addIngredient(ingredient);
  }

  public Ingredient editIngredient(Ingredient ingredient) {
    return ingredientDaoBean.editIngredient(ingredient);
  }

  public Ingredient getIngredientByName(String name) {
    return ingredientDaoBean.getIngredientByName(name);
  }

  public Ingredient getIngredientById(Long id) {
    return ingredientDaoBean.getIngredientById(id);
  }

  public void deleteCategoryById(Long id) {
    ingredientDaoBean.deleteCategoryById(id);
  }

  public Ingredient findIngredient(String name) {
    return ingredientDaoBean.findIngredient(name);
  }

  public List<String> findIngredientsForLiveSearch(String nameChars) {
    logger.info("ingredients with name contains " + nameChars +" found in database");
    return ingredientDaoBean.findIngredientsByLiveSearch(nameChars);
  }
}
