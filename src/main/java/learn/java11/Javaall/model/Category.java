package learn.java11.Javaall.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
}
