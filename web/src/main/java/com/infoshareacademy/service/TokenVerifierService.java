package com.infoshareacademy.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import java.util.Collections;
import javax.ejb.Stateless;

@Stateless
public class TokenVerifierService {

  private static final String GOOGLE_CLIENT_ID =
      "1037530492027-j033lgm76kc63lrkqpaus0sn25q00vj2.apps.googleusercontent.com";

  public Payload getPayload(String tokenString) throws Exception {

    GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier
        .Builder(new NetHttpTransport(), new JacksonFactory())
        .setAudience(Collections.singletonList(GOOGLE_CLIENT_ID))
        .build();

    GoogleIdToken idToken = verifier.verify(tokenString);
    if (idToken != null) {
      return idToken.getPayload();
    }
    throw new IllegalArgumentException("invalid token");
  }
}
