# Java 8

- New Date and Time API
  - LocalDateTime,
  - ZonedDateTime

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

- Streams API + Collection API new methods.
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
  - Function.identity() == x->x
  
  - CREATE 
    - `Stream.of`, `Stream.empty()`,`Stream.builder().add().add()...`, 
    - `Stream.generate(x-{}).limit(5)`, 
    - `Stream.iterate(seed,Predicate,x->{})`, `Stream.iterate(seed,x->{}).limit(5)`
    - `Files.lines(Path.of(file))`, 
  - INTERMEDIATE
    - java 8 :
      - `filter(Predicate)`, `map(Function)`, `flatmap(Function)`, `peek(Consumer)`, `distinct()`, `sorted(),(c)`, `boxed()`
      - `limit(long)`, `skip(long)`
    - Java 9 : 
      - `takewhile(Predicate)`, `dropwhile(Predicate)`
    - jav 16 : 
      - `multiMap`
  - TERMINAL
    - java 8
      - `forEach(Consumer)`, `forEachOrdered(Consumer)`
      - `toArray()`
      - `reduce()`, `reduce()`, `reduce()`
      - `collect()`,  `collect()`
    - java 9
      - Optional<T> `findFirst()`
      - Optional<T> `findAny()`

- `Optional<T>` class
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
1. program with Optional<`List<Interger>`>  and  Optional<`Interger`>
2. Spliterator - parallel stream  
3. Flattening Nested Collections in Java - recursively call flatMap(c::m) 
4. Zipping Collections in Java : ext lib: `StreamEx.zip`(stream1,stream2, (s1-item,s2-item)->{...})
   - <artifactId>streamex</artifactId>
   - or write custom code.
5. Immutable collection:
   - Guava library :: ImmutableList/Set/Map::copyOf(c)
   - j9+ :: List.copyOf(l),  Set.copyOf(s) ,  Map.copyOf(m)