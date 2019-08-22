package com.infoshareacademy.service;

import java.time.LocalDateTime;

public class SessionTimeLoader {

    private String previousSessionStartTime;

    public String getPreviousSessionStartTime() {
        return previousSessionStartTime;
    }

    public void setPreviousSessionStartTime(String previousSessionStartTime) {
        this.previousSessionStartTime = previousSessionStartTime;
    }
}
