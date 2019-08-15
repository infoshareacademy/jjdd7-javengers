package com.infoshareacademy.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {


    public static void main(String[] args) {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        String recipeSortType = propertiesLoader.getProperty( PropertiesLoader.RECIPE_SORT_TYPE_KEY );
        String recipeModificationDate = propertiesLoader.getProperty( PropertiesLoader.MODIFICATION_DATE_FORMAT_KEY );
        String durationOfSaveInSeconds = propertiesLoader.getProperty( PropertiesLoader.SAVE_DURATION_IN_SECONDS_KEY );
        System.out.println( recipeSortType + " " + recipeModificationDate + " " + durationOfSaveInSeconds );
    }

    public static final String RECIPE_SORT_TYPE_KEY = "recipe.sort.type";
    public static final String MODIFICATION_DATE_FORMAT_KEY = "modification.date.format";
    public static final String SAVE_DURATION_IN_SECONDS_KEY = "save.duration.in.seconds";

    private Properties prop = null;

    public String getProperty(String key) {
        if (prop == null) {
            loadProperties();
        }
        return prop.getProperty( key );
    }

    private void loadProperties() {
        try (InputStream input
                     = new FileInputStream( "./config.properties" )) {

            if (input == null) {
                System.out.println( "Sorry, unable to find config.properties" );
                return;
            }
            prop = new Properties();
            prop.load( input );

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
