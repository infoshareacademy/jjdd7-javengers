package com.infoshareacademy.service.rest;

import com.infoshareacademy.domain.entity.User;
import com.infoshareacademy.service.UserService;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/superHero/users")
@Stateless
public class UserRestService {

  @EJB
  private UserService userService;

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @DELETE
  @Path("/deleteUser/{id}")
  public Response deleteUser(@PathParam("id") String userId) {
    Long id = Long.parseLong(userId);

    if (userService.getUserById(id) == null) {
      logger.info("User with id {} not found ", id);
      return Response.status(Status.NOT_FOUND).build();
    }
    User user = userService.getUserById(id);

    if (user.getEmail().equals("javengers.team@gmail.com")) {
      logger.info("There was an attempt to delete super admin");
      return Response.status(Status.NOT_MODIFIED).build();
    } else {
      userService.deleteUserById(id);
      logger.info("User with id {} was deleted", id);
    }
    logger.info("user with id {} removed",id);
    return Response.ok().build();
  }
}
