package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.Ingredient;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class IngredientDaoBean {

  @PersistenceContext
  EntityManager entityManager;

  public void loadIngredient(List<Ingredient> ingredients) {
    for (Ingredient ingredient : ingredients
    ) {
      entityManager.persist(ingredient);
    }
  }

  public void addIngredient(Ingredient ingredient) {
    entityManager.persist(ingredient);
  }

  public Ingredient editIngredient(Ingredient ingredient) {
    return entityManager.merge(ingredient);
  }

  public Ingredient getIngredientByName(String name) {
    return entityManager.find(Ingredient.class, name);
  }

  public Ingredient getIngredientById(Long id) {
    return entityManager.find(Ingredient.class, id);
  }

  public void deleteCategoryById(Long id) {
    Ingredient ingredient = getIngredientById(id);
    if (ingredient != null) {
      entityManager.remove(ingredient);
    }
  }

  public Ingredient findIngredient(String name) {
    Query query = entityManager.createNamedQuery("Ingredient.findIngredientByName");
    query.setParameter("name", name);
    return (Ingredient) query.getSingleResult();
  }

  public List<String> findIngredientsByLiveSearch(String nameChars) {
    Query query = entityManager.createNamedQuery("Ingredient.findIngredientByLiveSearch");
    query.setParameter("nameChars", "%" + nameChars + "%");
      return query.getResultList();
  }
}
