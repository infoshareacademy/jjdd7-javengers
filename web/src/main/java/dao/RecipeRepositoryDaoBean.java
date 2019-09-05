package dao;

import domain.Recipe;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import repository.RecipeRepository;

@Stateless
public class RecipeRepositoryDaoBean {

/*  @PersistenceContext
  EntityManager entityManager;

  public void addRecipe(Recipe recipe) {
    entityManager.persist(recipe);
  }

  public Recipe editUser(Recipe recipe) {
    return entityManager.merge(recipe);
  }

  public Recipe getRecipeByName(String name) {
   return entityManager.find(Recipe.class,name);
  }

  public Recipe getRecipeById(Integer id) {
   return entityManager.find(Recipe.class,id);
  }

  public List<Recipe> getRecipiesList() {
    Query query = entityManager.createQuery("SELECT r FROM Recipe r");
    return query.getResultList();

  }


  public void deleteUserById(Integer id) {
    Recipe recipe = getRecipeById(id);
    if (recipe != null) {
      entityManager.remove(recipe);
    }
  }*/

  public Recipe getRecipeByName(String name) {
    return RecipeRepository.getRecipesList().stream()
            .filter(r -> r.getName() == name).findFirst().get();
  }

  public Recipe getRecipeById(Integer id) {
    return RecipeRepository.getRecipesList().stream()
            .filter(u -> u.getId() == id).findFirst().get();
  }
  public List<Recipe> loadRecipesList() {
    return RecipeRepository.getFavouritesRecipeList();
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


}
