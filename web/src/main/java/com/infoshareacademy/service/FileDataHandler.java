package com.infoshareacademy.service;

import com.infoshareacademy.domain.api.RecipeApi;
import com.infoshareacademy.exception.RecipeUploadedFileNotFound;
import java.io.IOException;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
public class FileDataHandler {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @Inject
  private FileUploadService fileUploadService;

  @Inject
  private FileParserService fileParserService;

  @Inject
  private ParserService parserService;

  public <T> Object dataUploadHandler(Part partFile) throws IOException, RecipeUploadedFileNotFound {
    logger.info("file was parsed, mapped and save to database");
    List<RecipeApi> recipes = (List<RecipeApi>) parserService
        .parseRecipes(fileUploadService.uploadFile(partFile));
    return fileParserService.loadDataToDatabase(recipes);
  }
}




