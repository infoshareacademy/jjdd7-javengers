package com.infoshareacademy.dao;

import com.infoshareacademy.domain.Ingredient;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
