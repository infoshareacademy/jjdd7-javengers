package com.infoshareacademy.service;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.infoshareacademy.properties.AppConfig;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SessionTimeDTO {

  @JsonIgnore
  private LocalDateTime previousSessionStartTime;
  private static String DATE_FORMATTER = AppConfig.dateFormat;
  static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);

  private String dateTime;

  public SessionTimeDTO(LocalDateTime previousSessionStartTime) {
    this.previousSessionStartTime = previousSessionStartTime;
  }

  public SessionTimeDTO() {
  }

  public LocalDateTime getPreviousSessionStartTime() {
    return previousSessionStartTime;
  }

  public void setPreviousSessionStartTime(LocalDateTime previousSessionStartTime) {
    this.previousSessionStartTime = previousSessionStartTime;
  }

  @JsonGetter("localTime")
  public String getDateTime() {
    return previousSessionStartTime.format(formatter);
  }

  @JsonSetter("localTime")
  public void setDateTime(String dateTime) {
    this.dateTime = dateTime;
    previousSessionStartTime = LocalDateTime.parse(dateTime, formatter);
  }
}
