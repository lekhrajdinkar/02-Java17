package java8.Collection;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyMap1 {
    public static void main(String... arr){
        initMap();
    }

    public static void initMap() {
        Collections.singletonMap("username1", "password1"); //contain exactly one element.
        Collections.unmodifiableMap(Map.of("key1","value1", "key2", "value2")); //Immutable map

        Map<String, String> emptyMap = Map.of();
        Map<String, String> map = Map.of("key1","value1", "key2", "value2"); //max-10 pair

        map = Stream.of(new String[][] {
                { "Hello", "World" },
                { "John", "Doe" },
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        map = Stream.of(
                        new AbstractMap.SimpleEntry<String,String>("idea", "1"),
                        new AbstractMap.SimpleEntry<String,String>("mobile", "2"))
                .collect(Collectors.toMap(d->d.getKey(), d->d.getValue()));

        map = Map.ofEntries(
                new AbstractMap.SimpleEntry<String,String>("idea", "1"),
                new AbstractMap.SimpleEntry<String,String>("mobile", "2")   );

        map = new HashMap<String, String>(Map.of("key1","value1", "key2", "value2"));
    }
}
