package com.infoshareacademy.FileUpload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.Part;

@RequestScoped
public class FileUploadProcessor {

    private static final String SETTINGS_FILE = "settings.properties";

    public File uploadImageFile(Part filePart) throws IOException, UserImageNotFound {

        String fileName = Paths.get(filePart.getSubmittedFileName())
                .getFileName().toString();

        if (fileName == null || fileName.isEmpty()) {
            throw new UserImageNotFound("No user image has been uploaded");
        }

        File file = new File(getUploadImageFilesPath() + fileName);
        Files.deleteIfExists(file.toPath());

        InputStream fileContent = filePart.getInputStream();
//    OutputStream os = new FileOutputStream(file);

        Files.copy(fileContent, file.toPath());

//    byte[] buffer = new byte[1024];
//    int bytesRead;
//    while ((bytesRead = fileContent.read(buffer)) != -1) {
//      os.write(buffer, 0, bytesRead);
//    }

        fileContent.close();
//    os.flush();
//    os.close();

        return file;
    }

    public String getUploadImageFilesPath() throws IOException {
        Properties settings = new Properties();
        settings.load(Thread.currentThread()
                .getContextClassLoader().getResource(SETTINGS_FILE)
                .openStream());
        return settings.getProperty("Upload.Path.Images");
    }
}
