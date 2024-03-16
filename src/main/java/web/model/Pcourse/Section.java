package web.model.Pcourse;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="SECTION")
public class Section {
    @Id Long id;
    // @OneToMany Lesson lessons;
}
