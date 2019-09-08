package com.infoshareacademy.servlet;

import com.infoshareacademy.service.CategoryService;
import com.infoshareacademy.service.DrinkTypeService;
import com.infoshareacademy.service.IngredientMeasureService;
import com.infoshareacademy.service.IngredientService;
import com.infoshareacademy.service.RecipeService;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


@WebServlet("/upload-data")
public class JsonParserServlet extends HttpServlet {

  @Inject
  private CategoryService categoryService;

  @Inject
  private DrinkTypeService drinkTypeService;

  @Inject
  private IngredientService ingredientService;

  @Inject
  IngredientMeasureService ingredientMeasureService;

  @Inject
  private RecipeService recipeService;

}
