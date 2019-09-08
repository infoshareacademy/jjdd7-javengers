package com.infoshareacademy.dao;

import com.infoshareacademy.domain.Recipe;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RecipeDaoBean {

  @PersistenceContext
  EntityManager entityManager;

  public void loadRecipe(List<Recipe> recipes) {
    for (Recipe recipe : recipes
    ) {
      entityManager.persist(recipe);
    }
  }


}
