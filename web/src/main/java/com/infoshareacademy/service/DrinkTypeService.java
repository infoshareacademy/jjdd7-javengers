package com.infoshareacademy.service;

import com.infoshareacademy.dao.DrinkTypeDaoBean;
import com.infoshareacademy.domain.DrinkType;
import com.infoshareacademy.domain.api.RecipeApi;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class DrinkTypeService {

  @Inject
  DrinkTypeDaoBean drinkTypeDaoBean;

  public void loadDrinkType(List<DrinkType> drinkTypes) {
    drinkTypeDaoBean.loadDrinkType(drinkTypes);
  }

  public void addDrinkType(DrinkType drinkType) {
    drinkTypeDaoBean.addDrinkType(drinkType);
  }

  public DrinkType getDrinkTypeByName(String name) {
    return drinkTypeDaoBean.getDrinkTypeByName(name);
  }

  public DrinkType getDrinkTypeById(Long id) {
    return drinkTypeDaoBean.getDrinkTypeById(id);
  }

  public void deleteDrinkTypeById(Long id) {
    drinkTypeDaoBean.deleteDrinkTypeById(id);
  }

  public List<DrinkType> getDrinkTypeList() {
    return drinkTypeDaoBean.getDrinkTypeList();
  }
}
