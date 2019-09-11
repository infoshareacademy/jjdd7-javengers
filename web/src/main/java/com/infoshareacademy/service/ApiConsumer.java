package com.infoshareacademy.service;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@Stateless
public class ApiConsumer {

  private WebTarget webTarget;
  private static final String URI_ADDRESS = "http://isa-proxy.blueazurit.com/cocktails/1/search.php?f=a";

  public String consumeApi() {
    init();
    Response response = webTarget.request().get();
    String resp = response.readEntity(String.class);
    return resp;
  }

  private void init() {
    Client client = ClientBuilder.newClient();
    webTarget = client.target(URI_ADDRESS);
  }

}
