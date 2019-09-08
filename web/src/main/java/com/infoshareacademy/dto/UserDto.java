package com.infoshareacademy.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDto {

  private Long id;
  private String name;
  private String surname;
  private String userType;
  private String login;
  private String password;
  private List<RecipeDto> recipes = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<RecipeDto> getRecipes() {
    return recipes;
  }

  public void setRecipes(List<RecipeDto> recipes) {
    this.recipes = recipes;
  }
}
