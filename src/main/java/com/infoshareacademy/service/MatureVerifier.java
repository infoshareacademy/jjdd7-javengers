package com.infoshareacademy.service;


import com.infoshareacademy.properties.AppConfig;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class MatureVerifier {
private static String DATE_FORMATTER = AppConfig.dateFormat;


  public String createActualDate() {
    String formatedActualDateTime = null;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
    LocalDateTime localDateTime = LocalDateTime.now();
    formatedActualDateTime = localDateTime.format(formatter);
    return formatedActualDateTime;
  }


}
