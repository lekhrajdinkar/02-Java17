package api.java.javaweb.controller.Pcourse;

import api.java.javaweb.DTO.Pcourse.CourseDTO;
import api.java.javaweb.DTO.Pcourse.mapper.CourseMapper;
import api.java.javaweb.model.Pcourse.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class TestController
{
    Logger logger = LoggerFactory.getLogger(TestController.class);

    // API Vesrioning

    @GetMapping(
            value="test/get",
            produces="application/v1+json"
    )
    private Integer getId() { return 20; }

    @GetMapping(
            value="test/get",
            produces="application/v2+json"
    )
    private String getName() { return "20String"; }
}
