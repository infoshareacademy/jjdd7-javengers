package com.infoshareacademy.cdi;

import com.infoshareacademy.exception.UserImageNotFound;

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

    public File uploadFile(Part filePart) throws IOException, UserImageNotFound {

        String filename = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        java.io.File file = new File(getUploadFilesPath() + filename);
        Files.deleteIfExists(file.toPath());

        InputStream fileContent = filePart.getInputStream();
        Files.copy(fileContent, file.toPath());
        return file;
    }

    public String getUploadFilesPath() throws IOException {
        Properties settings = new Properties();
        settings.load(Thread.currentThread().getContextClassLoader().getResource(SETTINGS_FILE).openStream());
        return settings.getProperty("Upload.Path");
    }

}
