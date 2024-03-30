package java8.streamProcessing;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyStream2 {
    static List<Integer> list = new ArrayList();
    static Collection collection = list;
    static Stream<Integer> stream = Stream.empty();
    static Stream<String> streamStr = Stream.empty();
    public static void main (String... arr) throws IOException {
        System.out.println("========== A. Create Streams =============");
        //initStreams();

        System.out.println("========== B. Intermediate =============");
        intermediateOperation();

        System.out.println("========== C. terminal operations =============");
        //terminalOperation();
    }
    static int accumulatorFunction(int n1, int n2){return n1+n2;}

    static void p(String msg, Stream s){
        System.out.println(msg);
        s.forEach(System.out::println);
        System.out.println("-------------------");}

    static void initStreams() throws IOException {
        // >>> Executing a terminal operation makes a stream inaccessible.
        // >>> se one terminal operation per stream.
        // >>> Intermediate operations are lazy.

        // A.1. From Collections and array
        stream = collection.stream();
        stream = list == null || list.size()==0 ? Stream.empty() : list.stream(); p("Stream.empty()",stream);

        // A.2 from Stream util
        stream = Stream.<Integer>builder().add(1).add(200).add(300).build();
        stream = Stream.generate(()->1).limit(2); p("Stream.generate",stream);//Supplier
        stream = Stream.iterate(40, n->n+2).limit(3);  p("Stream.iterate",stream);
        stream = Stream.iterate(40, n-> n<=46, n->n+2);  p("Stream.iterate",stream); // java 9, 2nd Agr - Predicate,  to terminate it.
        stream = Stream.of(1,2,3);  p("Stream.of",stream);

        // A.3 patten/regex + String
        streamStr = Pattern.compile(" ").splitAsStream("a b c"); p("Pattern.compile",streamStr);

        //A.4 Files
        Path path = Paths.get("C:\\Lekhraj\\Github\\02-Backend-API-Java17\\src\\main\\java\\java8\\streamProcessing\\stream.txt");
        Stream<String> streamOfStrings = Files.lines(path);
        Stream<String> streamWithCharset = Files.lines(path, Charset.forName("UTF-8"));
        p("read files streamWithCharset", streamWithCharset);
    }

    static  void intermediateOperation() {
        // filter, map, peek
        stream = Arrays.stream(new Integer[] {1,2,3,4,5,6,6,6,6});
        streamStr = Arrays.stream(new String[] {"zen", "ben", "dinkar"});

        p("distinct ",stream.distinct() );
    }

    static void terminalOperation(){
        //1. reduce()
        //reduce has 3 variant. 3rd one for parallel reduction
        stream = Arrays.stream(new Integer[] {1,2,3});
        int count = stream.reduce(100, (acc,x)-> x+acc);
        p("reduce1 :: count "+count, Stream.empty());

        stream = Arrays.stream(new Integer[] {1,2,3});
        Optional<Integer> optionalCount = stream.reduce((acc,x)-> x+acc);
        p("reduce2 :: count "+optionalCount.get(), Stream.empty());

        stream = Arrays.stream(new Integer[] {1,2,3});
        count = stream.collect(Collectors.summingInt(x->x));
        p("Collectors.summingInt :: count "+count, Stream.empty());



        stream = Arrays.stream(new Integer[] {1,2,3});
        boolean result = stream.anyMatch(x->x==2); // allMatch, noneMatch
        p("anyMatch / allMatch / noneMatch :: "+result, Stream.empty());

        stream = Arrays.stream(new Integer[] {1,2,3});
        Optional<Integer> opt = stream.findAny(); // findFirst()
        p("findAny / findFirst :: "+result, Stream.empty());

        //  Collectors.summingInt()
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Integer sum = integers.stream().collect(Collectors.summingInt(Integer::intValue));

    }


}
