package learn.java11.Javaall.DAO;

import learn.java11.Javaall.model.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryDAO extends JpaRepository<Category,Long> {

//    @Query(value = "SELECT o FROM Category o")
//    List<Category> findAllCategory(Pageable pageable);
}

