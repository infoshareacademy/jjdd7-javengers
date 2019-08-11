package Parser;

import java.util.ArrayList;

public class DrinksDefaultApiArray {

    //class Field
    private ArrayList<RecipeDTO> drinks;

    //getters & setters
    //if used for other text file need to change the line below!!
    public ArrayList<RecipeDTO> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<RecipeDTO> drinks) {
        this.drinks = drinks;
    }

    @Override
    public String toString() {
        return "ArrayParserTest{" +
                "drinks='" + drinks + '\'' +
                '}';
    }
}
