package com.infoshareacademy.Parser;
import java.io.File;
import java.io.IOException;
import java.util.Date;


import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Parser {

    public static void main(String[] args)
    {
        ParserTest drink = null;
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            drink =  mapper.readValue(new File("/home/andrzej/javengers/jjdd7-javengers/src/main/resources/drinks.json"), ParserTest.class);
        } catch (JsonGenerationException e)
        {
            e.printStackTrace();
        } catch (JsonMappingException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println(drink);
    }


}
