# Java 8

## New Date and Time API
  - `LocalDateTime`
  - `ZonedDateTime`

---
## Interfaces
- interfaces flexibility - Multiple inheritance, resolve method conflicts
    - `Default` Method {...}
    - static method  {...}
    - final method  {...}
    - above 3 can be private
  
- `@FunctionalInterface` FI - implementation ways:
    - `lambda exp`
    - `method references` 
      - way to refer to methods or constructors without invoking them.
      - further simplify lambda expressions
    - categorizes of FI:
      - Consumer<T> : accepts-T
      - Supplier<T> : produces-T
      - Predicate<T> | BiPredicate<T,U> : accepts-T,U and produces-`boolean`
      - Function<T,R> | BiFunction<T,U,R> : accepts-T,U and produces-R
      - UnaryOperator<T> | BinaryOperator<T> :  accepts-T(1 or 2) and produces-T
      - Runnable : nothing
      - Comparator<T> :  accepts-T and produces-`Integer`
      - custom

---
## `Streams` and collections
- Streams API 
- Collection API - new methods.
  - Java 8 - streams (baeldung) :: https://chat.openai.com/c/5a922567-573c-4788-8b4c-071cda3386e0
  - Executing a terminal operation makes a stream inaccessible, cant be reused. 
    - trick : create Supplier of streams. `Supplier<Stream> :: get()`
  - `stream Pipeline` ::  source, intermediate operation(s) and a terminal operation.
  - `parallelStream`
  - Operators (takes lambdas)
    - intermediate : filter(), map(), boxed(), [list1,list2].stream().`flatmap`(list->list.stream()),
    - terminal : Collect(), findAny()-Optional<T>, etc
  - `Spliterator`: also used internally by parallel stream 
    - trySplit() : to split an iterator 2 multiple parts to be processed in parallel
    - control behaviour: SIZED, SUBSIZED, ORDERED, NONNULL, IMMUTABLE, and CONCURRENT
  - stream of primitives :: (IntStream, LongStream, DoubleStream), `mapToObj`
  - Function.identity() == x->x, a function that returns its input.
  - List.copyOf(l1),of(l1)  instanceOf  `ImmutableCollections$ListN`
  - stream.collect(Collectors.toList()) --> shortcut :` stream.toList()`
  
  - `java 8 - stream operators` : https://chatgpt.com/c/4616e081-ba31-4587-9343-8d1b2adf142e
  - CREATE 
    - `Stream.of`, `Stream.empty()`,`Stream.builder().add().add()...`, 
    - `Stream.generate(x-{}).limit(5)`, 
    - `Stream.iterate(seed,Predicate,x->{})`, `Stream.iterate(seed,x->{}).limit(5)`
    - `Files.lines(Path.of(file))`, 
  - INTERMEDIATE
    - java 8 :
      - `filter(Predicate)`, `map(Function)`, `flatmap(Function)`, `peek(Consumer)`, `distinct()`,  `boxed()`
      - `sorted()` : natural order : comparable,`sorted(Compartor)`,
      - `limit(long)`, `skip(long)`, `peek(Consumer)`
    - Java 9 : 
      - `takewhile(Predicate)` : Takes elements from the stream while the predicate is true. BREAK
      - `dropwhile(Predicate)` : Drops elements from the stream while the predicate is true. CONTINUE
    - jav 16 : 
      - `multiMap(*)` ??????
  - TERMINAL
    - java 8
      - void `forEach(Consumer)`, `forEachOrdered(Consumer)`
      - void `toArray()`
      - T `min/max(Comparator)` , Long `count()`
      - `reduce`
        - Optional<Integer>  `reduce(BinaryOperator<T>)`, // accumulator ( partial-result, next-element)
        - List<T>            `reduce(T,BinaryOperator<T>)` //  seed, accumulator 
        - List<T>            `reduce(U,BiFunction<U,T>, BinaryOperator<U>)` ** 
          - (seed, accumulator, combiner) -> for parallel processing
          - takes two partial results and combines them into a single partial result.
      - ? `collect(Collector)`, 
      - return boolean : `anyMatch(Predicate)`, `allMatch(Predicate)`, `noneMatch(Predicate)`
      - `toCollection`(LinkedList::new)
       
    - java 9
      - Optional<T> `findFirst()`
      - Optional<T> `findAny()`
      
  - COLLECTORS : terminal operation >> .collect(Collectors.*)
    - java 8
      - long Collectors.`counting`() : count result after stream-processing.
      - T Collectors.`[min/max]By`(Comparator<T>)
      - String Collectors.`joining`(delimterStr, prefixStr, suffixStr) : Concatenates the input elements into a single `String`
      - Collectors.`reducing`
        - Collectors.reducing( BinaryOperator) : (u,u)->u
        - Collectors.reducing(seed, BinaryOperator) : (u,u)->u
        - Collectors.reducing(seed, Function, BinaryOperator) **
        
      - Collectors.`collectingAndThen`(downstream-Collector.*, collectedValue -> {})
      - Map Collectors.`partitioningBy`(Predicate)
      - Map Collectors.`groupingBy`(Function), Collectors.`groupingBy`(Function, downstream-Collector.*) **
        ```
         List<Integer> l = List.of(1,2,3,4,5,1,2,3,4,5,1,2,3,4,5);  
         Map<Integer,Long> r12 = l.stream().collect(Collectors.groupingBy(n->n, Collectors.counting()) );
        ```
      - `summarizingInt|Double`(ToIntFunction), `[Averaging|Sumuing][Int|Double]`
         - IntSummaryStatistics stats = stream.collect(Collectors.summarizingInt(String::length));
      - List/Set Collectors.`toList`(),`toSet`()
      - Map      Collectors.`toMap`(i->k, i->v), `toMap`(i->k, i->v, (existing,replacment)->v) : 3rd agr to resolve duplicate entry/key.
    
    - java 9
      - Collectors.`mapping`(transform-Function, downstream-Collector.*)
        - transform a stream of collections into a single stream  and collect the results using a downstream collector, at same time.
        - like map().collect(Collector.*)
      - Collectors.`Filtering`(filter-Function, downstream-Collector.*) :
        - filter a stream of collections into a single stream  and collect the results using a downstream collector, at same time.
        - like filter().collect(Collector.*)
      - Collectors.`FlatMapping`(flapmap-Function, downstream-Collector.*): 
        - flatten a stream of collections into a single stream  and collect the results using a downstream collector, at same time.   
        - like flatmap().collect(Collector.*)
  
    - java10,11
      - Collectors.`toUnmodifiableSet`(),`toUnmodifiableList`()
      - Collectors.`toUnmodifiableMap`(Function,Function), `toUnmodifiableMap`(Function,Function,BiFunction)
      
    - Java12
      - Collectors.`teeing`(Collector1, Collector2, (result1,result2)->{})

