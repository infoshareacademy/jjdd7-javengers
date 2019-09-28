package com.infoshareacademy.service.rest;


import com.infoshareacademy.service.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/favourites/{recipeId}")
@Stateless
public class FavouritesRecipeViewRestService {

    @Inject
    UserService userService;

    @GET
    public Response editFavouritesListForUser(@PathParam("recipeId") String n) {
        Long favouriteId = Long.parseLong(n);
        //zamockowany - trzeba przekazac parametr sesji
        Long userId = 2L;
        userService.editFavouritesByIdForUSer(favouriteId, userId);

        return Response.ok().build();
    }



}
