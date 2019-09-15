package com.infoshareacademy.service.rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/ingredients")
@Stateless
public class IngredientRestService {

  @EJB
  private ApiIngredientService apiIngredientService;

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @GET
  @Path("/nameChars/{nameChars}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getNotification(@PathParam("nameChars") String nameChars) {
    logger.info("Ingredients with name contains " +nameChars + " was parsed to json successfully");
    return Response.ok().entity(apiIngredientService.getLiveSearchIngredient(nameChars)).build();
  }
}
