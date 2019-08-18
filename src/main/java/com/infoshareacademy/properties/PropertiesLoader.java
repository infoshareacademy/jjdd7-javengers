package com.infoshareacademy.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {


  public static void main(String[] args) {
    PropertiesLoader propertiesLoader = new PropertiesLoader();
    String recipeSortType = propertiesLoader
        .getProperty(PropertiesLoader.RECIPE_SORT_TYPE_KEY, "ASC");
    String recipeModificationDate = propertiesLoader
        .getProperty(PropertiesLoader.MODIFICATION_DATE_FORMAT_KEY, "yyyy-MM-dd HH:mm:ss");
    String durationOfSaveInSeconds = propertiesLoader
        .getProperty(PropertiesLoader.SAVE_DURATION_IN_SECONDS_KEY, "180");
    System.out
        .println(recipeSortType + " " + recipeModificationDate + " " + durationOfSaveInSeconds);
  }

  public static final String RECIPE_SORT_TYPE_KEY = "recipe.sort.type";
  public static final String MODIFICATION_DATE_FORMAT_KEY = "date.format";
  public static final String SAVE_DURATION_IN_SECONDS_KEY = "adult.access.session.duration";

  private Properties prop = null;


  public String getProperty(String key, String defaultValue) {
    String result = null;
    if (prop == null) {
      loadProperties();
    }
    if (prop.getProperty(key) == null) {
      System.out.println(
          "Wrong key: " + key + " in config file!  " + "\n" + "Set new default value: "
              + defaultValue);
      result = prop.getProperty(key, defaultValue);

    } else {
      result = prop.getProperty(key);
    }

    return result;
  }


  private void loadProperties() {
    try (InputStream input
        = new FileInputStream("./config.properties")) {

      if (input == null) {
        System.out.println("Sorry, unable to find config.properties");
        return;
      }
      prop = new Properties();
      prop.load(input);

    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}


