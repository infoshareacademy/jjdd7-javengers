package com.infoshareacademy.domain.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum DrinkType {
    ALCOHOLIC("alcoholic"),
    NON_ALCOHOLIC("non alcoholic"),
    OPTIONAL_ALCOHOL("optional alcohol");
    private String drinkType;

    DrinkType(String drinkType) {
        this.drinkType = drinkType;
    }

    public String getDrinkType() {
        return drinkType;
    }

    @JsonCreator
    public static DrinkType deserialize(@JsonProperty("strAlcoholic") String drinkType) {
        for (int i = 0; i < DrinkType.values().length; i++) {
            if (DrinkType.values()[i].getDrinkType().equals(drinkType)) {
                return DrinkType.values()[i];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "DrinkType{" +
                "drinkType='" + drinkType + '\'' +
                '}';
    }
}
