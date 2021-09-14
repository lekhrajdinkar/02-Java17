package api.java.javaweb.DTO.Pcourse;

import api.java.javaweb.model.Pcourse.Category;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDTO {
        Long id;
        String title;
        String desc;
        Long categoryId;
}

