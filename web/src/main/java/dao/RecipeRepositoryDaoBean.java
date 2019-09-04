package dao;

import domain.Recipe;
import java.util.List;
import javax.ejb.Stateless;
import repository.RecipeRepository;

@Stateless
public class RecipeRepositoryDaoBean {

  public List<Recipe> loadRecipiesList() {
    return RecipeRepository.getRecipesList();
  }

  public List<Recipe> loadFavouritesRecipeList() {
    return RecipeRepository.getFavouritesRecipeList();
  }

  public List<String> loadIngredientsList() {
    return RecipeRepository.getIngredientsList();
  }

  public List<String> loadCategoriesList() {
    return RecipeRepository.getCategoriesList();
  }

  public Recipe getRecipeByName(String name) {
    return RecipeRepository.getRecipesList().stream()
        .filter(r -> r.getName() == name).findFirst().get();
  }

  public Recipe getRecipeById(Integer id) {
    return RecipeRepository.getRecipesList().stream()
        .filter(u -> u.getId() == id).findFirst().get();
  }

}
