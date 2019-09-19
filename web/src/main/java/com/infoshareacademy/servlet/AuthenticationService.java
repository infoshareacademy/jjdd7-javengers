package com.infoshareacademy.servlet;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.infoshareacademy.service.TokenVerifierService;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/authentication")
public class AuthenticationService extends HttpServlet {

  private static final Logger logger = LoggerFactory
      .getLogger(AuthenticationService.class.getName());

  @EJB
  private TokenVerifierService tokenVerifierService;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

    resp.setContentType("text/html;charset=UTF-8");

    try {
      String idToken = req.getParameter("idToken");
      logger.info(idToken);
      GoogleIdToken.Payload payLoad = tokenVerifierService.getPayload(idToken);
      String name = (String) payLoad.get("name");
      String email = payLoad.getEmail();
      logger.info("User name: " + name);
      logger.info("User email: " + email);

      HttpSession session = req.getSession(true);
      session.setAttribute("User email", email); //TODO take id and @ from database
      req.getServletContext()
          .getRequestDispatcher("/welcome").forward(req, resp);

    } catch (Exception e) {
      logger.error(e.getMessage());
    }
  }
}
