package com.infoshareacademy.service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataConvertToJsonService {

    public static <T> Object parseJsonToFile(T obj, String jsonFilePath) {

        T outputObject = null;

        ObjectMapper mapper = new ObjectMapper();

        try {
            Map<String, Object> drinks = new HashMap<>();
            drinks.put("drinks", obj);
            mapper.writeValue(new File(jsonFilePath), drinks);
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

