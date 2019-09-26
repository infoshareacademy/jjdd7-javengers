package com.infoshareacademy.web.servlet;

import com.infoshareacademy.domain.entity.Recipe;
import com.infoshareacademy.exception.RecipeUploadedFileNotFound;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.FileDataHandler;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
@WebServlet("/superHero/upload-data")
public class JsonParserServlet extends HttpServlet {

    @Inject
    private FileDataHandler fileDataHandler;

    @Inject
    private TemplateProvider templateProvider;
    Logger logger = LoggerFactory.getLogger(JsonParserServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        Template template = templateProvider.getTemplate(getServletContext(),"admin-view");
        Map<String, Object> model = new HashMap<>();
        try {
            template.process(model, resp.getWriter());
        } catch (IOException | TemplateException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws
        ServletException, IOException {
        Part jsonFile = req.getPart("drinks");
        String fileUrl = "";
        try {
            fileUrl = "/drinks/" + fileDataHandler.dataUploadHandler(jsonFile);
        } catch (RecipeUploadedFileNotFound recipeUploadedFileNotFound) {
            logger.info(recipeUploadedFileNotFound.getMessage());
        }
        Recipe drinkRecipe = new Recipe();
        drinkRecipe.setImageUrl(fileUrl);
        req.getSession().setAttribute("fileUpload",true);
        resp.getWriter().println(fileUrl + " successful uploaded!");
    }
}