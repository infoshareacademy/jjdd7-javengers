package com.infoshareacademy.cdi;

import com.infoshareacademy.exception.RecipeUploadedFileNotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

@RequestScoped
public class FileUploadProcessor {
    private static String SETTINGS_FILE = "settings.properties";
    private static String UPLOAD_KEY = "Upload.Path";

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    public File uploadFile(Part filePart) throws IOException, RecipeUploadedFileNotFound {
        logger.info("Json file upload");

        String filename = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        java.io.File file = new File(getUploadFilesPath() + filename);
        Files.deleteIfExists(file.toPath());

        InputStream fileContent = filePart.getInputStream();
        Files.copy(fileContent, file.toPath());
        return file;
    }

    public String getUploadFilesPath() throws IOException {
        logger.info("Getting json file path");
        Properties settings = new Properties();
        settings.load(Thread.currentThread().getContextClassLoader().getResource(SETTINGS_FILE).openStream());
        return settings.getProperty(UPLOAD_KEY);
    }

}
