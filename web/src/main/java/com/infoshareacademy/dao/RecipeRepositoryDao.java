package com.infoshareacademy.dao;

import com.infoshareacademy.domain.Category;
import com.infoshareacademy.domain.Ingredient;
import com.infoshareacademy.domain.Recipe;
import com.infoshareacademy.mappers.DataParsedMapper;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RecipeRepositoryDao {

    @Inject
    DataParsedMapper dataParsedMapper;

    @PersistenceContext
    EntityManager entityManager;

    public void loadDataFromFile() {
        List<Recipe> recipeList = dataParsedMapper.mapToRecipesList();
        for (Recipe recipe : recipeList
        ) {
            entityManager.persist(recipe);
        }

        List<Category> categoryList = dataParsedMapper.mapCategoriesList();
        for (Category category : categoryList
        ) {
            entityManager.persist(category);
        }

        List<Ingredient> ingredientList = dataParsedMapper.mapIngredientList();
        for (Ingredient ingredient : ingredientList
        ) {
            entityManager.persist(ingredient);
        }
    }
}
