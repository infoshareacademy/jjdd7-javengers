package com.infoshareacademy.service.rest;

import com.infoshareacademy.domain.entity.User;
import com.infoshareacademy.service.UserService;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("superHero")
@Stateless
public class UserRestService {

  @EJB
  private UserService userService;

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @PATCH
  @Path("/addAdminPermissions/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAdminPrivileges(@PathParam("id") String userId) {

    if (!NumberUtils.isDigits(userId)) {
      return Response.status(Status.BAD_REQUEST).build();
    }

    Long id = Long.parseLong(userId);

    if (userService.getUserById(id) == null) {
      logger.info("User not found user with id {}", id);
      return Response.status(Status.NOT_FOUND).build();
    }

    User user = userService.getUserById(id);

    if (user.getUserType().equals("user")) {
      user.setUserType("admin");
      userService.updateUser(user);
      logger.info("User with id {} received admin privileges", id);
    } else {
      return Response.status(Status.NOT_MODIFIED).build();
    }
    return Response.ok().build();
  }

  @PATCH
  @Path("/revokeAdminPermissions/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response revokeAdminPrivilege(@PathParam("id") String userId) {

    if (!NumberUtils.isDigits(userId)) {
      return Response.status(Status.BAD_REQUEST).build();
    }
    //TODO
    return Response.ok().build();
  }
}
