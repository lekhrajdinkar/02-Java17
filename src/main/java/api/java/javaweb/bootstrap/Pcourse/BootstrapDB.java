package api.java.javaweb.bootstrap.Pcourse;

import api.java.javaweb.DAO.Pcourse.CategoryDAO;
import api.java.javaweb.DAO.Pcourse.CourseDAO;
import api.java.javaweb.model.Pcourse.Category;
import api.java.javaweb.model.Pcourse.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BootstrapDB implements CommandLineRunner {

    @Autowired CategoryDAO categoryDAO ;
    @Autowired CourseDAO courseDAO ;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- BootstrapDB ---START");
        LoadDB();
        System.out.println("--- BootstrapDB ---END");
    }

    void LoadDB(){
        // Category
        Category c1 = new Category(1L, "Programming", "Learn leading Programming languages and Tools", null);
        Category c2 = new Category(2L, "Music", "Excel yourself in playing Musical Instrument", null);


        // Course
        List courses = new ArrayList<Course>();

        Course c = new Course();
            c.setCategory(c1);
            c.setTitle("JavaScript MasterClass");
            c.setDesc("Learn JavaScript with modern ES2021");
            c.setId(1L);
        courseDAO.save(c)   ; courses.add(c);

        c = new Course();
        c.setCategory(c1);
        c.setTitle("CSS MasterClass");
        c.setDesc("Learn How to style web page with CSS grid and flexbox in 2021");
        c.setId(2L);
        courseDAO.save(c)   ; courses.add(c);

        c = new Course();
        c.setCategory(c1);
        c.setTitle("TypeScript MasterClass");
        c.setDesc("Learn TypeSafety with Typescript in 2021");
        c.setId(3L);
        courseDAO.save(c)   ; courses.add(c);

        //c1.setCourses(courses);
        categoryDAO.save(c1);
        //c2.setCourses(new ArrayList<Course>());
        categoryDAO.save(c2);
    }
}

/*
    select * from course;
    select * from category;
 */


