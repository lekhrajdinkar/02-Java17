package java8;

import api.java.javaweb.DTO.Pcourse.CourseDTO;
import api.java.javaweb.model.Pcourse.Course;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyCollectors
{
    static void p(Object ...o){ Arrays.stream(o).forEach(System.out::println); System.out.println("");}
    public static <HasSet> void main(String a[])
    {
        String[] strings = {"1", "2", "3", "3"};

        // A. Collectors Interface
        p("\n-----------A. Collectors---------");
        // List
        ArrayList l = (ArrayList) Arrays.stream(strings).collect(Collectors.toList());
        p(l, l.getClass().getName()); // or toUnmodifiableList()



        // Set
        HashSet s = (HashSet)  Arrays.stream(strings).collect(Collectors.toSet());
        p(s, s.getClass().getName()); // or toUnmodifiableSet()

        // Map
        HashMap m1 = (HashMap)  s.stream().map(e->e).collect(Collectors.toMap(k->k,k->k));
        p(m1, m1.getClass().getName()); // no duplicate no collision

        // collision : IllegalStateException due to duplkicate 3
        // HashMap m2 = (HashMap)  l.stream().map(e->e).collect(Collectors.toMap(k->k,k->k)); p(m2);
        // Function.identity() === k->k

        // Fix collision : 3rd arg, another fi
        HashMap m2 = (HashMap)  l.stream().map(e->e).collect(Collectors.toMap(k->k,k->k, (k,dup)->dup+"__dup"));
        p(m2, m2.getClass().getName());
        m2.put("4","4"); p(m2); //works...

        //toUnmodifiableMap
        //HashMap m2_final = (HashMap) l.stream().map(e->e).collect(Collectors.toUnmodifiableMap(k->k, k->k, (k, dup)->dup+"__dup")); p(m2); // class cast exception, could be concuurenthashmap
        Map m2_final = (Map) l.stream().map(e->e).collect(Collectors.toUnmodifiableMap(k->k, k->k, (k, dup)->dup+"__dup"));
        p(m2_final, m2_final.getClass().getName()); // java.util.ImmutableCollections$MapN
        //m2_final.put("4","4");  //UnsupportedOperationException


        p("\n-----------B. Collectors :: CollectingAndThen---------");
        // if want to perform some operation on result after collecting
        HashSet c1 = (HashSet) s.stream()
                .map(e->e)
                .collect(Collectors.collectingAndThen(Collectors.toList(), list->new HashSet(list) ));
        p(c1, c1.getClass().getName());

        int size = (int) s.stream()
                .map(e->e)
                .collect(Collectors.collectingAndThen(Collectors.toList(), list->list.size() ));
        p(size);

        List c2 = (List) s.stream()
                .map(e->e)
                .collect(Collectors.collectingAndThen(Collectors.toList(), list->list.stream().map(x->x+"---modified---").collect(Collectors.toList())));
        p(c2);

        // List.copyOf(list) --> returns Immutable list, ImmutableCollections$ListN
        c2 = (List) s.stream()
                .map(e->e)
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> List.copyOf(list)));
        p(c2, c2.getClass().getName());
        // c2.add("5"); //UnsupportedOperationException


        p("\n-----------B. Collectors :: Joining---------");
        String[][] string2d = new String[][]{ {"1", "2"}, {"3", "3"}};

        //  Join String collection
        p( Arrays.stream(strings).collect(Collectors.joining(" ")),
           Arrays.stream(strings).collect(Collectors.joining(" ", "PRE-- { ", " } --POST")));

        //p( Arrays.stream(string2d).flatMap(x->x).collect(Collectors.joining(" ")); //String

        //  Join Object collection
        List <CourseDTO> courses = List.of(
                CourseDTO.builder().title("c1").desc("c1---desc").build(),
                CourseDTO.builder().title("c2").desc("c2---desc").build(),
                CourseDTO.builder().title("c3").desc("c3---desc").build()
                );
        p( courses.stream()
                .map(x->x.toString()) //extra step to make charSeq.... <<                           Here
                .collect(Collectors.joining())); //joining works if instance/item is charSequence



    }

}
