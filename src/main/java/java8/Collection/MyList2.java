package java8.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java8.Collection.MyQueue1.p;

public class MyList2 {
    static Logger log = LoggerFactory.getLogger(MyList2.class);

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

        // Convert List to Map. key is Index
        // >>>> Function.identity() == x->x
        Map<Integer,Student> m = (Map)students.stream().collect(Collectors.toMap(students::indexOf, Function.identity()));
        m.entrySet().forEach(x->p("key : "+x.getKey()+", value : "+x.getValue()));

        // Spliterator - split, tryAdvance(Consumer)-single processing
        // https://chat.openai.com/c/5a922567-573c-4788-8b4c-071cda3386e0
        List list =  Stream.generate(()->"item").limit(20).collect(Collectors.toList());
        Spliterator<String> split1 = Spliterators.spliterator(list, Spliterator.CONCURRENT);
        Spliterator<String> split2 = split1.trySplit();

        log.info("Size : split1 : {}, split2: {}", split1.estimateSize(), split2.estimateSize());
        split1.forEachRemaining(x->{System.out.println(x+"-1-"+split1.estimateSize());});
        split2.forEachRemaining(x->{System.out.println(x+"-2-"+split2.estimateSize());});
        log.info("Size(AFTER) : split1 : {}, split2: {}", split1.estimateSize(), split2.estimateSize());

    }


}
