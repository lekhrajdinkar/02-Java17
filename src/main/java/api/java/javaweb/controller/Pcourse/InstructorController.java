package api.java.javaweb.controller.Pcourse;

import api.java.javaweb.DTO.Pcourse.CourseDTO;
import api.java.javaweb.DTO.Pcourse.mapper.CourseMapper;
import api.java.javaweb.model.Pcourse.Course;
import api.java.javaweb.model.Pcourse.Instructor;
import api.java.javaweb.srv.Pcourse.CategorySrv;
import api.java.javaweb.srv.Pcourse.CourseSrv;
import api.java.javaweb.srv.Pcourse.InstructorSrv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstructorController
{

    Logger logger = LoggerFactory.getLogger(InstructorController.class);
    
    @Autowired
    InstructorSrv srv;

    //@Override
    @GetMapping("inst/find-all")
    public List<Instructor> findAll() {
        logger.debug("CourseController :: findAll");
        return srv.findAll();
    }

    //@Override
    @GetMapping("inst/findById/{id}")
    public Instructor findById(@PathVariable Long id) {
        logger.debug("CourseController :: findById");
        return srv.findById(id);
    }

    //@Override
    @PostMapping("inst/save")
    public Long save(@RequestBody Instructor model) {
        logger.debug("CourseController :: save");
        return srv.save(model);
    }
}
