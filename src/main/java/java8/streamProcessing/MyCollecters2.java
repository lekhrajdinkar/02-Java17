package java8.streamProcessing;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyCollecters2 {
    static void p(Object... objArr){
        Arrays.stream(objArr).forEach(System.out::println);
        System.out.println("--------------------------");
    }
    static List<Integer> l = List.of(1,2,3,4,5,1,2,3,4,5,1,2,3,4,5); //Immutable List.
    public static <HasSet> void main(String a[])
    {
        // 1. ============= groupingBy =============

        // 1.1 Collectors.groupingBy(Function)

        Map<String,List<Integer>> r = l.stream()
                .skip(5)
                .limit(5)
                .sorted() // pass comparator, else Comparable of Integer
                //.peek(MyCollecters2::p)
                .peek(System.out::println)
                .collect(Collectors.groupingBy(n-> n%2==0 ? "EVEN": "ODD"));
        p("1.1. Collectors.groupingBy(Function) - even/odd",r);

        // 1.2 Collectors.groupingBy(Function)
        Map<Integer,List<Integer>> r11 = l.stream().collect(Collectors.groupingBy(n->n));
        p("1.2. Collectors.groupingBy(Function) - group by same number",r11);

        // 1.3 Collectors.groupingBy(Function, Collectors)
        Map<Integer,Long> r12 = l.stream().collect(Collectors.groupingBy(n->n, Collectors.counting()) );
        p("1.3. Collectors.groupingBy(Function) - group by count",r12);
        r12.keySet().forEach(x-> { p("count of "+x+" is "+r12.get(x));});

        //2  ============ partitioningBy =============

        // 2.1 Collectors.partitioningBy(Function)
        Map<Boolean,List<Integer>> r2 = l.stream().collect(Collectors.partitioningBy(n->n%2==0) );
        p("2.1. Collectors.partitioningBy(Function) - even/odd",r2);

        // 2.2 Collectors.partitioningBy(Function, Collectors)
        Map<Boolean,Long> r21 = l.stream().collect(Collectors.partitioningBy(n->n%2==0, Collectors.counting()) );
        p("2.2. Collectors.partitioningBy(Function, Collectors) - even/old with count",r21);
        //r21.keySet().forEach(x-> { System.out.println("count of "+x+" is "+r21.get(x));});

        //3  ============ toMap =============

        // 3.1 Collectors.toMap(Function, Function)
        Map<Integer,Boolean>  r31 = l.stream().distinct().collect(Collectors.toMap(x->x, x->x%2==0) );
        p("3.1. Collectors.toMap(Function, Function) - k:num, v-Is even/odd",r31);

        //99 ============= optional ====================
        List<String> names = Stream.of("lek", "manisha", "bryan", "dinkar", "Prasad").collect(Collectors.toList());
        Optional<List<String>> optional = Optional.of(names);
        //p("After Map : ",optional.map(x->x+" !!").get()); p("original :", optional.get());
        //p("After Filter", optional.filter(x->x.contains("bryan")).get());
        p("99. Optional MAP Operator", optional.map((List x)->{return x.size();}).get());

    }
}