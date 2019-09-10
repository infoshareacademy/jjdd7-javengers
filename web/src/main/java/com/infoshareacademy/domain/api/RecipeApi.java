package com.infoshareacademy.domain.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.infoshareacademy.service.RecipeDeserializer;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties({"strDrinkAlternate", "strDrinkES", "strDrinkDE", "strDrinkFR",
    "strDrinkZH-HANS", "strDrinkZH-HANT", "strTags", "strVideo", "strIBA",
    "strInstructionsES", "strInstructionsDE", "strInstructionsFR", "strInstructionsZH-HANS",
    "strInstructionsZH-HANT", "strDrinkThumb", "strCreativeCommonsConfirmed"})
@JsonDeserialize(using = RecipeDeserializer.class)

public class RecipeApi {

  @JsonProperty("idDrink")
  private Long id;
  @JsonProperty("strDrink")
  private String name;
  @JsonProperty("strInstructions")
  private String instruction;
  @JsonProperty("strCategory")
  private String recipeCategory;
  @JsonProperty("strAlcoholic")
  private String drinkType;
  @JsonProperty("strGlass")
  private String glassType;
  @JsonProperty("dateModified")
  private String modificationDate;
  @JsonProperty("strDrinkThumb")
  private String imageUrl;

  private Map<String, String> ingredients = new HashMap<>();

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

  public String getInstruction() {
    return instruction;
  }

  public void setInstruction(String instruction) {
    this.instruction = instruction;
  }

  public String getRecipeCategory() {
    return recipeCategory;
  }

  public void setRecipeCategory(String recipeCategory) {
    this.recipeCategory = recipeCategory;
  }

  public String getDrinkType() {
    return drinkType;
  }

  public void setDrinkType(String drinkType) {
    this.drinkType = drinkType;
  }

  public String getGlassType() {
    return glassType;
  }

  public void setGlassType(String glassType) {
    this.glassType = glassType;
  }

  public String getModificationDate() {
    return modificationDate;
  }

  public void setModificationDate(String modificationDate) {
    this.modificationDate = modificationDate;
  }

  public Map<String, String> getIngredients() {
    return ingredients;
  }

  public void setIngredients(Map<String, String> ingredients) {
    this.ingredients = ingredients;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  @Override
  public String toString() {
    return "RecipeApi{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", instruction='" + instruction + '\'' +
        ", recipeCategory='" + recipeCategory + '\'' +
        ", drinkType='" + drinkType + '\'' +
        ", glassType='" + glassType + '\'' +
        ", modificationDate='" + modificationDate + '\'' +
        ", imageUrl='" + imageUrl + '\'' +
        ", ingredients=" + ingredients +
        '}';
  }
}


