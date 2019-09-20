package com.infoshareacademy.servlet;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.infoshareacademy.service.TokenVerifierService;
import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {

  private static final Logger logger = LoggerFactory
      .getLogger(LogOutServlet.class.getName());


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

    resp.setContentType("text/html;charset=UTF-8");

    try {
      HttpSession session = req.getSession();
      session.removeAttribute("User email");
      session.removeAttribute("isAuthenticated");
      resp.sendRedirect("/home"); //TODO

    } catch (Exception e) {
      logger.error(e.getMessage());
    }
  }
}
