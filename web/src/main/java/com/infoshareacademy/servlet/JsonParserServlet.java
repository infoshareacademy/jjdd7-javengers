package com.infoshareacademy.servlet;

import com.infoshareacademy.cdi.FileUploadProcessor;
import com.infoshareacademy.domain.Recipe;
import com.infoshareacademy.exception.UserImageNotFound;
import com.infoshareacademy.service.FileParserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@MultipartConfig
@WebServlet("/upload-data")
public class JsonParserServlet extends HttpServlet {

    @Inject
    FileParserService fileParserService;

    @Inject
    private FileUploadProcessor fileUploadProcessor;
    Logger logger = LoggerFactory.getLogger(JsonParserServlet.class);

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part jsonFile = req.getPart("drinks");
        String fileUrl = "";
        try {
            fileUrl = "/drinks/" + fileUploadProcessor.uploadImageFile(jsonFile).getName();
        } catch (UserImageNotFound userImageNotFound) {
            logger.warn(userImageNotFound.getMessage());
        }
        Recipe recipe1 = new Recipe();
        recipe1.setImageUrlAddress(fileUrl);
        resp.getWriter().println("File successful uploaded!");
    }
}
