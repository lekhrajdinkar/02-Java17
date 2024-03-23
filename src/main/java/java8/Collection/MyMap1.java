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
        mapOperation();
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

     static void mapOperation(){
         Map map = new HashMap();
        map.put("1","lekhraj"); map.put("2","Manisha");

        map.compute("1", (k,v)->k+"-"+v);
        map.compute("10", (k,v)->k+"-"+v);
        p(map);

        map.computeIfAbsent("1", (k)->k+"-Absent");
        map.computeIfAbsent("11", (k)->k+"-Absent"); //
        p(map);

        map.computeIfPresent("1", (k,v)->k+"-Present"+v); //
        map.computeIfPresent("12", (k,v)->k+"-Present"+v);
        p(map);
    }

    static void p(Map m){
        m.entrySet().forEach(System.out::println);
        System.out.println("==========================");
    }
}
