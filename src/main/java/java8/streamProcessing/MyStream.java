package java8.streamProcessing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.*;

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
    static void generate() throws IOException {

        printStream(() -> Stream.of("aa", "bb", "cc","aa", "bb", "cc"));
        printStream(() -> Stream.builder().add("a").add("b").add("c").build());
        printStream(() -> { List l = new ArrayList<String>(); l.add("a1"); l.add("b1"); return l.parallelStream(); });
        printStream(() -> {String[] sa = new String[] {"a2","b2"}; return Arrays.stream(sa); });

        printStream(() -> Stream.generate(() -> "element").limit(5));
        printStream(() -> Stream.iterate(40, n -> n + 2).limit(5)); //Note: use IntStream is want to get int[], rather that Integer[]

        printStream(() -> {
            Stream ret = null;
            try {
                ret = Files.lines(Path.of("classpath:stream.txt"));
            } catch (IOException e) {
                ret = Stream.empty();
                p(e.getLocalizedMessage());
            }
            return ret;
        });

    }

    static void primitiveStreams(){
        IntStream iStream = IntStream.range(1,3);
        LongStream lStream = LongStream.range(1,3);
        DoubleStream dStream = DoubleStream.builder().add(2).build();
    }



    // B. Operations
    // B.1. Immediate --> allows chaining, map,  filter,
    // B.2. Terminal --> no chaining, end with definite value. eg: count, isParallel, forEach(), any/all/noneMatch, reduce etc
    // More : limit(2), skip(2),
    static void operationOnStream (){
        operationOnStream_distinct(Stream.of("aa1", "bb1", "cc1","aa1", "bb1", "cc1"));
        operationOnStream_map(Stream.of("aa1", "bb1", "cc1","aa1", "bb1", "cc1"));
        operationOnStream_anyMatch(Stream.of("aa1", "bb1", "cc1")); // T/F
        operationOnStream_filter(Stream.of("aa1", "bb1", "cc1"));
        operationOnStream_flatMap(Stream.of("aa1", "bb1", "cc1"));
        operationOnStream_reduce(Stream.of("aa1", "bb1", "cc1"));

        IntSummaryStatistics r = operationOnStream_collect1(Stream.of(1,2,3,4,5));
        p(r.getAverage(), r.getCount(), r.getMax(), r.getMin());

        operationOnStream_collect2(Stream.of(1,2,3,4,5));
        operationOnStream_collect3(Stream.of(1,2,3,4,5));
        operationOnStream_collect4(Stream.of(1,2,3,4,5));
        operationOnStream_collect5(Stream.of(1,2,3,4,5));
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

    static IntSummaryStatistics operationOnStream_collect1(Stream<Integer> stream){
        return stream.collect(Collectors.summarizingInt(i->i+100)); // 103, 515, 101
    }
    static void operationOnStream_collect2(Stream<Integer> stream){
        p(stream.collect(Collectors.averagingInt(i->i+100))); //103
    }
    static void operationOnStream_collect3(Stream<Integer> stream){
        p(stream.collect(Collectors.summingInt(i->i+100))); //515
    }
    static void operationOnStream_collect4(Stream<Integer> stream){
        p(stream.collect(Collectors.partitioningBy(i-> i>3))); //{false=[1, 2, 3], true=[4, 5]}
    }
    static void operationOnStream_collect5(Stream<Integer> stream){
        p(stream.collect(Collectors.groupingBy(i-> i>3))); //{false=[1, 2, 3], true=[4, 5]}
    }
}

@FunctionalInterface
interface FnIStreamGen<T>{
    public Stream<T> generate();
}

/*
ParallelStream --> runs cb in II.

Java 8 streams can't be reused.
We can instantiate a stream, and have an accessible reference to it,
as long as only intermediate operations are called.
Executing a terminal operation makes a stream inaccessible.

stream Pipeline ::  source, intermediate operation(s) and a terminal operation.

Collection/Array - parallelStream
other- stream().parallel
Note:: uses ExecutorService and ForKJoin framework to achieve it.

*/