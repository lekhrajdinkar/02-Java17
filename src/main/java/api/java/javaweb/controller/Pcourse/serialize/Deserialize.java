package api.java.javaweb.controller.Pcourse.serialize;

import api.java.javaweb.DTO.Pcourse.CategoryDTO;
import api.java.javaweb.DTO.Pcourse.CourseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Type;
import java.util.Map;

public class Deserialize {
    public static void main(String a[]) throws JsonProcessingException {
        //  Unmarshall an Incomplete JSON
        String json =  "{\"id\":1,\"title2\":\"category-test\",\"localDate\":\"2020\"}"; //Unrecognized field "title2"

        CategoryDTO dto = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false) // if we pass title3, it will fail
                .readerFor(CategoryDTO.class)
                .readValue(json);

        System.out.println(dto);


        // JsonNode
        //a JSON can be parsed into a JsonNode object and used to retrieve data from a specific node:
        JsonNode node = new ObjectMapper().readTree(json);
        node.get("title2");
        System.out.println(node);
        System.out.println(node.get("title2"));

        // Convert into Map
        Map map = new ObjectMapper().readValue(json, new TypeReference<Map>() {});
        System.out.println(map);

        // Convert into List
        // https://www.baeldung.com/jackson-object-mapper-tutorial
    }
}
