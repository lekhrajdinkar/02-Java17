package web.model.Pcourse;

import jakarta.persistence.*;
//import javax.persistence.*;

@Entity(name="SECTION")
public class Section {
    @Id Long id;
    // @OneToMany Lesson lessons;
}
