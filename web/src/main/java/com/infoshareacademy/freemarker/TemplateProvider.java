package com.infoshareacademy.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.IOException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
public class TemplateProvider {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @Inject
  private ConfigLoader configLoader;

  public Template getTemplate(ServletContext servletContext, String templateName)
      throws IOException {

    Configuration configuration = configLoader.loadConfiguration();
    String TEMPLATE_DIRECTORY_PATH = "WEB-INF/fm-templates";
    configuration.setServletContextForTemplateLoading(servletContext, TEMPLATE_DIRECTORY_PATH);
    logger.info("Getting freemarker template");
    return configuration.getTemplate(templateName);
  }
}
