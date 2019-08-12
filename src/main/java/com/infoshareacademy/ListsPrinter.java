package com.infoshareacademy;

import org.apache.commons.lang3.text.WordUtils;

import java.util.*;

public class ListsPrinter {

    void printCategory(Set<String> recipeList) {
        Iterator iterator = recipeList.iterator();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> CATEGORIES <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
        while (iterator.hasNext()) {
            System.out.println("\t\t\t\t" + iterator.next());
        }
    }

    void printAllRecipes(List<RecipeDTO> recipeList) {
        for (RecipeDTO recipe : recipeList
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
