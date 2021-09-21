package api.java.javaweb.DTO.Pcourse;

import api.java.javaweb.controller.Pcourse.serialize.LocalDateSerializer;
import api.java.javaweb.model.Pcourse.Course;
import appEnum.CatLevel;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder


@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({ "title", "desc","id" }) //2. ordering
@JsonRootName(value="COURSE_ROOT")
//@JsonPropertyOrder(alphabetic=true) //2. ordering

public class CategoryDTO {
    @JsonProperty
    Long id;

    @JsonProperty CatLevel level;

    @JsonProperty
    @JsonRawValue
    String title;

    @JsonProperty
    String desc;

    @JsonProperty
    List<Course> courses;

    @JsonProperty
    @JsonAnyGetter //1.Expand map
    Map<String, List<Course>> coursesMap; // <level, >

    @JsonProperty
    @JsonSerialize(using = LocalDateSerializer.class) // Custom
    LocalDate localDate; //= LocalDate.now();

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", courses=" + courses.stream().collect(Collectors.toList())+
                '}';
    }

    // 3. @JsonValue indicates a single method that the library will use to serialize the entire instance.
//    @JsonValue
//    String getValue(){
//        return String.valueOf(this.hashCode());
//    }
}


