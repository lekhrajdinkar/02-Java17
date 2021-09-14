package api.java.javaweb.model.Pcourse;

import javax.persistence.*;
import java.util.List;

@Entity(name="COURSE")
public class Course {
    @Id Long id;
    String title;
    String desc;
    // @ManyToOne Category category;
    // @OneToOne Instructor instructor;
    // @OneToMany List<Section> sections;
}
