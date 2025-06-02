package java8.streamProcessing.custom;

import java.util.List;

public class CustomCollector {
    public static void main(String[] args) {
        List<String> words = List.of("Hello", "World", "Java", "Collectors");
        String result = words
                .stream()
                .collect(CustomStringJoiner.joining(", ", "[", "]"));
        System.out.println(result); // Output: [Hello, World, Java, Collectors]
    }
}

/*

A collector requires four components specified by the Collector interface:
    Supplier - Creates a new mutable result container
    Accumulator - Incorporates a new element into the result container
    Combiner - Merges two result containers (for parallel streams)
    Finisher - Performs final transformation (optional)
    Characteristics - Provides optimization hints (optional)

Type Parameters:
<T> - Type of input elements (String in our example)
<A> - Mutable accumulation type (StringBuilder)
<R> - Final result type (String)
 */
