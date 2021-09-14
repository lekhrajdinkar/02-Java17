package api.java.javaweb.model.Pcourse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="COURSE")
public class Course {
    @Id Long id;
    String title;
    String desc;
    // @ManyToOne Category category;
    // @OneToOne Instructor instructor;
    // @OneToMany List<Section> sections;
}
