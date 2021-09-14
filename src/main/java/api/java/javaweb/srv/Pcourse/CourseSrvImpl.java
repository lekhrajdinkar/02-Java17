package api.java.javaweb.srv.Pcourse;

import api.java.javaweb.DAO.Pcourse.CategoryDAO;
import api.java.javaweb.DAO.Pcourse.CourseDAO;
import api.java.javaweb.model.Pcourse.Category;
import api.java.javaweb.model.Pcourse.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseSrvImpl implements CourseSrv
{
    @Autowired
    CourseDAO dao;

    @Override
    public List<Course> findAll() {
        return dao.findAll();
    }

    @Override
    public Course findById(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public Long save(Course course) {
         dao.save(course);
         return course.getId();
    }

    @Override
    public Course update(Course course) {
        save(course);
        return course;
    }

    @Override
    public Course delete(Course course) {
        dao.delete(course);
        return course;
    }
}
