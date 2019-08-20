package com.infoshareacademy.service;
import com.infoshareacademy.properties.AppConfig;
import com.infoshareacademy.domain.Recipe;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import static com.infoshareacademy.service.RecipeService.RECIPES_LIST;
private static String DATE_FORMATTER = AppConfig.dateFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;



public class AgeChecker {


/*    public static Map<Integer,String> getAlcoholicMap(){
        Map<Integer,String> alcoholicRecipeMap = new HashMap<>();
        String alcoholType = null;
        int counter = 0;
        for (Recipe recipe : RECIPES_LIST) {
            counter++;
            alcoholType= recipe.getAlcoholicOrNot();
            alcoholicRecipeMap.put(counter,alcoholType);
        }
            return alcoholicRecipeMap;

    }*/



    public String formatActualDate() {
        String formatedActualDateTime = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        LocalDateTime localDateTime = LocalDateTime.now();
        formatedActualDateTime = localDateTime.format(formatter);
        return formatedActualDateTime;
    }



    }

