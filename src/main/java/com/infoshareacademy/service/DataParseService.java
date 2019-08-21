package com.infoshareacademy.service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class    DataParseService {

    public static <T> Object parseFile(String jsonFilePath, TypeReference<T> classToCampare, String upperNodeName) {

        T outputObject = null;

        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode jsonNode = mapper.readTree(new File(jsonFilePath));
            outputObject = mapper.readValue(jsonNode.get(upperNodeName).toString(), classToCampare);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputObject;
    }

    public static <T> T parseFile(String jsonFilePath, Class<T> classToCampare) {

        T outputObject = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            //JSON file to Java object
            outputObject = mapper.readValue(new File(jsonFilePath), classToCampare);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputObject;
    }
}

