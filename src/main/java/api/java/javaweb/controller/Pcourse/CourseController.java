package api.java.javaweb.controller.Pcourse;

import api.java.javaweb.DTO.Pcourse.CourseDTO;
import api.java.javaweb.DTO.Pcourse.mapper.CourseMapper;
import api.java.javaweb.model.Pcourse.Course;
import api.java.javaweb.srv.Pcourse.CategorySrv;
import api.java.javaweb.srv.Pcourse.CourseSrv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController 
{

    Logger logger = LoggerFactory.getLogger(CourseController.class);
    
    @Autowired CourseSrv srv;
    @Autowired CategorySrv categorySrv;

    //@Override
    @GetMapping("course/find-all")
    public List<Course> findAll() {
        logger.debug("CourseController :: findAll");
        return srv.findAll();
    }

    //@Override
    @GetMapping("course/findById")
    public Course findById(Long id) {
        logger.debug("CourseController :: findById");
        return srv.findById(id);
    }

    //@Override
    @PostMapping("course/save")
    public Long save(@RequestBody CourseDTO dto) {
        logger.debug("CourseController :: save");

            Course c = CourseMapper.dto2Model(dto); //manual mapper, Todo: use mapStruct
            c.setCategory(categorySrv.findById(dto.getCategoryId())); // loading Category Entity manually from id.

        return srv.save(c);
    }
}