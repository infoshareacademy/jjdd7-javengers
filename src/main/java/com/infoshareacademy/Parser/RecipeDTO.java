package com.infoshareacademy.Parser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.HashMap;
import java.util.Map;

//substract needed "fields" from @JsonIgnoreProperties below:
@JsonIgnoreProperties({"strDrinkAlternate", "strDrinkES", "strDrinkDE", "strDrinkFR", "strDrinkZH-HANS", "strDrinkZH-HANT", "strTags", "strVideo", "strIBA", "strAlcoholic",  "strInstructionsES", "strInstructionsDE", "strInstructionsFR", "strInstructionsZH-HANS", "strInstructionsZH-HANT", "strDrinkThumb", "strCreativeCommonsConfirmed"})
@JsonDeserialize(using = MapperStringStringDeserializer.class)

// classes for parser need to be pojo classes --> add geter and setter for each field!!
public class RecipeDTO {

    /// here goes each needed class field

    //if name of fields in class differs from the one in the file to be parsed
    @JsonProperty("idDrink")
    private int id;
    @JsonProperty("strDrink")
    private String name;
    @JsonProperty("strInstructions")
    private String instruction;
    @JsonProperty("strCategory")
    private String recipeCategory;
    @JsonProperty("strGlass")
    private String glassType;
    @JsonProperty("dateModified")
    private String modificationDate;

    //had to create a new map object to fill it with @JsonDeserialize
    private Map<String, String> ingredients = new HashMap<>();

    /// here goes each setter and getter

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

    //override to string with alt+x after class is ready

    @Override
    public String toString() {
        return "RecipeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", instruction='" + instruction + '\'' +
                ", recipeCategory='" + recipeCategory + '\'' +
                ", glassType='" + glassType + '\'' +
                ", modificationDate='" + modificationDate + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}


