package learn.java11.Javaall.bootstrap;

import learn.java11.Javaall.DAO.CategoryDAO;
import learn.java11.Javaall.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class BootstrapDB implements CommandLineRunner {

    @Autowired CategoryDAO categoryDAO ;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- BootstrapDB ---START");
        LoadDB();
        System.out.println("--- BootstrapDB ---END");
    }

    void LoadDB(){
        Category c1 = new Category(1L, "Computer Science", "Programming languages and Tools");
        categoryDAO.save(c1);
    }
}
