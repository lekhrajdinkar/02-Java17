package api.java.javaweb.DTO.Pcourse.mapper;

import api.java.javaweb.DTO.Pcourse.CourseDTO;
import api.java.javaweb.model.Pcourse.Course;

public class CourseMapper {
    public static CourseDTO model2Dto(Course model){
        return CourseDTO.builder()
                .desc(model.getDesc())
                .id(model.getId())
                .title(model.getTitle())
                .categoryId(model.getCategory().getId())
                .build();
    }

    public static Course dto2Model(CourseDTO dto){
        return Course.builder()
                .desc(dto.getDesc())
                //.id(dto.getId())
                .title(dto.getTitle())
                //.category(dto)
                .build();
    }
}
