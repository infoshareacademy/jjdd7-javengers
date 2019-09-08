package com.infoshareacademy.dto;

import java.util.ArrayList;
import java.util.List;

public class DrinkTypeDto {

  private Long id;
  private String name;
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

  public List<RecipeDto> getRecipes() {
    return recipes;
  }

  public void setRecipes(List<RecipeDto> recipes) {
    this.recipes = recipes;
  }
}
