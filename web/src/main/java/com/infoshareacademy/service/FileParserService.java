package com.infoshareacademy.service;

import com.infoshareacademy.dao.CategoryDaoBean;
import com.infoshareacademy.domain.api.RecipeApi;
import com.infoshareacademy.domain.entity.Category;
import com.infoshareacademy.mapper.CategoryMapper;
import com.infoshareacademy.mapper.RecipeMapper;
import java.io.File;
import java.util.List;
import java.util.Optional;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Transactional
@RequestScoped
public class FileParserService {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private ParserService parserService;

    @EJB
    private RecipeMapper recipeMapper;

    @EJB
    private CategoryMapper categoryMapper;

    @EJB
    private CategoryDaoBean categoryDaoBean;

    public Object parseDataToDatabase(File json) {
        List<RecipeApi> recipes = (List<RecipeApi>) parserService.parseFile(json);
        for (RecipeApi recipe : recipes) {
            Category category = Optional
                .ofNullable(categoryDaoBean.findCategoryByName(recipe.getRecipeCategory()))
                .orElseGet(() -> categoryMapper.mapCategory(recipe));
            category.getRecipes().add(recipeMapper.mapRecipes(recipe, category));
            categoryDaoBean.updateCategory(category);
        }
        logger.info("file was parsed successfully");
        return null;
    }
}
