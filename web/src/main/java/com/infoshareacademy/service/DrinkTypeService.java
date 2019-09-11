package com.infoshareacademy.service;

import com.infoshareacademy.dao.DrinkTypeDaoBean;
import com.infoshareacademy.domain.DrinkType;
import com.infoshareacademy.domain.api.RecipeApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class DrinkTypeService {
  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @Inject
  DrinkTypeDaoBean drinkTypeDaoBean;

  public void loadDrinkType(List<DrinkType> drinkTypes) {
    drinkTypeDaoBean.loadDrinkType(drinkTypes);
    logger.info("Recipe drink type list has been loaded");
  }

  public void addDrinkType(DrinkType drinkType) {
    drinkTypeDaoBean.addDrinkType(drinkType);
    logger.info("Recipe drink type has been saved");
  }

  public DrinkType getDrinkTypeByName(String name) {
    logger.info("Get recipe drink type by name");
    return drinkTypeDaoBean.getDrinkTypeByName(name);
  }

  public DrinkType getDrinkTypeById(Long id) {
    logger.info("Get recipe drink type by id");
    return drinkTypeDaoBean.getDrinkTypeById(id);
  }

  public void deleteDrinkTypeById(Long id) {
    drinkTypeDaoBean.deleteDrinkTypeById(id);
    logger.info("Category has been deleted");
  }

  public List<DrinkType> getDrinkTypeList() {
    logger.info("Get recipe categories list");
    return drinkTypeDaoBean.getDrinkTypeList();
  }
}
