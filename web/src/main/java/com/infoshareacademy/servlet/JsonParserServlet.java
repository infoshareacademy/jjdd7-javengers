package com.infoshareacademy.servlet;

import com.infoshareacademy.service.CategoryService;
import com.infoshareacademy.service.DrinkTypeService;
import com.infoshareacademy.service.IngredientMeasureService;
import com.infoshareacademy.service.IngredientService;
import com.infoshareacademy.service.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;


@WebServlet("/upload-data")
public class JsonParserServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(DummyServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part file = req.getPart("file");
        Long size = file.getSize();
        String name = file.getName();
        logger.info("uploaded file: {} with [{}] bytes", name, size);
    }
}
