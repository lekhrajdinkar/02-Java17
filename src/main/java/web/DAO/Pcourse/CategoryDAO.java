package web.DAO.Pcourse;

import web.model.Pcourse.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDAO extends JpaRepository<Category,Long> {


}

