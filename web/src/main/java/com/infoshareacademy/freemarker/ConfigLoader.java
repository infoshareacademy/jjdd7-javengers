package com.infoshareacademy.freemarker;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import javax.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class ConfigLoader {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());
  private Configuration configuration;

  Configuration loadConfiguration() {
    if (configuration == null) {
      configuration = new Configuration(Configuration.VERSION_2_3_29);
      configuration.setDefaultEncoding("UTF-8");
      configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
      configuration.setLogTemplateExceptions(false);
      configuration.setWrapUncheckedExceptions(true);
    }
    logger.info("Freemarker configuration loaded");
    return configuration;
  }
}
