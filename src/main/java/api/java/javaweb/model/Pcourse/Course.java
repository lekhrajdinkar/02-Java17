package api.java.javaweb.model.Pcourse;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@EntityListeners(AuditListener.class)
@Entity(name="COURSE")
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    String title;
    String desc;

    @Column
    //1. @ColumnDefault(value="TRUE") //2. @PrePersist()
    private boolean active = true;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name="CAT_ID")
    @JsonManagedReference(value = "category_course_json")
    private Category category;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="INST_ID")
    @JsonManagedReference(value = "instructor_course_json")
    private Instructor instructor;

    @ManyToMany(mappedBy = "courses")
    //@JsonManagedReference
    @JsonBackReference(value = "student_course_json")
    private List<Student> students;


    // @OneToMany List<Section> sections;

    @Column(
            name = "created_on"
            //,columnDefinition = "DATETIME(6) DEFAULT CURRENT_TIMESTAMP"
    )
    //@Generated(GenerationTime.INSERT)
    private LocalDateTime createdOn;

//    //Life Cycle callback
//    @PrePersist
//    public void onPrePersist() {  }
//
//    @PreUpdate
//    public void onPreUpdate() { }
//
//    @PreRemove
//    public void onPreRemove() {  }
}
