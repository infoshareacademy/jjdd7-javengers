package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.Recipe;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class FavouritesDaoBean {
    @PersistenceContext
    EntityManager entityManager;
    public List<Recipe> getFavouritesList(Long favouriteId) {

        List<Long> favouritesRecipeList = new ArrayList<>();
        if (favouritesRecipeList.contains(favouriteId)) {
            favouritesRecipeList.remove(favouriteId);
        } else {
            favouritesRecipeList.add(favouriteId);
        }
        Query queryFavourites = entityManager.createNamedQuery("Recipe.getFavouritesListById");
        queryFavourites.setParameter("facourites", favouritesRecipeList);
        return queryFavourites.getResultList();
    }
}
