package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MyStream {
    static void p(Object ...o){ Arrays.stream(o).forEach(System.out::println);}

    public  static void main(String args[]) throws Exception {
        generate();
        operationOnStream();
    }

    // A. generate Stream
    static void printStream(FnIStreamGen streamGen){
        streamGen.generate().forEach(System.out::println);
    }
    static void generate(){

        printStream(() -> Stream.of("aa", "bb", "cc","aa", "bb", "cc"));
        printStream(() -> Stream.builder().add("a").add("b").add("c").build());
        printStream(() -> { List l = new ArrayList<String>(); l.add("a1"); l.add("b1"); return l.parallelStream(); });
        printStream(() -> {String[] sa = new String[] {"a2","b2"}; return Arrays.stream(sa); });
    }



    // B. Operations
    // B.1. Immediate --> allows chaining, map
    // B.2. Terminal --> no chaining, end with definite value. eg: count, isParallel, forEach(), etc
    static void operationOnStream (){
        operationOnStream_distinct(Stream.of("aa1", "bb1", "cc1","aa1", "bb1", "cc1"));
        operationOnStream_map(Stream.of("aa1", "bb1", "cc1","aa1", "bb1", "cc1"));
    }
    static void operationOnStream_distinct (Stream stream){
        //p(stream.distinct().count(), "xxxxxx");
        stream.distinct().forEach(System.out::println);
    }
    static void operationOnStream_map(Stream stream){
        stream.map(x->x.hashCode()).forEach(System.out::println);
    }
}

@FunctionalInterface
interface FnIStreamGen<T>{
    public Stream<T> generate();
}

// parallelStream -->