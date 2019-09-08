package com.infoshareacademy.dao;

import com.infoshareacademy.domain.DrinkType;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DrinkTypeDaoBean {

  @PersistenceContext
  EntityManager entityManager;

  public void loadDrinkType(List<DrinkType> drinkTypes) {
    for (DrinkType drinkType : drinkTypes
    ) {
      entityManager.persist(drinkType);
    }
  }
}
