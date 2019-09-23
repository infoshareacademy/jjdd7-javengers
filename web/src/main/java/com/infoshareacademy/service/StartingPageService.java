package com.infoshareacademy.service;

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

    public List<Long> getFavouritesFromUser(Long favouriteId) {
        List<Recipe> listFromUser = userService.getFavouritesList();
        List<Long> favouritesIds = listFromUser.stream().map(r -> r.getId()).collect(Collectors.toList());

        if (favouritesIds.contains(favouriteId)) {
            favouritesIds.remove(favouriteId);
        } else {
            favouritesIds.add(favouriteId);
        }
        return favouritesIds;
    }



    }







