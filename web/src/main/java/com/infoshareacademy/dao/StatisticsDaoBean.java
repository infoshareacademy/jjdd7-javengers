package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.Recipe;
import com.infoshareacademy.domain.entity.statistics.RecipeStatistics;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class StatisticsDaoBean {

    @PersistenceContext
    EntityManager entityManager;

    public void saveToDB(RecipeStatistics recipieStatistics) {
        entityManager.persist(recipieStatistics);
    }

    public List<Object[]> findTop10Recipies() {
        return entityManager.createNamedQuery("Recipe.findTop10Recipies").setMaxResults(10).getResultList();

    }
    public List<Object[]> getCategoryRank() {
        return entityManager.createNativeQuery("select category.name , count(categories) as quantity from RecipeStatistics_categories JOIN category WHERE categories = category.id group by categories ORDER BY quantity DESC").getResultList();
    }
    public List<Object[]> getRecipieCategoryRank() {
        return entityManager.createNamedQuery("Recipe.getRecipiePerCategoryRank").getResultList();

    }
}

