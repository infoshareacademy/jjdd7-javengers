package com.infoshareacademy.service.rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.infoshareacademy.domain.view.RecipeLiveSearchView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Path("/recipes")
@Stateless
public class RecipeRestService {

  @EJB
  private ApiRecipeService apiRecipeService;

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @GET
  @Path("/nameChars/{nameChars}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getNotification(@PathParam("nameChars") String nameChars) {
    logger.info("recipes with name contains " + nameChars + "were parsed to json successfully" );
    List<RecipeLiveSearchView> recipes = apiRecipeService.getLiveSearchRecipe(nameChars);
    if (recipes.isEmpty()) {
      logger.warn("Cannot find ingredients {} contains " + nameChars);
      return Response.status(Response.Status.NOT_FOUND).build();
    }
    logger.info("Found ingredients {} contains " + nameChars);
    return Response.ok().entity(recipes).build();
  }

  @GET
  @Path("/all")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getNotification() {
    logger.info("recipes were parsed to json" );
    return Response.ok().entity(apiRecipeService.getRecipesList()).build();
  }
}
