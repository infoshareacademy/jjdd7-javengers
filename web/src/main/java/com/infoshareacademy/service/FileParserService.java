package com.infoshareacademy.service;

import com.infoshareacademy.cdi.FileUploadProcessor;

import com.infoshareacademy.domain.api.RecipeApi;
import com.infoshareacademy.mapper.RecipeMapper;
import com.infoshareacademy.servlet.JsonParserServlet;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.File;

@RequestScoped
public class FileParserService {

    @Inject
    private ParserService parserService;

    @EJB
    private RecipeMapper recipeMapper;

    public void parseSaveFileAndData(){
        List<RecipeApi> recipes = (List< RecipeApi>)parserService.parseFile("/opt/drinks.json");
        for (RecipeApi recipe:recipes
        ) {
            recipeMapper.mapRecipes(recipe);
        }
    }
}
