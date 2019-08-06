package com.infoshareacademy.Parser;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Parser {

    public static void main(String[] args) {
        ParserTest parserTest = null;
        parseFile("/home/andrzej/javengers/jjdd7-javengers/src/main/resources/drinks.json", parserTest);

    }
    //z pliku ujebalem poczatkowa i koncowa klamre bo mi sie parser wykrzaczal - moze mozna to jakos obejsc??
    //Czy ma zwracac voida czy jednak jakiegos returna??
    public static void parseFile(String parsedFilePath, Object outputObject) {
        outputObject = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            outputObject = mapper.readValue(new File(parsedFilePath), ParserTest.class);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(outputObject);
    }


}
