package com.infoshareacademy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/dummy-servlet")
public class DummyServlet extends HttpServlet {

  private Logger logger = LoggerFactory.getLogger(DummyServlet.class.getName());

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    PrintWriter writer = resp.getWriter();
    writer.println("Hello Javengers");

    logger.trace("this is trace logger");
    logger.debug("this is debug logger");
    logger.info("this is info logger");
    logger.warn("this is warning logger");
    logger.error("this is error logger");
  }
}
