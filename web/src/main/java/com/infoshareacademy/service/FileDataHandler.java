package com.infoshareacademy.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.infoshareacademy.domain.api.RecipeResponse;
import com.infoshareacademy.exception.RecipeUploadedFileNotFound;
import java.io.File;
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

  public <T> Object dataUploadHandler(Part partFile) throws RecipeUploadedFileNotFound {
    Object outputObject = null;
    try {
      File file = fileUploadService.uploadFile(partFile);
      JsonNode jsonNode = parserService.getJsonNodeForFileParsing(file);
      List<RecipeResponse> recipes = (List<RecipeResponse>) parserService.parse(jsonNode);
      outputObject =  fileParserService.loadDataToDatabase(recipes);
    } catch (IOException e) {
      logger.error("Upload file: {} failed", partFile.toString());
    }
    logger.info("file {} was uploaded successfully", partFile.toString());
    return outputObject;
  }
}




