package com.infoshareacademy.servlet;

import com.infoshareacademy.domain.entity.Recipe;
import com.infoshareacademy.exception.RecipeUploadedFileNotFound;
import com.infoshareacademy.service.FileDataHandler;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MultipartConfig
@WebServlet("/upload-data")
public class JsonParserServlet extends HttpServlet {

    @Inject
    private FileDataHandler fileDataHandler;
    Logger logger = LoggerFactory.getLogger(JsonParserServlet.class);

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part jsonFile = req.getPart("drinks");
        String fileUrl = "";
        try {
            fileUrl = "/drinks/" + fileDataHandler.dataUploadHandler(jsonFile);
        } catch (RecipeUploadedFileNotFound recipeUploadedFileNotFound) {
            logger.warn(recipeUploadedFileNotFound.getMessage());
        }
        Recipe recipe1 = new Recipe();
        recipe1.setImageUrl(fileUrl);
        resp.getWriter().println("File successful uploaded!");
    }
}