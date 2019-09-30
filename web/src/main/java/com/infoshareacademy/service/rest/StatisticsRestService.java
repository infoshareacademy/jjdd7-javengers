package com.infoshareacademy.service.rest;

import com.infoshareacademy.dao.StatisticsDaoBean;
import com.infoshareacademy.domain.entity.Recipe;
import com.infoshareacademy.domain.view.StatisticsCategoryView;
import com.infoshareacademy.domain.view.StatisticsView;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/superHero")
public class StatisticsRestService {

    @Inject
    private StatisticsDaoBean statisticsDaoBean;

    @GET
    @Path("/statistics/topTen")
    @Produces(MediaType.APPLICATION_JSON)
    public Response top10Recipies() {


        List<StatisticsView> statisticsViews = new ArrayList<>();

        List<Object[]> recipeStatistics = statisticsDaoBean.findTop10Recipies();
        recipeStatistics.forEach(row -> {
            StatisticsView rcp = new StatisticsView();
            rcp.setRecipieName(String.valueOf(row[0]));
            rcp.setQuantity(Long.valueOf(String.valueOf(row[1])));
            statisticsViews.add(rcp);
        });

        return Response.ok(statisticsViews).build();
    }

    @GET
    @Path("/statistics/categoryRank")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategoriesRank() {

        List<StatisticsCategoryView> statisticsViews = new ArrayList<>();

        List<Object[]> categoryStatistics = statisticsDaoBean.getCategoryRank();
        categoryStatistics.forEach(row -> {
            StatisticsCategoryView categoryStatistic = new StatisticsCategoryView();
            categoryStatistic.setCategoryName(String.valueOf(row[0]));
            categoryStatistic.setQuantity(Long.valueOf(String.valueOf(row[1])));
            statisticsViews.add(categoryStatistic);
        });

        return Response.ok(statisticsViews).build();
    }
    @GET
    @Path("/statistics/recipeCategoryRank")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecipeCategoriesRank() {

        List<StatisticsCategoryView> statisticsViews = new ArrayList<>();

        List<Object[]> recipieCategoryRank = statisticsDaoBean.getRecipieCategoryRank();
        recipieCategoryRank.forEach(row -> {
            StatisticsCategoryView categoryStatistic = new StatisticsCategoryView();
            categoryStatistic.setCategoryName(String.valueOf(row[0]));
            categoryStatistic.setQuantity(Long.valueOf(String.valueOf(row[1])));
            statisticsViews.add(categoryStatistic);
        });


        return Response.ok(statisticsViews).build();
    }

}
