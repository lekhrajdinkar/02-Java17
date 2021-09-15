package api.java.javaweb.controller.Pcourse;

import api.java.javaweb.model.Pcourse.Instructor;
import api.java.javaweb.model.Pcourse.Student;
import api.java.javaweb.srv.Pcourse.InstructorSrv;
import api.java.javaweb.srv.Pcourse.StudentSrv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController
{

    Logger logger = LoggerFactory.getLogger(StudentController.class);
    
    @Autowired StudentSrv srv;

    //@Override
    @GetMapping("student/find-all")
    public List<Student> findAll() {
        logger.debug("StudentController :: findAll");
        return srv.findAll();
    }

    //@Override
    @GetMapping("student/findById/{id}")
    public Student findById(@PathVariable Long id) {
        logger.debug("StudentController :: findById");
        return srv.findById(id);
    }

    //@Override
    @PostMapping("student/save")
    public Long save(@RequestBody Student model) {
        logger.debug("StudentController :: save");
        return srv.save(model);
    }
}
