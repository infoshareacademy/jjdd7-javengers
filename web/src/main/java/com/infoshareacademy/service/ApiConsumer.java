package com.infoshareacademy.service;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@Stateless
public class ApiConsumer {

  private WebTarget webTarget;

  public String fetchBody(String uri) {
    configureClient(uri);
    Response response = webTarget.request().get();
    return response.readEntity(String.class);
  }

  private void configureClient(String uri) {
    Client client = ClientBuilder.newClient();
    webTarget = client.target(uri);
  }
}
