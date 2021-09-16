package api.java.javaweb.model.Pcourse;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

@Entity(name="COURSE")
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    String title;
    String desc;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name="CAT_ID")
    @JsonManagedReference(value = "category_course_json")
    Category category;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="INST_ID")
    @JsonManagedReference(value = "instructor_course_json")
    Instructor instructor;

    @ManyToMany(mappedBy = "courses")
    //@JsonManagedReference
    @JsonBackReference(value = "student_course_json")
    List<Student> students;


    // @OneToMany List<Section> sections;
}
