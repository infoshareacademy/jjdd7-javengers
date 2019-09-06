package com.infoshareacademy.dao;


import com.infoshareacademy.domain.RecipeWithJsonAnnotations;
import com.infoshareacademy.repository.RecipeRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class RecipeRepositoryDao {

    @PersistenceContext
    EntityManager entityManager;

//    public void loadRepository(List<RecipeWithJsonAnnotations> recipesList) {
//      RecipeRepository.getRecipesList().addAll(recipesList);
//  }
}
