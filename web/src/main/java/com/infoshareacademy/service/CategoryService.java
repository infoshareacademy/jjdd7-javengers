package com.infoshareacademy.service;

import com.infoshareacademy.dao.CategoryDaoBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class CategoryService {

  @EJB
  private CategoryDaoBean categoryDaoBean;

}
