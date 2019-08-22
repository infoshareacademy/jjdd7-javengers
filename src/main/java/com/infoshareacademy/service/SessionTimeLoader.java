package com.infoshareacademy.service;

public class SessionTimeLoader {

    private String previousSessionStartTime;

    public SessionTimeLoader() {
    }

    public SessionTimeLoader(String previousSessionStartTime) {
        this.previousSessionStartTime = previousSessionStartTime;
    }

    public String getPreviousSessionStartTime() {
        return previousSessionStartTime;
    }

    public void setPreviousSessionStartTime(String previousSessionStartTime) {
        this.previousSessionStartTime = previousSessionStartTime;
    }
}
