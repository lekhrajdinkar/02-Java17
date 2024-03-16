package web.srv.Pcourse;

import web.DTO.Pcourse.CourseDTO;
import web.model.Pcourse.Course;

import java.util.List;

public interface CourseSrv  extends BaseSrv<Course, Long>{
    public List<CourseDTO> findAllDto();
}
