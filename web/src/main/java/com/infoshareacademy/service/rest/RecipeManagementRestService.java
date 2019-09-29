package com.infoshareacademy.service.rest;

import com.infoshareacademy.service.RecipeService;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
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

}
