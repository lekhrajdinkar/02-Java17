package java8;

import api.java.javaweb.model.Pcourse.Course;

import java.util.*;

public class Main {
    static void p(Object o){System.out.println(o.toString());}

    static List<String> getCourseList(){
        String[] courseArray = new String[] {"course1", "course2", "course3", "course4", "course5"}; //new String[0];
        List<String> courseList = Arrays.asList(courseArray);
        return courseList;
    }

    static Course getCourse(){
        return Course.builder().title("Java 8").desc("Lamba Expression, Functional Interface, Optional util Class, Method ref all 4 types").build();
    }

    public  static void main(String args[]) throws Exception {
        MyInterface.print(); //java 8 interface with static Function
        new MyInterfaceImpl().SayHello(); // Java 8 interface default method

        Optional<List<String>> courseListO =!getCourseList().isEmpty() ? Optional.of(getCourseList()): Optional.of(new ArrayList<String>());
        courseListO.stream().forEach(Main::p);
        p(courseListO.get());
        p(courseListO.map(c->c+"_map").get());


        Optional<Course> courseO = Optional.ofNullable(getCourse()); // if course is null then returns Optional.empty()
        //courseO = Optional.of(null); // then use OfOptional
        p(courseO.isEmpty());
        p(courseO.orElseGet(()-> Course.builder().build()));
        p(courseO.orElse(Course.builder().build()));
        p(courseO.map(c->c.getDesc()).map(d->d+"---suffix").get());

        // p(courseO.map(c->c.getCategory()).map(cat-> cat.getDesc()).get());
        // Cat is missing, NPE , Fix below:
        p(courseO.map(c->c.getCategory()).map(cat-> cat.getDesc()).orElse("Category Unknown")); // fix1
        p(courseO.map(c->c.getCategory()).map(cat-> cat.getDesc()).orElseThrow(CategoryMissingException::new).toLowerCase()); // change into anothor custom Exception with meaning full message


    }


}

class CategoryMissingException extends Exception{
    CategoryMissingException(){super("Category Unknown");}
}
