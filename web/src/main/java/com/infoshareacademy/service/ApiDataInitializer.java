package com.infoshareacademy.service;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Startup
@Singleton
@Transactional
public class ApiDataInitializer {

  @EJB
  private ApiDataHandler apiDataHandler;

  private Logger logger = LoggerFactory.getLogger(getClass().getName());
  private static final String URI = "http://isa-proxy.blueazurit.com/cocktails/1/search.php?f=";

  @PostConstruct
  protected void init() {
    int num = 48;
    while (num++ <= 90) {
      char asciiSign = (char) num;
      apiDataHandler.parseAndLoadDataFormApi(URI + asciiSign);
      logger.info("Load data from :" + URI + asciiSign);
    }
  }
}
