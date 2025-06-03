## ParallelStream
- `parallelStream()` is a method available on Java collections that enables parallel processing of stream
- eg:
```Java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
// Sequential processing
names.stream().forEach(System.out::println);
// Parallel processing : faster
names.parallelStream().forEach(System.out::println);
```
- When to Use Parallel Streams:
```text
Operations where order doesn't matter
Large datasets (typically > 10,000 elements)
CPU-intensive operations
Stateless, independent operations
```

## ForkJoinPool
- https://chat.deepseek.com/a/chat/s/72fb223a-30f7-4d66-aab9-a6062959d6b9
- **ForkJoinPool** is the underlying framework that powers parallel streams.
  - can power our code. check : [Fibonacci.java](../../src/main/java/java8/Fibonacci.java)
  - pool of thread/s.
  - thread works on task/s. has 2 imple:
    - **ForkJoinTask** - for tasks that don't return results
    - **RecursiveAction** - for tasks that return results
- **usecase**: Parallel processing of :
  - Recursive algorithms (e.g., Fibonacci, factorial)
  - large arrays/collections
  - Tree/graph traversal algorithms
  - Divide-and-conquer problems (e.g., merge sort, quick sort)
  - ...