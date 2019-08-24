package com.infoshareacademy.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.infoshareacademy.mappers.RecipeListDeserializer;
import com.infoshareacademy.mappers.RecipeListSerializer;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties({"strDrinkAlternate", "strDrinkES", "strDrinkDE", "strDrinkFR",
        "strDrinkZH-HANS", "strDrinkZH-HANT", "strTags", "strVideo", "strIBA",
        "strInstructionsES", "strInstructionsDE", "strInstructionsFR", "strInstructionsZH-HANS",
        "strInstructionsZH-HANT", "strDrinkThumb", "strCreativeCommonsConfirmed"})
@JsonDeserialize(using = RecipeListDeserializer.class)
@JsonSerialize(using = RecipeListSerializer.class)

public class Recipe {


    @JsonProperty("idDrink")
    private int id;
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

    private Map<String, String> ingredients = new HashMap<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", instruction='" + instruction + '\'' +
                ", recipeCategory='" + recipeCategory + '\'' +
                ", drinkType='" + drinkType + '\'' +
                ", glassType='" + glassType + '\'' +
                ", modificationDate='" + modificationDate + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}



