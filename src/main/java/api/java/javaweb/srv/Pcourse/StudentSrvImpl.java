package api.java.javaweb.srv.Pcourse;

import api.java.javaweb.DAO.Pcourse.InstructorDAO;
import api.java.javaweb.DAO.Pcourse.StudentDAO;
import api.java.javaweb.model.Pcourse.Instructor;
import api.java.javaweb.model.Pcourse.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentSrvImpl implements StudentSrv
{
    @Autowired
    StudentDAO dao;


    @Override
    public List<Student> findAll() {
        return dao.findAll();
    }

    @Override
    public Student findById(Long aLong) {
        return dao.findById(aLong).get();
    }

    @Override
    public Long save(Student student) {
        return dao.save(student).getId();
    }

    @Override
    public Student update(Student student) {
        return dao.save(student);
    }

    @Override
    public Student delete(Student student) {
         dao.delete(student);
        return student;
    }
}