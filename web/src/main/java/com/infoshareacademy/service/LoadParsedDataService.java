package com.infoshareacademy.service;

import com.infoshareacademy.dao.RecipeRepositoryDao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class LoadParsedDataService {

  @Inject
  private RecipeRepositoryDao recipeRepositoryDao;

  public void loadParsedData(){
    recipeRepositoryDao.loadDataFromFile();
  }
}
