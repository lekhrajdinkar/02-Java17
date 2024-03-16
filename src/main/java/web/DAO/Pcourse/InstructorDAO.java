package web.DAO.Pcourse;

import web.model.Pcourse.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorDAO extends JpaRepository<Instructor,Long> {
}

