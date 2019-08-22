package com.infoshareacademy.service;

import com.infoshareacademy.menu.ChoiceReader;
import com.infoshareacademy.properties.AppConfig;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MatureVerifier {

  private static String DATE_FORMATTER = AppConfig.dateFormat;
  private static String ADULTS_SESSION_TIME = AppConfig.adultAccessSession;




  public static String createActualDateTime() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
    LocalDateTime localDateTime = LocalDateTime.now();
    return localDateTime.format(formatter);
  }

    public static String readDateTimetoJson() {
      SessionTimeLoader sessionTimeLoader = DataParseService
          .parseFile("test.json", SessionTimeLoader.class);
      if (sessionTimeLoader == null) {
        sessionTimeLoader = new SessionTimeLoader();
        sessionTimeLoader.setPreviousSessionStartTime(createActualDateTime());
        DataParseToJsonService.parseJsonToFile(sessionTimeLoader, "test.json");
        System.out.println("zapisano nową dane");
      } else {
        System.out.println("Zapisana data: " + sessionTimeLoader.getPreviousSessionStartTime());
      }
      return sessionTimeLoader.getPreviousSessionStartTime();
    }


  public static Long getDateBetweenSessions(){

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
    LocalDateTime initialTime = LocalDateTime
        .parse(MatureVerifier.readDateTimetoJson(), formatter);
    LocalDateTime endTime = LocalDateTime
        .parse(createActualDateTime(), formatter);
    Duration duration = Duration.between(initialTime, endTime);
    return duration.toSeconds();
  }

  public static void printConfirmMature(){
    Long adultSessionAccessTime = Long.parseLong(ADULTS_SESSION_TIME);
    ChoiceReader choiceReader = new ChoiceReader();
    if(getDateBetweenSessions() > adultSessionAccessTime){
      choiceReader.confirmMature();
      
    }
    else{
      System.out.println("Pokaż widok ");
    }
  }

}
