package api.java.javaweb.srv.Pcourse;

import api.java.javaweb.DAO.Pcourse.CategoryDAO;
import api.java.javaweb.model.Pcourse.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategorySrvImpl implements CategorySrv
{
    @Autowired CategoryDAO dao;

    @Override
    public List<Category> findAll() {
        return dao.findAll();
    }

    @Override
    public Category findById(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public Long save(Category category) {
         dao.save(category);
         return category.getId();
    }

    @Override
    public Category update(Category category) {
        save(category);
        return category;
    }

    @Override
    public Category delete(Category category) {
        dao.delete(category);
        return category;
    }
}
