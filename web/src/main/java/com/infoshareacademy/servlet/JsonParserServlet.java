package com.infoshareacademy.servlet;

import com.infoshareacademy.service.LoadParsedDataService;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/upload-data")
public class JsonParserServlet extends HttpServlet {

  @Inject
  private LoadParsedDataService loadParsedDataService;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    loadParsedDataService.loadParsedData();
  }
}
