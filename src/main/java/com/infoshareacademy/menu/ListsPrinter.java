package com.infoshareacademy.menu;

import com.github.freva.asciitable.AsciiTable;
import com.github.freva.asciitable.Column;
import com.infoshareacademy.domain.Recipe;
import org.apache.commons.text.WordUtils;


import java.util.*;

import static com.github.freva.asciitable.HorizontalAlign.CENTER;


public class ListsPrinter {

    public void printCategory(List<String> recipeList) {

        Iterator iterator = recipeList.iterator();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> CATEGORIES <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
        while (iterator.hasNext()) {
            System.out.println("\t\t\t\t" + iterator.next());
        }
    }

    public void printAllRecipes(List<Recipe> recipeList/*, int beginningIndex, int endingIndex*/) {

        Character[] borderStyle = AsciiTable.NO_BORDERS;
        System.out.println(AsciiTable.getTable(borderStyle, recipeList, Arrays.asList(
                new Column().header("   DRINK NAME   ").headerAlign(CENTER).dataAlign(CENTER).with(recipe -> recipe.getName()),
                new Column().header("    CATEGORY    ").headerAlign(CENTER).dataAlign(CENTER).with(recipe -> recipe.getRecipeCategory()),
                new Column().header("      TYPE      ").headerAlign(CENTER).dataAlign(CENTER).with(recipe -> recipe.getAlcoholic()))));

    }

    public void printRecipe(List<Recipe> recipeList) {

            for (Recipe recipe:recipeList) {
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> DRINK NAME <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
                System.out.println("\t\t\t\t" + recipe.getName() + "\n");
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> CATEGORY <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
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
                System.out.println();
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ALCOHOLIC <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
                System.out.println("\t\t\t\t" + recipe.getAlcoholic() + "\n");
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>> TYPE OF GLASS <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
                System.out.println("\t\t\t\t" + recipe.getGlassType() + "\n");
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
                System.out.println("Modification date: " + recipe.getModificationDate());
                System.out.println("\n\n");
            }

    }
}
