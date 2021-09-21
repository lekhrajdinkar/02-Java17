package api.java.javaweb.controller.Pcourse.serialize;

import api.java.javaweb.DTO.Pcourse.CategoryDTO;
import api.java.javaweb.DTO.Pcourse.CourseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Deserialize {
    public static void main(String a[]) throws JsonProcessingException {
        String json =  "{\"id\":1,\"title2\":\"category-test\",\"localDate\":\"2020\"}"; //Unrecognized field "title2"

        CategoryDTO dto = new ObjectMapper()
                .readerFor(CategoryDTO.class)
                .readValue(json);

        System.out.println(dto);
    }
}
