package com.infoshareacademy.service;

import com.infoshareacademy.cdi.FileUploadProcessor;

import javax.inject.Inject;
import java.io.File;

public class FileParserService {

    @Inject
    private ParserService parserService;
    @Inject
    private FileUploadProcessor fileUploadProcessor;



}
