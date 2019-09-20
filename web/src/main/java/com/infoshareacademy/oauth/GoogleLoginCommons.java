package com.infoshareacademy.oauth;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class GoogleLoginCommons {

  private static final List<String> SCOPES = List.of("openid", "email", "profile");

  private static final String CLIENT_ID
      = "1037530492027-j033lgm76kc63lrkqpaus0sn25q00vj2.apps.googleusercontent.com";
  private static final String SECRET = "Srxfze3GVuRvtrm5gU6-X1co";

  private static final String REDIRECT_URL = "/oauth2callback";

  public static String buildRedirectUri(HttpServletRequest req) {
    GenericUrl url = new GenericUrl(req.getRequestURL().toString());
    url.setRawPath(REDIRECT_URL);
    return url.build();
  }

  public static GoogleAuthorizationCodeFlow buildFlow() {
    return new GoogleAuthorizationCodeFlow.Builder(
        new NetHttpTransport(),
        JacksonFactory.getDefaultInstance(), CLIENT_ID, SECRET, SCOPES)
        .setAccessType("online")
        .build();
  }
}
