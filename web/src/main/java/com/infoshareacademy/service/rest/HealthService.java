package com.infoshareacademy.service.rest;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/health")
@Stateless
public class HealthService {
    @GET
    public Response checkHealth() {
        return Response.ok().build();
    }
}