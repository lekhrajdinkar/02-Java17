package api.java.javaweb.srv.Pcourse;

import api.java.javaweb.DAO.Pcourse.CourseDAO;
import api.java.javaweb.DAO.Pcourse.InstructorDAO;
import api.java.javaweb.model.Pcourse.Course;
import api.java.javaweb.model.Pcourse.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InstructorSrvImpl implements InstructorSrv
{
    @Autowired
    InstructorDAO dao;


    @Override
    public List<Instructor> findAll() {
        return dao.findAll();
    }

    @Override
    public Instructor findById(Long aLong) {
        return dao.findById(aLong).get();
    }

    @Override
    public Long save(Instructor instructor) {
         dao.save(instructor);
        return instructor.getId();
    }

    @Override
    public Instructor update(Instructor instructor) {
        return dao.save(instructor);
    }

    @Override
    public Instructor delete(Instructor instructor) {
         dao.delete(instructor);
         return instructor;
    }
}