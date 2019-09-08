package com.infoshareacademy.service;

import com.infoshareacademy.dao.RecipeDaoBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class RecipeService {

  @EJB
  private RecipeDaoBean recipeDaoBean;

}
