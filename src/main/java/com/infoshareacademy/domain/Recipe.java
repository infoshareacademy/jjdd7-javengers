package com.infoshareacademy.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.infoshareacademy.RecipeListDeserializer;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties({"strDrinkAlternate", "strDrinkES", "strDrinkDE", "strDrinkFR",
        "strDrinkZH-HANS", "strDrinkZH-HANT", "strTags", "strVideo", "strIBA",
        "strInstructionsES", "strInstructionsDE", "strInstructionsFR", "strInstructionsZH-HANS",
        "strInstructionsZH-HANT", "strDrinkThumb", "strCreativeCommonsConfirmed"})
@JsonDeserialize(using = RecipeListDeserializer.class)

public class Recipe {


    private int id;

    private String name;

    private String instruction;

    private String recipeCategory;
<<<<<<< HEAD

=======
    @JsonProperty("strAlcoholic")
    private String drinkType;
    @JsonProperty("strGlass")
>>>>>>> 2913ca4584ca45c10232f5c7065369d58d106255
    private String glassType;

    private String modificationDate;

    private String alcoholic;

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

    public String getRecipeCategory() { return recipeCategory; }

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

<<<<<<< HEAD
    public String getAlcoholic() { return alcoholic; }

    public void setAlcoholic(String alcoholic) { this.alcoholic = alcoholic; }


=======
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
>>>>>>> 2913ca4584ca45c10232f5c7065369d58d106255
}


