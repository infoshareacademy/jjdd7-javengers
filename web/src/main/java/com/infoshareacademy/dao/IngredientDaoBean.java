package com.infoshareacademy.dao;

import com.infoshareacademy.domain.Ingredient;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

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

  public Ingredient findIngredient(String name, String measure) {
    Query query = entityManager.createNamedQuery("SELECT FROM Ingredient i WHERE i.name=:name and i.measure=;measure");
    query.setParameter("name", name);
    query.setParameter("measure",measure);
    return (Ingredient) query.getSingleResult();
  }


}
