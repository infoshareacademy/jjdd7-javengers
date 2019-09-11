package com.infoshareacademy.service;

import com.infoshareacademy.exception.RecipeUploadedFileNotFound;
import java.io.IOException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
public class FileDataHandler {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @Inject
  FileUploadService fileUploadService;

  @Inject
  FileParserService fileParserService;

  public <T> Object dataUploadHandler(Part partFile) throws IOException, RecipeUploadedFileNotFound {
    logger.info("file was parsed, mapped and save to database");
    return fileParserService.parseDataToDatabase(fileUploadService.uploadFile(partFile));
  }
}




