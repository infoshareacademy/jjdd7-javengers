package com.infoshareacademy.Parser;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Parser {

    public static void main(String[] args) {

        //ParserTest parserTest = new ParserTest();

        //parseFile("/home/andrzejszypulski/javengers/jjdd7-javengers/src/main/resources/drinks.json", ParserTest.class);

        parseFile("/home/andrzejszypulski/javengers/jjdd7-javengers/src/main/resources/drinks.json", ArrayParserTest.class);

        //System.out.println(parserTest.getStrDrink());
        System.out.println();

    }

    //z pliku ujebalem poczatkowa i koncowa klamre bo mi sie parser wykrzaczal - moze mozna to jakos obejsc??
    //Czy ma zwracac voida czy jednak jakiegos returna??
    public static <T>Object parseFile(String parsedFilePath, Class<T> classToCampare) {


        T outputObject = null;

        ObjectMapper mapper = new ObjectMapper();
        try {
            outputObject = mapper.readValue(new File(parsedFilePath), classToCampare);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(outputObject);
    return outputObject;
    }


}
