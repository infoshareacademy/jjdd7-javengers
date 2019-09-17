package com.infoshareacademy.service.rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/categories")
@Stateless
public class CategoryRestService {

  @EJB
  private ApiCategoryService apiCategoryService;

  @GET
  @Path("/all")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getNotification(){
    return Response.ok().entity(apiCategoryService.getCategories()).build();
  }
}
