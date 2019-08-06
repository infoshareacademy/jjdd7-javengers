package com.infoshareacademy.Parser;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"drinks","firstName", "strDrinkAlternate","strDrinkES","strDrinkDE","strDrinkFR","strDrinkZH-HANS","strDrinkZH-HANT","strTags","strVideo","strCategory","strIBA","strAlcoholic","strGlass","strInstructions","strInstructionsES","strInstructionsDE","strInstructionsFR","strInstructionsZH-HANS","strInstructionsZH-HANT","strDrinkThumb","strIngredient1","strIngredient2","strIngredient3","strIngredient4","strIngredient5","strIngredient6","strIngredient7","strIngredient8","strIngredient9","strIngredient10","strIngredient11","strIngredient12","strIngredient13","strIngredient14","strIngredient15","strMeasure1","strMeasure2","strMeasure3","strMeasure4","strMeasure5","strMeasure6","strMeasure7","strMeasure8","strMeasure9","strMeasure10","strMeasure11","strMeasure12","strMeasure13","strMeasure14","strMeasure15","strCreativeCommonsConfirmed","dateModified"})


public class ParserTest {
    private String idDrink;
    private String strDrink;

    public String getIdDrink() {
        return idDrink;
    }

    public String getStrDrink() {
        return strDrink;
    }

    public void setIdDrink(String idDrink) {
        this.idDrink = idDrink;
    }

    public void setStrDrink(String strDrink) {
        this.strDrink = strDrink;
    }

    public ParserTest() {

    }

    public ParserTest(String idDrink, String strDrink) {
        this.idDrink = idDrink;
        this.strDrink = strDrink;
    }
}


