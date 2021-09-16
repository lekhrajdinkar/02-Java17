package api.java.javaweb.model.Pcourse;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CATEGORY")
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @Column(nullable = false, name = "title", length = 50)
    String title;
    String desc;

    // Creating BI-DIRECTIONAL Association.
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    @JsonBackReference(value = "category_course_json")
    List<Course> courses;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                //", courses=" + courses +
                '}';
    }
}
