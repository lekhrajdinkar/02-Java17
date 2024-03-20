package java8.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.*;

@Data
@AllArgsConstructor
class Student implements Comparable<Student> {
    String firstname; String lastname; byte age;
    @Override
    public int compareTo(Student o) { return this.age > o.age ? 1 : (this.age == o.age ? 0 : -1) ;}
    @Override
    public String toString(){  return this.firstname; }
}
public class MyArraylist {
    static void print(Collection c){ c.stream().forEach( System.out::println); }
    static void print(String... s){Arrays.stream(s).forEach(System.out::println);}
    public static void main(String... a){
        List students = new ArrayList<Student>() ;
        students.add(new Student("Manisha", "Prasad", (byte)28));
        students.add(new Student("lekhraj", "Dinkar", (byte)32));
        students.add(new Student("Touseef", "Mohammad", (byte)35));
        students.add(new Student("Gaytri", "piscal", (byte)31));

        //Collections.sort(students);
        Collections.sort(students, (Student s1, Student s2)->s1.age > s2.age ? 1 : (s1.age == s2.age ? 0 : -1));
        print(students);
        int index=students.indexOf(new Student("lekhraj", "Dinkar", (byte)32));
        System.out.println(index);

        //Immutable list
        List<Student> unmodifiableList = Collections.unmodifiableList(students);
        List<String> unmodifiableList2=List.of(new String[] {"a", "b", "c"});

    }


}
