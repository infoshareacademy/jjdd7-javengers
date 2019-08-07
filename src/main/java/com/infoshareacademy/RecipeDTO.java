package com.infoshareacademy;

import java.util.Date;
import java.util.Map;

public class RecipeDTO {
    private int id;
    private String name;
    private String instruction;
    private String recipeCategory;
    private String glassType;
    private String measureType;
    private Date modificationDate;
    Map<String,String> ingredients;


    public RecipeDTO(int id, String name, String instruction, String recipeCategory, String glassType, String measureType, Date modificationDate) {
        this.id = id;
        this.name = name;
        this.instruction=instruction;
        this.recipeCategory =recipeCategory;
        this.glassType = glassType;
        this.measureType = measureType;
        this.modificationDate = modificationDate;
    }

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

    public String getMeasureType() {
        return measureType;
    }

    public void setMeasureType(String measureType) {
        this.measureType = measureType;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Map<String, String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<String, String> ingredients) {
        this.ingredients = ingredients;
    }
}

