package com.infoshareacademy.mapper;

import com.infoshareacademy.domain.api.RecipeResponse;
import com.infoshareacademy.domain.entity.Category;
import com.infoshareacademy.domain.entity.Recipe;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Properties;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class RecipeToAddDtoToEntityMapper {

    @EJB
    private IngredientMapper ingredientMapper;
    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Transactional
    public Recipe mapRecipe(RecipeResponse recipe, Category category) throws IOException {

        Recipe drinkRecipe = new Recipe();
        String datePattern = getDatePattern();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
        drinkRecipe.setId(recipe.getId());
        drinkRecipe.setName(recipe.getName());
        drinkRecipe.setDrinkType(recipe.getDrinkType());
        drinkRecipe.setGlassType(recipe.getGlassType());
        drinkRecipe.setInstruction(recipe.getInstruction());
        drinkRecipe.getIngredients().addAll(ingredientMapper.mapIngredients(recipe));
        drinkRecipe.setModificationDate(LocalDateTime.now().format(formatter));
        drinkRecipe.setImageUrl(recipe.getImageUrl());
        drinkRecipe.setCategory(category);
        drinkRecipe.setCustom(true);
        drinkRecipe.setApproved(false);
        logger.info("Recipe {} was mapped", drinkRecipe.getName());
        return drinkRecipe;
    }

    private String getDatePattern() throws IOException {
        Properties settings = new Properties();
        settings.load(Objects.requireNonNull(Thread.currentThread()
                .getContextClassLoader().getResource("settings.properties"))
                .openStream());
        String dateFormat = settings.getProperty("date.format");
        logger.info("Date Time format is: " + dateFormat);
        return dateFormat;
    }
}
