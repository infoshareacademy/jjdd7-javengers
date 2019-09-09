package com.infoshareacademy.dao;

import com.infoshareacademy.domain.Ingredient;
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

  public Ingredient findIngredient(String name) {
    Query query = entityManager.createNamedQuery("SELECT FROM Ingredient i WHERE i.name=:name");
    query.setParameter("name", name);
    return (Ingredient) query.getSingleResult();
  }
}
