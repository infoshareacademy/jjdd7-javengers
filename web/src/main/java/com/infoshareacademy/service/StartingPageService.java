package com.infoshareacademy.service;

import com.infoshareacademy.domain.entity.Recipe;
import java.util.Collections;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class StartingPageService {

    @Inject
    private FilteringService filteringService;

    public List<Recipe> getRecipesPerPage(int pageNumber, List<Recipe> filterList) {
        int pageSize = 5;

        if (pageSize <= 0 || pageNumber <= 0) {
            throw new IllegalArgumentException("invalid page size: " + pageSize);
        }
        int fromIndex = (pageNumber - 1) * pageSize;
        if (filterList == null || filterList.size() < fromIndex) {
            return Collections.emptyList();
        }
        return filterList.subList(fromIndex, Math.min(fromIndex + pageSize, filterList.size()));
    }

    public Integer getLastNumberPage(List<Recipe> recipeList) {
        int pageSize = 5;
        return (recipeList.size() + pageSize - 1) / pageSize;
    }

    public List<Recipe> filterContentList(List<String> checkedOptionList,
        List<String> checkedIngredientsList, List<Long> parsedToLongCategoriesList,
        List<String> checkedTypesList, Long userId) {

        List<Recipe> listWithFilters;

        if (checkedOptionList.contains("All Drinks")) {

            if (checkedIngredientsList.size() == 0 || checkedIngredientsList == null
                || checkedIngredientsList.isEmpty()) {
                listWithFilters = filteringService.getFiltersQueryByCategoryAndType
                    (parsedToLongCategoriesList, checkedTypesList);
            } else {
                listWithFilters = filteringService.getAllFiltersQuery(parsedToLongCategoriesList,
                    checkedIngredientsList, checkedTypesList);
            }
        } else {

            if (checkedIngredientsList.size() == 0 || checkedIngredientsList == null
                || checkedIngredientsList.isEmpty()) {
                listWithFilters = filteringService.getFavouritesFiltersQueryByCategoryAndType
                    (parsedToLongCategoriesList, checkedTypesList, userId);
            } else {
                listWithFilters = filteringService.getFavouritesFiltersQuery
                    (parsedToLongCategoriesList, checkedIngredientsList, checkedTypesList, userId);
            }
        }
        return listWithFilters;
    }
}




