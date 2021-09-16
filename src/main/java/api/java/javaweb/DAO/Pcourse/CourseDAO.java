package api.java.javaweb.DAO.Pcourse;

import api.java.javaweb.model.Pcourse.Category;
import api.java.javaweb.model.Pcourse.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
//@Transactional
public interface CourseDAO extends JpaRepository<Course,Long> {
}

