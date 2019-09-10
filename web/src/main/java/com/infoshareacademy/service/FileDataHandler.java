package com.infoshareacademy.service;

import com.infoshareacademy.cdi.FileUploadProcessor;
import com.infoshareacademy.exception.UserImageNotFound;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Path;

@RequestScoped
public class FileDataHandler {

    @Inject
    FileUploadProcessor fileUploadProcessor;
    @Inject
    ParserService parserService;

    public  <T> Object dataUploadHandler(Part partFile) throws IOException, UserImageNotFound {
        return parserService.parseFile(fileUploadProcessor.uploadFile(partFile));
    }

}




