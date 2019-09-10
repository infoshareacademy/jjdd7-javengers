package com.infoshareacademy.service;

import com.infoshareacademy.cdi.FileUploadProcessor;
import com.infoshareacademy.exception.UserImageNotFound;
import java.io.IOException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;

@RequestScoped
public class FileDataHandler {

  @Inject
  FileUploadProcessor fileUploadProcessor;

  @Inject
  FileParserService fileParserService;


  public <T> Object dataUploadHandler(Part partFile) throws IOException, UserImageNotFound {
    return fileParserService.parseSaveFileAndData(fileUploadProcessor.uploadFile(partFile));
  }
}




