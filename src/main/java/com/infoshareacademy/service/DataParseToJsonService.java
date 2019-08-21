package com.infoshareacademy.service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DataParseToJsonService {

    public static <T> Object parseJsonToFile(T obj, String jsonFilePath) { //TODO create jsonNode

        T outputObject = null;

        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File(jsonFilePath), obj);
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

