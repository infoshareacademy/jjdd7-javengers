package com.infoshareacademy.service;

import com.infoshareacademy.cdi.FileUploadProcessor;
import com.infoshareacademy.exception.RecipeUploadedFileNotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;
import java.io.IOException;

@RequestScoped
public class FileDataHandler {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    @Inject
    FileUploadProcessor fileUploadProcessor;
    @Inject
    ParserService parserService;

    public  <T> Object dataUploadHandler(Part partFile) throws IOException, RecipeUploadedFileNotFound {
        logger.info("Parse data from uploaded file ");
        return parserService.parseFile(fileUploadProcessor.uploadFile(partFile));
    }

}




