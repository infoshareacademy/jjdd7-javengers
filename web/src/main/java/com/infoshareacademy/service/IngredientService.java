package com.infoshareacademy.service;

import com.infoshareacademy.dao.IngredientDaoBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class IngredientService {

  @EJB
  private IngredientDaoBean ingredientDaoBean;

}
