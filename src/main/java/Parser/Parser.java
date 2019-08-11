package Parser;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Parser {

    public static void main(String[] args) {
        parseFile("/home/kzarychta/Desktop/java-course/jjdd7-javengers/src/main/resources/drinks.json", DrinksDefaultApiArray.class);
    }

    public static <T>Object parseFile(String jsonFilePath, Class<T> classToCampare) {


        T outputObject = null;

        ObjectMapper mapper = new ObjectMapper();
        try {
            outputObject = mapper.readValue(new File(jsonFilePath), classToCampare);
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
