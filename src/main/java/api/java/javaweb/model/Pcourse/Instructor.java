package api.java.javaweb.model.Pcourse;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="INSTRUCTOR")
public class Instructor {
    @Id
    Long id;
}
