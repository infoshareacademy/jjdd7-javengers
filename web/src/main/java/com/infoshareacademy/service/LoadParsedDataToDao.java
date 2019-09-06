package com.infoshareacademy.service;

import com.infoshareacademy.dao.RecipeRepositoryDao;
import com.infoshareacademy.domain.RecipeWithJsonAnnotations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class LoadParsedDataToDao {

  @Inject
  private RecipeRepositoryDao recipeRepositoryDao;

//  public void loadParsedData(List<RecipeWithJsonAnnotations> recipeWithJsonAnnotationsList){
//    recipeRepositoryDao.loadRepository(recipeWithJsonAnnotationsList);
//  }
}
