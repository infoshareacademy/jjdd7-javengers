package com.infoshareacademy.service;

import com.infoshareacademy.dao.CategoryDaoBean;
import com.infoshareacademy.dao.FavouritesDaoBean;
import com.infoshareacademy.dao.IngredientDaoBean;
import com.infoshareacademy.domain.entity.Category;
import com.infoshareacademy.domain.entity.Ingredient;
import com.infoshareacademy.domain.entity.Recipe;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class FilteringService {

    @Inject
    private CategoryDaoBean categoryDaoBean;
    @Inject
   private IngredientDaoBean ingredientDaoBean;
    @Inject
    private FavouritesDaoBean favouritesDaoBean;

    public void getFiltersQuery(List<Long> ids, List<String> names, Long favouriteId List <String> type){
        List<Category> categories = categoryDaoBean.getCategoriesById(ids);
        List<Ingredient> ingredients = ingredientDaoBean.getIngredientsListByName( names);
        long namesLength = (names).size();
        List <Recipe> favourites = favouritesDaoBean.getFavouritesList(favouriteId);

    }
}
