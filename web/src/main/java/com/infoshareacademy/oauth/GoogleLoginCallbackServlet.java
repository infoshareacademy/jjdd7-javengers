package com.infoshareacademy.oauth;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.AuthorizationCodeResponseUrl;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.servlet.auth.oauth2.AbstractAuthorizationCodeCallbackServlet;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.oauth2.Oauth2;
import com.google.api.services.oauth2.model.Userinfoplus;
import com.infoshareacademy.domain.entity.User;
import com.infoshareacademy.service.UserService;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/oauth2callback")
public class GoogleLoginCallbackServlet extends AbstractAuthorizationCodeCallbackServlet {

  private static final Logger logger = Logger.getLogger(GoogleLoginCallbackServlet.class.getName());

  @EJB
  private UserService userService;


  @Override
  protected void onSuccess(HttpServletRequest req, HttpServletResponse resp, Credential credential)
      throws IOException {
    GoogleCredential gCredential = new GoogleCredential()
        .setAccessToken(credential.getAccessToken());
    Oauth2 oauth2 = new Oauth2.Builder(
        new NetHttpTransport(),
        JacksonFactory.getDefaultInstance(),
        gCredential).setApplicationName("Drinkopedia").build();

    Userinfoplus info = oauth2.userinfo().get().execute();
    String name = info.getName();
    String surname = info.getGivenName();
    String email = info.getEmail();

    if (userService.findUserByEmail(email) == null){
      User user = new User();
      user.setName(name);
      user.setEmail(email);
      user.setUserType("user");
      userService.save(user);
    }

    logger.info("Authentication success of user: " + name);

    User verifiedUser = userService.findUserByEmail(email);

    req.getSession().setAttribute("email", verifiedUser.getEmail());
    req.getSession().setAttribute("userType", verifiedUser.getUserType());
    req.getSession().setAttribute("name", verifiedUser.getName());
    req.getSession().setAttribute("userId",verifiedUser.getId());


    if (req.getSession().getAttribute("userType") == null){
      req.getSession().setAttribute("userType", "guest");
    }
    resp.sendRedirect("/home");
  }

  @Override
  protected void onError(HttpServletRequest req, HttpServletResponse resp,
      AuthorizationCodeResponseUrl errorResponse) {
    logger.severe("Google auth error: " + errorResponse.getError());
  }

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
