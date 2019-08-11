package com.infoshareacademy;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListsPrinter {

    void printCategory(List<String> categoryList){
        Iterator<String> categoriesIterator = categoryList.iterator();
        while(categoriesIterator.hasNext()) {
            System.out.println(categoriesIterator.next());
        }
    }

    void printAllRecipes(List<RecipeDTO> recipeList){
        for (RecipeDTO recipe:recipeList
        ) {
            System.out.println(recipe.getName());
            System.out.println(recipe.getInstruction());
            Map<String,String> ingredients = recipe.getIngredients();
            Set<Map.Entry<String,String>> hashSet=ingredients.entrySet();
            for(Map.Entry entry:hashSet ) {
                System.out.println(entry.getKey()+ "\t\t"+ entry.getValue());
            }
        }
    }
}
