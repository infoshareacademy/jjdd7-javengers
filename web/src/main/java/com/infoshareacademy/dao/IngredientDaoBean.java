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

  public void addIngredient(Ingredient ingredient) {
    entityManager.persist(ingredient);
  }

  public Ingredient editIngredient(Ingredient ingredient) {
    return entityManager.merge(ingredient);
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

  public List<Ingredient> findIngredientByNameAndMeasure(String name, String measure) {
    Query query = entityManager.createNamedQuery("Ingredient.findIngredientByNameAndMeasure");
    query.setParameter("name", name);
    query.setParameter("measure",measure);
    return query.getResultList();
  }
}
