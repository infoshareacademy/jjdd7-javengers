package com.infoshareacademy.service;

import com.infoshareacademy.dao.IngredientMeasureDaoBean;
import com.infoshareacademy.mapper.IngredientMeasureMapper;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class IngredientMeasureService {

  @EJB
  private IngredientMeasureDaoBean ingredientMeasureDaoBean;

}
