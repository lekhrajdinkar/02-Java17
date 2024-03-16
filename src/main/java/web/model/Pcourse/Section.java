package web.model.Pcourse;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="SECTION")
public class Section {
    @Id Long id;
    // @OneToMany Lesson lessons;
}
