package com.infoshareacademy.servlet;

import com.infoshareacademy.domain.RecipeWithJsonAnnotations;
import com.infoshareacademy.repository.RecipeRepository;
import com.infoshareacademy.service.LoadParsedDataToDao;
import com.infoshareacademy.service.ParserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/upload-data")
public class JsonParserServlet extends HttpServlet {

  @Inject
  private ParserService parserService;

  @Inject
  private LoadParsedDataToDao loadParsedDataToDao;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    loadParsedDataToDao.loadParsedData((List<RecipeWithJsonAnnotations>) parserService.parseFile());
//
//    this print is just for test
//    PrintWriter writer = resp.getWriter();
//    writer.println(RecipeRepository.getRecipesList());
  }
}
