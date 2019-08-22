package com.infoshareacademy.service;

import java.time.LocalDateTime;

public class SessionTimeLoader {

    private LocalDateTime previousSessionStartTime;

    public SessionTimeLoader() {
    }

    public SessionTimeLoader(LocalDateTime previousSessionStartTime) {
        this.previousSessionStartTime = previousSessionStartTime;
    }

    public LocalDateTime getPreviousSessionStartTime() {
        return previousSessionStartTime;
    }

    public void setPreviousSessionStartTime(LocalDateTime previousSessionStartTime) {
        this.previousSessionStartTime = previousSessionStartTime;
    }
}
