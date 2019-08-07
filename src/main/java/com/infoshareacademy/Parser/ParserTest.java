package com.infoshareacademy.Parser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"strDrinkAlternate", "strDrinkES", "strDrinkDE", "strDrinkFR", "strDrinkZH-HANS", "strDrinkZH-HANT", "strTags", "strVideo", "strCategory", "strIBA", "strAlcoholic", "strGlass", "strInstructions", "strInstructionsES", "strInstructionsDE", "strInstructionsFR", "strInstructionsZH-HANS", "strInstructionsZH-HANT", "strDrinkThumb", "strIngredient1", "strIngredient2", "strIngredient3", "strIngredient4", "strIngredient5", "strIngredient6", "strIngredient7", "strIngredient8", "strIngredient9", "strIngredient10", "strIngredient11", "strIngredient12", "strIngredient13", "strIngredient14", "strIngredient15", "strMeasure1", "strMeasure2", "strMeasure3", "strMeasure4", "strMeasure5", "strMeasure6", "strMeasure7", "strMeasure8", "strMeasure9", "strMeasure10", "strMeasure11", "strMeasure12", "strMeasure13", "strMeasure14", "strMeasure15", "strCreativeCommonsConfirmed", "dateModified"})

// klasy do parsera musza spelniac zasady pojo!!
public class ParserTest {

    @JsonProperty("idDrink")
    private String id;

    private String strDrink;

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

    @Override
    public String toString() {
        return "ParserTest{" +
                "id='" + id + '\'' +
                ", strDrink='" + strDrink + '\'' +
                '}';
    }
}


