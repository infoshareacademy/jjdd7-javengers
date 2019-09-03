package com.infoshareacademy.servlet;

import com.infoshareacademy.domain.Recipe;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.LoadParsedDataToDao;
import com.infoshareacademy.service.ParserService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/upload-data")
public class JsonParserServlet extends HttpServlet {

  @Inject
  private ParserService parserService;

  @Inject
  private TemplateProvider templateProvider;

  @Inject
  private LoadParsedDataToDao loadParsedDataToDao;

  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {

    Template template = templateProvider.getTemplate(getServletContext(),
        "admin-view.ftlh");

    String status = req.getParameter("status");

    if (status.equals("active")) {
      loadParsedDataToDao.loadParsedData((List< Recipe>)parserService.parseFile());
    }

    Map<String, Object> dataModel = new HashMap<>();
    dataModel.put("status", status);

    if (status == null || status.isEmpty()) {
      resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      return;
    }

    PrintWriter writer = resp.getWriter();
    try {
      template.process(dataModel, writer);
    } catch (TemplateException e) {
      e.printStackTrace();
    }
  }
}
