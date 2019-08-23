package com.infoshareacademy.service;

import com.infoshareacademy.properties.AppConfig;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;

public class MatureVerifier {


    private static String ADULTS_SESSION_TIME = AppConfig.adultAccessSession;




    public static boolean isAlreadyCheckedAndMature() {
        if (new File("test.json").exists()) {
            SessionTimeDTO sessionTimeDTO = DataParseService
                    .parseFile("test.json", SessionTimeDTO.class);
            Duration duration = Duration.between(sessionTimeDTO.getPreviousSessionStartTime(), LocalDateTime.now());
            Long adultSession = Long.parseLong(ADULTS_SESSION_TIME);
            return sessionTimeDTO != null && duration.toSeconds() < adultSession;
        }
        return false;
    }

    public static void setMature() {
        SessionTimeDTO sessionTimeDTO =new SessionTimeDTO();
        sessionTimeDTO.setPreviousSessionStartTime(LocalDateTime.now());
        DataParseToJsonService.parseJsonToFile(sessionTimeDTO , "test.json");
    }
}
