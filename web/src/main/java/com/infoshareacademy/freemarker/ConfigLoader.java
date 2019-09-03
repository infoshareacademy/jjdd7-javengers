package com.infoshareacademy.freemarker;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ConfigLoader {

  Configuration configuration;

  public Configuration loadConfiguration() {
    if (configuration == null) {
      configuration = new Configuration(Configuration.VERSION_2_3_29);
      configuration.setDefaultEncoding("UTF-8");
      configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
      configuration.setLogTemplateExceptions(false);
      configuration.setWrapUncheckedExceptions(true);
    }
    return configuration;
  }
}
