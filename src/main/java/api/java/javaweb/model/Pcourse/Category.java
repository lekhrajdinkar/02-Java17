package api.java.javaweb.model.Pcourse;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Entity
@Table(name = "CATEGORY")
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    String title;
    String desc;

    // Creating BI-DIRECTIONAL Association.
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)

    @JsonManagedReference
    List<Course> courses;
}
