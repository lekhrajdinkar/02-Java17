package api.java.javaweb.model.Pcourse;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference
    Course course;

}
