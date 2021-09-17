package api.java.javaweb.DAO.Pcourse;

import api.java.javaweb.model.Pcourse.Category;
import api.java.javaweb.model.Pcourse.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
//@Transactional
public interface CourseDAO extends JpaRepository<Course,Long> {

   // @Query("SELECT c FROM Course c")
    Optional<List<Course>> findByCategoryId(Long id);


}

