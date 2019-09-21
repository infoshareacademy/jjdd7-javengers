package com.infoshareacademy.oauth;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.extensions.servlet.auth.oauth2.AbstractAuthorizationCodeServlet;
import java.util.UUID;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/login")
public class GoogleLoginServlet extends AbstractAuthorizationCodeServlet {

  private static final Logger logger = Logger.getLogger(GoogleLoginServlet.class.getName());


  @Override
  protected String getRedirectUri(HttpServletRequest req) {
    return GoogleLoginCommons.buildRedirectUri(req);
  }

  @Override
  protected AuthorizationCodeFlow initializeFlow() {
    return GoogleLoginCommons.buildFlow();
  }

  @Override
  protected String getUserId(HttpServletRequest req) {
    String randomUserId = UUID.randomUUID().toString();
    logger.info("getUserId: " + randomUserId);
    return randomUserId;
  }
}
