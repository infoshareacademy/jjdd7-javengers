package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.Category;
import com.infoshareacademy.domain.entity.Ingredient;
import com.infoshareacademy.domain.entity.Recipe;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional
@Stateless
public class RecipeDaoBean {

    @PersistenceContext
    EntityManager entityManager;

    public void loadRecipe(List<Recipe> recipes) {
        for (Recipe recipe : recipes) {
            entityManager.persist(recipe);
        }
    }

    public void addRecipe(Recipe recipe) {
        entityManager.persist(recipe);
    }

    public Recipe editRecipe(Recipe recipe) {
        return entityManager.merge(recipe);
    }

    public Recipe getRecipeByName(String name) {
        return entityManager.find(Recipe.class, name);
    }

    @Transactional
    public Recipe getRecipeById(Long id) {
        return entityManager.find(Recipe.class, id);
    }

    public void deleteRecipeById(Long id) {
        Recipe recipe = getRecipeById(id);
        if (recipe != null) {
            entityManager.remove(recipe);
        }
    }

    public List<Recipe> getRecipiesList() {
        Query query = entityManager.createNamedQuery("Recipe.getRecipiesList");
        return query.getResultList();
    }

    public List<Recipe> findRecipeByCategoryId(List<Long> ids) {
        Query query = entityManager.createNamedQuery("Category.findCategoryById");
        query.setParameter("ids", ids);
        List<Category> categories = query.getResultList();

        Query recipeQuery = entityManager.createNamedQuery("Recipe.findRecipeByCategory");
        recipeQuery.setParameter("categories", categories);
        return recipeQuery.getResultList();
    }

    public List<String> findRecipeByIngredientId(List<String> names) {
        Query query = entityManager.createNamedQuery("Recipe.findRecipeByIngredientName");
        query.setParameter("names", names);
        return query.getResultList();
    }

    public List findRecipeByLiveSearch(String nameChars) {
        Query query = entityManager.createNamedQuery("Recipe.findRecipeByLiveSearch");
        query.setParameter("nameChars", "%" + nameChars + "%");
        return query.getResultList();
    }

    public List<String> getRecipeTypes() {
        Query query = entityManager.createNamedQuery("Recipe.getRecipeTypes");
        return query.getResultList();
    }

    public List<String> getRecipeTypeByName(List<String> types) {
        Query queryType = entityManager.createNamedQuery("Type.findTypeByName");
        queryType.setParameter("types", types);
        return queryType.getResultList();
    }

    public List<Recipe> findRecipeByCategoryIdAndIngredientAndType(List<Category> categories, List<Ingredient> ingredients, long namesLength, List<String> drinkTypes) {
        Query recipeQuery = entityManager.createNamedQuery("Recipe.findRecipeByCategoryIdAndIngredientNameAndType");
        recipeQuery.setParameter("categories", categories);
        recipeQuery.setParameter("ingredients", ingredients);
        recipeQuery.setParameter("namesLength", namesLength);
        recipeQuery.setParameter("drinkTypes", drinkTypes);
        return recipeQuery.getResultList();
    }


    public List<Recipe> findRecipeByCategoryIdAndType(List<Category> categories, List<String> drinkTypes) {
        Query recipeQuery = entityManager.createNamedQuery("Recipe.findRecipeByCategoryIdAndType");
        recipeQuery.setParameter("categories", categories);
        recipeQuery.setParameter("drinkTypes", drinkTypes);
        return recipeQuery.getResultList();
    }


    public List<Recipe> findFavouriteByCategoryIdAndIngredientAndType(List<Category> categories, List<Ingredient> ingredients, long namesLength, List<String> drinkTypes, Long userId) {
        Query recipeQuery = entityManager.createNamedQuery("Recipe.findRecipeByCategoryAndIngredientAndTypeAndFavourites");
        recipeQuery.setParameter("categories", categories);
        recipeQuery.setParameter("ingredients", ingredients);
        recipeQuery.setParameter("namesLength", namesLength);
        recipeQuery.setParameter("drinkTypes", drinkTypes);
        recipeQuery.setParameter("id", userId);
        return recipeQuery.getResultList();
    }

    public List<Recipe> findFavouriteRecipeByCategoryIdAndType(List<Category> categories, List<String> drinkTypes, Long userId) {
        Query recipeQuery = entityManager.createNamedQuery("Recipe.findRecipeByCategoryIdAndTypeAndFavourites");
        recipeQuery.setParameter("categories", categories);
        recipeQuery.setParameter("drinkTypes", drinkTypes);
        recipeQuery.setParameter("id", userId);
        return recipeQuery.getResultList();
    }


    @Transactional
    public List<Long> getFavouritesListIds(Long userId) {
        Query query = entityManager.createNamedQuery("Recipe.getFavouritesListIdsForUser");
        query.setParameter("id", userId);
        return query.getResultList();
    }

    public Recipe getFavouriteRecipeForUser(Long recipeId, Long userId) {
        Query query = entityManager.createNamedQuery("Recipe.getFavouriteRecipeForUser");
        query.setParameter("id", userId);
        query.setParameter("recipeId", recipeId);
        return (Recipe) query.getSingleResult();

    }

    public Long getMaxId() {
        Query query = entityManager.createNamedQuery("Recipe.getTheBiggestId");
        return (Long) query.getSingleResult();
    }

    public List<Recipe> getUnauthorizedRecipes(){
        Query query = entityManager.createNamedQuery("Recipe.getUnauthorizedRecipes");
        return query.getResultList();

    }

}