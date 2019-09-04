package service;

import dao.RecipeRepositoryDaoBean;
import domain.Recipe;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class RecipeService {

  @EJB
  RecipeRepositoryDaoBean recipeRepositoryDaoBean;

  public Recipe findRecipeById(Integer id) {
    return recipeRepositoryDaoBean.getRecipeById(id);
  }

}
