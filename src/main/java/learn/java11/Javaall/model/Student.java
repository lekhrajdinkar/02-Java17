package learn.java11.Javaall.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="STUDENT")
public class Student {
    @Id Long id;
}
