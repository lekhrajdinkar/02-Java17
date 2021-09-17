package api.java.javaweb.DAO.Pcourse;

import api.java.javaweb.model.Pcourse.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDAO extends JpaRepository<Category,Long> {


}

