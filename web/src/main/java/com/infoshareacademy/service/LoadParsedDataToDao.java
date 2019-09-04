package com.infoshareacademy.service;

import com.infoshareacademy.dao.RecipeRepositoryDao;
import com.infoshareacademy.domain.Recipe;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class LoadParsedDataToDao {

  @Inject
  private RecipeRepositoryDao recipeRepositoryDao;

  public void loadParsedData(List<Recipe>recipeList){
    recipeRepositoryDao.loadRepository(recipeList);
  }
}
