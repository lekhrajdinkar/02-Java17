package web.model.Pcourse;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity(name="INSTRUCTOR")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String email;

    //Bidirectional mapping
    @OneToOne(mappedBy = "instructor")
    @JsonBackReference(value = "instructor_course_json")
    Course course;

}
