package com.infoshareacademy.dao;

import com.infoshareacademy.domain.Recipe;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class RecipeDaoBean {

  @PersistenceContext
  EntityManager entityManager;

  public void addRecipe(Recipe recipe) {
    entityManager.persist(recipe);
  }

  public Recipe editRecipe(Recipe recipe) {
    return entityManager.merge(recipe);
  }

  public Recipe getRecipeByName(String name) {
    return entityManager.find(Recipe.class, name);
  }

  public Recipe getRecipeById(Integer id) {
    return entityManager.find(Recipe.class, id);
  }

  public void deleteRecipeById(Integer id) {
    Recipe recipe = getRecipeById(id);
    if (recipe != null) {
      entityManager.remove(recipe);
    }
  }

  public List<Recipe> getRecipiesList() {
    Query query = entityManager.createQuery("SELECT r FROM Recipe r");
    return query.getResultList();

  }
}