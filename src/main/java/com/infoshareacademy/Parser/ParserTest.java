package com.infoshareacademy.Parser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.HashMap;
import java.util.Map;

//substract needed "fields" from @JsonIgnoreProperties below:
@JsonIgnoreProperties({"strDrinkAlternate", "strDrinkES", "strDrinkDE", "strDrinkFR", "strDrinkZH-HANS", "strDrinkZH-HANT", "strTags", "strVideo", "strCategory", "strIBA", "strAlcoholic", "strGlass", "strInstructions", "strInstructionsES", "strInstructionsDE", "strInstructionsFR", "strInstructionsZH-HANS", "strInstructionsZH-HANT", "strDrinkThumb", "strCreativeCommonsConfirmed", "dateModified"})
@JsonDeserialize(using = MapperStringStringDeserializer.class)

// classes for parser need to be pojo classes --> add geter and setter for each field!!
public class ParserTest {

    /// here goes each needed class field

    //if name of fields in class differs from the one in the file to be parsed
    @JsonProperty("idDrink")
    private String id;

    //if same, leave as it is
    private String strDrink;

    //had to create a new map object to fill it with @JsonDeserialize
    private Map<String, String> ingredients = new HashMap<>();


    /// here goes each setter and getter


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStrDrink() {
        return strDrink;
    }

    public void setStrDrink(String strDrink) {
        this.strDrink = strDrink;
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
        return "ParserTest{" +
                "id='" + id + '\'' +
                ", strDrink='" + strDrink + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}


