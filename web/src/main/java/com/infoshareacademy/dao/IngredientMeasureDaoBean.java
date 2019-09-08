package com.infoshareacademy.dao;

import com.infoshareacademy.domain.IngredientMeasure;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class IngredientMeasureDaoBean {

  @PersistenceContext
  EntityManager entityManager;

  public void loadIngredientMeasure(List<IngredientMeasure> measures) {
    for (IngredientMeasure ingredientMeasure : measures
    ) {
      entityManager.persist(ingredientMeasure);
    }
  }

}
