package api.java.javaweb.DAO.Pcourse;

import api.java.javaweb.model.Pcourse.Course;
import api.java.javaweb.model.Pcourse.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorDAO extends JpaRepository<Instructor,Long> {
}

