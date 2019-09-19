package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.Recipe;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FavouriteRecipe {

    @PersistenceContext
    EntityManager entityManager;

   public Recipe findFavoutieRecipeById(){


   }

}
