package api.java.javaweb.model.Pcourse;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity(name="COURSE")
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    String title;
    String desc;

    @ManyToOne
    @JoinColumn(name="CAT_ID")
    Category category;
    // @OneToOne Instructor instructor;
    // @OneToMany List<Section> sections;
}
