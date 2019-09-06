package service;

import dao.RecipeRepositoryDaoBean;
import domain.Recipe;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class RecipeService {

    @EJB
    RecipeRepositoryDaoBean recipeRepositoryDaoBean;

    public Recipe findRecipeById(Integer id) {
        return recipeRepositoryDaoBean.getRecipeById(id);
    }

    public List<Recipe> getAllRecipies() {
        return recipeRepositoryDaoBean.loadRecipesList();
    }

    public List<Recipe> getAllFavouritesRecipies() {
        return recipeRepositoryDaoBean.loadFavouritesRecipeList();
    }

  public List<String> getAllIingredients (){
      return recipeRepositoryDaoBean.loadIngredientsList();
  }
  public List<String> getAllCategories(){
      return recipeRepositoryDaoBean.loadCategoriesList();
  }
}
