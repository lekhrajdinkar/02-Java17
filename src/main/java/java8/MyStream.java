package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class MyStream {
    static void p(Object ...o){ Arrays.stream(o).forEach(System.out::println);}

    public  static void main(String args[]) throws Exception {
        generate();
        operationOnStream();
        //primitiveStreams();
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

        printStream(() -> Stream.generate(() -> "element").limit(5));
        printStream(() -> Stream.iterate(40, n -> n + 2).limit(5));

    }

    static void primitiveStreams(){
        IntStream iStream = IntStream.range(1,3);
        LongStream lStream = LongStream.range(1,3);
        DoubleStream dStream = DoubleStream.builder().add(2).build();
    }



    // B. Operations
    // B.1. Immediate --> allows chaining, map,  filter,
    // B.2. Terminal --> no chaining, end with definite value. eg: count, isParallel, forEach(), any/all/noneMatch, reduce etc
    static void operationOnStream (){
        operationOnStream_distinct(Stream.of("aa1", "bb1", "cc1","aa1", "bb1", "cc1"));
        operationOnStream_map(Stream.of("aa1", "bb1", "cc1","aa1", "bb1", "cc1"));
        operationOnStream_anyMatch(Stream.of("aa1", "bb1", "cc1")); // T/F
        operationOnStream_filter(Stream.of("aa1", "bb1", "cc1"));
        operationOnStream_flatMap(Stream.of("aa1", "bb1", "cc1"));
        operationOnStream_reduce(Stream.of("aa1", "bb1", "cc1"));
    }
    static void operationOnStream_distinct (Stream stream){
        //p(stream.distinct().count(), "xxxxxx");
        stream.distinct().forEach(System.out::println);
    }
    static void operationOnStream_map(Stream stream){
        stream.map(x->x.hashCode()).forEach(System.out::println);
    }
    static void operationOnStream_anyMatch(Stream<String> stream){
        p(stream.anyMatch(x->x.contains("a")));
    }
    static void operationOnStream_filter(Stream<String> stream){
        stream.filter(x->x.contains("a")).forEach(System.out::println);
    }
    static void operationOnStream_flatMap(Stream<String> stream){
        //stream.flatMap(x->x.contains("")).forEach(System.out::println);
    }
    static void operationOnStream_reduce(Stream<String> stream){
        p(stream.reduce("", (agg, cur)-> agg + "_"+ cur));
    }
}

@FunctionalInterface
interface FnIStreamGen<T>{
    public Stream<T> generate();
}

// parallelStream -->
