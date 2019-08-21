package com.infoshareacademy.service;

import com.infoshareacademy.properties.AppConfig;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MatureVerifier {

    private static String DATE_FORMATTER = AppConfig.dateFormat;


    public static String createActualDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(formatter);
    }

    public static void verifyDate() {
        SessionTimeLoader sessionTimeLoader = DataParseService.parseFile("test.json", SessionTimeLoader.class);

        if (sessionTimeLoader == null) {
            System.out.println("Nie znaleziono daty");
            sessionTimeLoader = new SessionTimeLoader();
            sessionTimeLoader.setPreviousSessionStartTime(createActualDate());
            DataParseToJsonService.parseJsonToFile(sessionTimeLoader, "test.json");
            System.out.println("zapisano nowe dane");
        } else {
            System.out.println("Zapisana data: " + sessionTimeLoader.getPreviousSessionStartTime());
        }

    }

}
