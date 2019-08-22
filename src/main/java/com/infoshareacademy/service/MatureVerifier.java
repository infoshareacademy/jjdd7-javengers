package com.infoshareacademy.service;

import com.infoshareacademy.properties.AppConfig;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MatureVerifier {

    private static String DATE_FORMATTER = AppConfig.dateFormat;
    private static String ADULTS_SESSION_TIME = AppConfig.adultAccessSession;


    private static SessionTimeLoader createActualDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        LocalDateTime localDateTime = LocalDateTime.now();
        return new SessionTimeLoader().setPreviousSessionStartTime(localDateTime);
    }

    public static boolean isAlreadyCheckedAndMature() {
      SessionTimeLoader sessionTimeLoader = DataParseService
              .parseFile("test.json", SessionTimeLoader.class);
      return sessionTimeLoader != null &&  sessionTimeLoader.getPreviousSessionStartTime()
    }

    public static void setMature() {
        DataParseToJsonService.parseJsonToFile(createActualDateTime(), "test.json");
    }

  /*public static void printConfirmMature(){
    Long adultSessionAccessTime = Long.parseLong(ADULTS_SESSION_TIME);
    ChoiceReader choiceReader = new ChoiceReader();
    if((getDateBetweenSessions() > adultSessionAccessTime) && (choiceReader.confirmMature() == true)){
      choiceReader.confirmMature();
    }
    else{
      System.out.println("Pokaż widok ");
    }*/
}


