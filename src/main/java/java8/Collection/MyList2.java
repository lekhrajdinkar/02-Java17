package java8.Collection;

import java.util.*;


public class MyList2 {
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
        List<String> l = Collections.singletonList("gfd"); // only one item

    }


}
