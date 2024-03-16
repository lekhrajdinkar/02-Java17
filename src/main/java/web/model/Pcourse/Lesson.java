package web.model.Pcourse;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="LESSON")
public class Lesson {
    @Id Long id;
    String title;
    String desc;
    String url;
}
