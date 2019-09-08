package com.infoshareacademy.service;

import com.infoshareacademy.dao.DrinkTypeDaoBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class DrinkTypeService {

  @EJB
  private DrinkTypeDaoBean drinkTypeDaoBean;

}
