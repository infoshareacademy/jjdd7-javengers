package com.infoshareacademy.dto;

import java.util.ArrayList;
import java.util.List;

public class IngredientMeasureDto {

  private Long id;
  private String measure;
  private List<IngredientDto> ingredients = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMeasure() {
    return measure;
  }

  public void setMeasure(String measure) {
    this.measure = measure;
  }

  public List<IngredientDto> getIngredients() {
    return ingredients;
  }

  public void setIngredients(List<IngredientDto> ingredients) {
    this.ingredients = ingredients;
  }
}
