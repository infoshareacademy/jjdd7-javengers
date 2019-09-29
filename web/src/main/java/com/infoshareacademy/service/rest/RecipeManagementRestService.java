package com.infoshareacademy.service.rest;

import com.infoshareacademy.domain.entity.Recipe;
import com.infoshareacademy.service.RecipeService;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/superHero/recipes")
public class RecipeManagementRestService {

  @EJB
  private RecipeService recipeService;

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @DELETE
  @Path("/deleteRecipe/{id}")
  public Response deleteUser(@PathParam("id") String recipeId) {

    Long id = Long.parseLong(recipeId);
    if (recipeService.getRecipeById(id) == null) {
      logger.info("Recipe with id {} not found ", id);
      return Response.status(Status.NOT_FOUND).build();
    } else {
      recipeService.deleteRecipeById(id);
      logger.info("Recipe with id {} removed", id);
    }
    return Response.ok().build();
  }

  @PATCH
  @Path("/updateRecipe/{id}")
  public Response updateRecipe(@PathParam("id") String userId) {

    if (!NumberUtils.isDigits(userId)) {
      return Response.status(Status.BAD_REQUEST).build();
    }
    Long id = Long.parseLong(userId);
    if (recipeService.getRecipeById(id) == null) {
      logger.info("User not found user with id {}", id);
      return Response.status(Status.NOT_FOUND).build();
    } else {

      Recipe recipe = recipeService.getRecipeById(id);
      recipe.setApproved(true);
      recipeService.editRecipe(recipe);
      logger.info("Recipe with id {} was updated",id);
    }
    return Response.ok().build();
  }
}
