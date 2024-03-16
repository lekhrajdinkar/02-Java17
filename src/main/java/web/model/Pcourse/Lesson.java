package web.model.Pcourse;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="LESSON")
public class Lesson {
    @Id Long id;
    String title;
    String desc;
    String url;
}