> imp: understand `downstream-Collector` behaviour
        
---
## `Optional<T>`
  - container object that may or may not contain a value.
  - represent optional values, instead of using null references.
  - safer alternative to handling null values.
  - Example. (`can chain them`)
    - Create:
      - Optional.`of`(value) --> if value=null, gives NPE.
      - Optional.`ofNullable`(value) -->  value can be null.
    - get
      - `get`() --> can give `NoSuchElementException`
      - `orElse`(defaultValue)
      - `orElseGet`(Supplier<T>)
      - `orElseThrow`(Supplier<X>), X is exception type
    - value presence
      - `isPresent`() - t/f
      - `ifPresent`(Consumer<T>) - if t, execute consumer
    - more(try)
      - `filter`( Predicate<T> )
      - `map`(Function<T,R>)
      - `flatmap`()
  
---
### programs
1. program with Optional<`List<Integer>`>  and  Optional<`Integer`>
2. Spliterator - parallel stream  
3. Flattening Nested Collections in Java - recursively call flatMap(c::m) 
4. Zipping Collections in Java : ext lib: `StreamEx.zip`(stream1,stream2, (s1-item,s2-item)->{...})
   - <artifactId>streamex</artifactId>
   - or write custom code.
5. Immutable collection:
   - Guava library :: ImmutableList/Set/Map::copyOf(c)
   - j9+ :: List.copyOf(l),  Set.copyOf(s) ,  Map.copyOf(m)