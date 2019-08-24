package com.infoshareacademy.menu;

import com.github.freva.asciitable.AsciiTable;
import com.github.freva.asciitable.Column;
import com.github.freva.asciitable.ColumnData;
import com.github.freva.asciitable.HorizontalAlign;
import com.infoshareacademy.domain.Recipe;
import org.apache.commons.text.WordUtils;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;

import static com.github.freva.asciitable.HorizontalAlign.CENTER;


public class ListsPrinter {

    public void printCategory(List<String> categoryList) {

        Character[] borderStyle = AsciiTable.NO_BORDERS;
        System.out.println(AsciiTable.getTable(borderStyle, categoryList, Arrays.asList(
                createColumnString("    LIST No     ",category -> "0"+ categoryList.indexOf(category)),
                createColumnString("    CATEGORY    ",category-> categoryList.get(categoryList.indexOf(category))))));
    }

    public void printAllRecipes(List<Recipe> recipeList) {

        Character[] borderStyle = AsciiTable.NO_BORDERS;
        System.out.println(AsciiTable.getTable(borderStyle, recipeList, Arrays.asList(
                createColumn("    LIST No     ",recipe -> "0"+ recipeList.indexOf(recipe)),
                createColumn("   DRINK NAME   ",Recipe::getName),
                createColumn("    CATEGORY    ",Recipe::getRecipeCategory),
                createColumn("      TYPE      ",Recipe::getDrinkType)))
                /* tutaj jeszcze rozkminiam, nie kasowac komenta!
                ,createColumn("   INGREDIENTS  ",recipe -> String.valueOf((recipe.getIngredients().keySet())))*/);

    }

    public void printRecipe(List<Recipe> recipeList) {

            for (Recipe recipe:recipeList) {
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ID <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
                System.out.println("\t\t\t\t" + recipeList.indexOf(recipe) + "\n");
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
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> TYPE <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
                System.out.println("\t\t\t\t" + recipe.getDrinkType() + "\n");
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>> TYPE OF GLASS <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
                System.out.println("\t\t\t\t" + recipe.getGlassType() + "\n");
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
                System.out.println("Modification date: " + recipe.getModificationDate());
                System.out.println("\n\n");
            }

    }



    public void printImage() throws IOException {
        System.out.println(GraphicContentFromFile.getGraphic("graphic.txt", StandardCharsets.US_ASCII));
    }


    private ColumnData<Recipe> createColumn(String name, Function<Recipe, String> functionReference) {
        return new Column()
                .header(name)
                .headerAlign(HorizontalAlign.CENTER)
                .dataAlign(HorizontalAlign.CENTER)
                .with(functionReference);
    }

    private ColumnData<String> createColumnString(String name, Function<String, String> functionReference) {
        return new Column()
                .header(name)
                .headerAlign(HorizontalAlign.CENTER)
                .dataAlign(HorizontalAlign.CENTER)
                .with(functionReference);
    }

}
