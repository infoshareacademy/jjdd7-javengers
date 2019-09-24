package com.infoshareacademy.service;

import com.infoshareacademy.domain.entity.Ingredient;
import com.infoshareacademy.domain.entity.Recipe;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class StartingPageService {

    @Inject
    private RecipeService recipeService;
    @Inject
    private UserService userService;
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


    public List<Long> getListOfFavouritesIds() {
        return userService.getFavouritesList().stream().map(r -> r.getId()).collect(Collectors.toList());
    }

    public List<Recipe> getFavouritesFromUser(List<Recipe> listFromUser, Long id) {

        Recipe favouriteRecipe = userService.getFavouriteRecipeById(id);

        if (listFromUser.contains(favouriteRecipe)) {
            listFromUser.remove(favouriteRecipe);
        } else {
            listFromUser.add(favouriteRecipe);
        }
        return listFromUser;
    }




    public List<Recipe> filteredContentList(List <String> checkedOptionList, List<String> checkedIngredientsList, List<Long> parsedToLongCategoriesList, List<String> checkedTypesList, List<Long> favouritesList) {


        List<Recipe> listWithFilters;

        if (checkedOptionList.contains("All Drinks")) {

            if (checkedIngredientsList.size() == 0 || checkedIngredientsList == null || checkedIngredientsList.isEmpty()) {
                listWithFilters = filteringService.getFiltersQueryByCategoryAndType(parsedToLongCategoriesList, checkedTypesList);
            } else {
                listWithFilters = filteringService.getAllFiltersQuery(parsedToLongCategoriesList, checkedIngredientsList, checkedTypesList);
            }
        } else {

            if (checkedIngredientsList.size() == 0 || checkedIngredientsList == null || checkedIngredientsList.isEmpty()) {
                listWithFilters = filteringService.getFiltersQueryByCategoryAndType(parsedToLongCategoriesList, checkedTypesList);
            } else {
                listWithFilters = filteringService.getFavouritesFiltersQuery(parsedToLongCategoriesList, checkedIngredientsList, checkedTypesList,favouritesList);
            }
        }
        return listWithFilters;
    }

}







