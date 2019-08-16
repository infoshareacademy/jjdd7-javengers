package com.infoshareacademy.menu;

import com.infoshareacademy.domain.Recipe;
import org.apache.commons.text.WordUtils;


import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListsPrinter {

    public void printCategory(List<String> recipeList) {

        Iterator iterator = recipeList.iterator();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> CATEGORIES <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
        while (iterator.hasNext()) {
            System.out.println("\t\t\t\t" + iterator.next());
        }
    }

    public void printAllRecipes(List<Recipe> recipeList) {
        for (Recipe recipe : recipeList
        ) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> DRINK NAME <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
            System.out.println("\t\t\t\t" + recipe.getName() + "\n");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> CATEGORY <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
            System.out.println("\t\t\t\t" + recipe.getRecipeCategory() + "\n");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>> RECIPE - INSTRUCTION <<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
            String instruction = recipe.getInstruction();
            String wrappedInstruction = WordUtils.wrap(instruction, 77);
            System.out.println(wrappedInstruction);
            System.out.println();
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> INGREDIENTS <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
            Map<String, String> ingredients = recipe.getIngredients();
            Set<Map.Entry<String, String>> hashSet = ingredients.entrySet();
            for (Map.Entry entry : hashSet) {
                System.out.println(String.format("%-15s\t\t\t\t%-20s", entry.getKey(), entry.getValue()));
            }
            System.out.println("\n\n");
        }
    }
}
