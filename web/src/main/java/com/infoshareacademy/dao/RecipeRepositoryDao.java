package com.infoshareacademy.dao;

import com.infoshareacademy.domain.Category;
import com.infoshareacademy.domain.Ingredient;
import com.infoshareacademy.domain.Recipe;
import com.infoshareacademy.mappers.DataParsedMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class RecipeRepositoryDao {

    @Inject
    DataParsedMapper dataParsedMapper;

    @PersistenceContext
    EntityManager entityManager;

    public void loadRecipes(List<Recipe> recipesList) {

    }

    public void loadIngredients(List<Ingredient> ingredientListList) {

    }

    public void loadCategories(List<Category> categoriesList) {

    }
}
