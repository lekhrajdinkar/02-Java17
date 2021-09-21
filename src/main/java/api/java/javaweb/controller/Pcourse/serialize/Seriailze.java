package api.java.javaweb.controller.Pcourse.serialize;

import api.java.javaweb.DTO.Pcourse.CategoryDTO;
import api.java.javaweb.DTO.Pcourse.CourseDTO;
import appEnum.CatLevel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Seriailze {
    public static void main(String[] s) throws JsonProcessingException {
        //make DTO
        CourseDTO c1 = CourseDTO.builder().id(100L).title("c1").desc("c1-desc").instructorId(100L).categoryId(100L).build();
        CourseDTO c2 = CourseDTO.builder().id(200L).title("c2").desc("c2-desc").instructorId(100L).categoryId(100L).build();
        CourseDTO c3 = CourseDTO.builder().id(300L).title("c3").desc("c3-desc").instructorId(100L).categoryId(100L).build();

        List courses = List.of(c1,c2,c3);

        Map courseMap = Map.of("NOVICE", courses,"SEMI-PRO", courses, "PRO", courses);

        CategoryDTO dto = CategoryDTO.builder()
                .id(100L)
                .level(CatLevel.NOVICE)
                .desc("REST API deserialization")
                .title("REST")
                .localDate(LocalDate.now())
                //.courses(courses)
                //.coursesMap(courseMap)
                .build();

        //System.out.println(dto);

        //Serialize
        String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(dto);

        System.out.println(json);



    }
}
