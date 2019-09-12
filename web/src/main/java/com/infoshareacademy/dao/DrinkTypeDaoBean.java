package com.infoshareacademy.dao;

import com.infoshareacademy.domain.type.DrinkType;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
  public void addDrinkType(DrinkType drinkType) {
    entityManager.persist(drinkType);
  }

  public DrinkType getDrinkTypeByName(String name) {
    return entityManager.find(DrinkType.class, name);
  }

  public DrinkType getDrinkTypeById(Long id) {
    return entityManager.find(DrinkType.class, id);
  }

  public void deleteDrinkTypeById(Long id) {
    DrinkType drinkType = getDrinkTypeById(id);
    if (drinkType != null) {
      entityManager.remove(drinkType);
    }
  }
  public List<DrinkType> getDrinkTypeList() {
    Query query = entityManager.createQuery("SELECT dt FROM DrinkType dt");
    return query.getResultList();

  }

}
