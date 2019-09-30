package com.infoshareacademy.service.statistics;

import com.infoshareacademy.dao.StatisticsDaoBean;
import com.infoshareacademy.domain.entity.Recipe;
import com.infoshareacademy.domain.entity.statistics.RecipeStatistics;
import com.infoshareacademy.domain.entity.statistics.Type;
import com.infoshareacademy.service.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Stateless
public class StatisticsService {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    @Inject
    private StatisticsDaoBean statisticsDaoBean;
    @Inject
    private RecipeService recipeService;


    public void addRecipe(Long recipieId) {
        RecipeStatistics recipeStatistics = new RecipeStatistics();
        Recipe recipe = recipeService.getRecipeById(recipieId);
        recipeStatistics.setRecipieId(recipieId);
        recipeStatistics.setRecipieName(recipe.getName());
        recipeStatistics.setType(Type.SINGLE_VIEW.getType());
        statisticsDaoBean.saveToDB(recipeStatistics);

    }

    public void addCategories(List<Long> categories) {
        RecipeStatistics recipeStatistics = new RecipeStatistics();
        recipeStatistics.setCategories(getCategories(categories));
        recipeStatistics.setType(Type.CHECKED_CATEGORY.getType());
        statisticsDaoBean.saveToDB(recipeStatistics);
    }

    public void saveToDB(Long recipieId, List<Long> categories) {
        if (recipieId > 0) {
            addRecipe(recipieId);
        }

        addCategories(categories);
    }

    public Set<Long> getCategories(List<Long> categories) {
        return categories.stream()
                .collect(Collectors.toSet());

    }


}



