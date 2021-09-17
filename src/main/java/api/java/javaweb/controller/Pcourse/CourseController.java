package api.java.javaweb.controller.Pcourse;

import api.java.javaweb.DAO.Pcourse.CourseDAO;
import api.java.javaweb.DTO.Pcourse.CourseDTO;
import api.java.javaweb.DTO.Pcourse.mapper.CourseMapper;
import api.java.javaweb.model.Pcourse.Course;
import api.java.javaweb.srv.Pcourse.CategorySrv;
import api.java.javaweb.srv.Pcourse.CourseSrv;
import api.java.javaweb.srv.Pcourse.InstructorSrv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CourseController 
{

    Logger logger = LoggerFactory.getLogger(CourseController.class);
    
    @Autowired CourseSrv srv;
    @Autowired CategorySrv categorySrv;
    @Autowired InstructorSrv instSrv;

    //@Override
    @GetMapping("course/find-all")
    public List<Course> findAll() {
        logger.debug("CourseController :: findAll");
        List<Course>  res = srv.findAll();
        res.stream().forEach(System.out::print);
        return srv.findAll();
    }

    @GetMapping("course/find-all-dto")
    public List<CourseDTO> findAllDto() {
        logger.debug("CourseController :: findAllDto");
        return srv.findAllDto();
    }

    //@Override
    @GetMapping("course/findById")
    public Course findById(Long id) {
        logger.debug("CourseController :: findById");
        return srv.findById(id);
    }

    //@Override
    @PostMapping("course/save")
    public Long save(@RequestBody CourseDTO dto) {
        logger.debug("CourseController :: save");

            Course c = CourseMapper.dto2Model(dto); //manual mapper, Todo: use mapStruct
            c.setCategory(categorySrv.findById(dto.getCategoryId())); // loading Category Entity manually from id.
            c.setInstructor(instSrv.findById(dto.getInstructorId()));

        return srv.save(c);
    }

    // ============ @Query

    @Autowired CourseDAO dao;

    @GetMapping("course/q-find-by-cat")
    public List<CourseDTO> QFindByCategory() {
        logger.debug("CourseController :: QFindByCategory");
        //List<Course>  res =  dao.find2ByCategoryId(1L).get();
        List<Course>  res =  dao.find3ByCategoryId(1L);
        return res.stream()
                .map((Course x )-> CourseMapper.model2Dto(x))
                .collect(Collectors.toList());
    }

    @GetMapping("course/q-find-by-inst")
    public List<CourseDTO> QFindByInstructor() {
        logger.debug("CourseController :: QFindByInstructor");
        //List<Course>  res =  dao.find2ByCategoryId(1L).get();
        List<Course>  res =  dao.find1ByInstructorId(1L);
        return res.stream()
                .map((Course x )-> CourseMapper.model2Dto(x))
                .collect(Collectors.toList());
    }

    @GetMapping("course/q-find-All-page/{page}/{size}")
    public List<CourseDTO> QFindAllPage(@PathVariable int page, @PathVariable int size) {
        logger.debug("CourseController :: QFindAllPage");
        Page<Course> res = dao.findAllWithPagination( PageRequest.of(page, size, Sort.by("title").descending().and(Sort.by("desc"))));
        return res.getContent().stream()
                .map((Course x )-> CourseMapper.model2Dto(x))
                .collect(Collectors.toList());
    }

}
