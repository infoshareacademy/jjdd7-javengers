package com.infoshareacademy.service;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class ApiDataInitializer {

  @EJB
  private ApiDataHandler apiDataHandler;

  @PostConstruct
  protected void init() {
    apiDataHandler.parseAndLoadDataFormApi();
  }
}
