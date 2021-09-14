package api.java.javaweb.api.Pcourse;

import api.java.javaweb.model.Pcourse.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface CategoryApi{

    @GetMapping("/find-all")
    public List<Category> findAll();

    @GetMapping("find-all/{id}")
    public Category findById(Long id);

    @PostMapping("save")
    public Long save(@RequestBody Category category);
}
