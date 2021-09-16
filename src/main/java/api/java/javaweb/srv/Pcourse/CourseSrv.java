package api.java.javaweb.srv.Pcourse;

import api.java.javaweb.DTO.Pcourse.CourseDTO;
import api.java.javaweb.model.Pcourse.Category;
import api.java.javaweb.model.Pcourse.Course;

import java.util.List;

public interface CourseSrv  extends BaseSrv<Course, Long>{
    public List<CourseDTO> findAllDto();
}
