## Java Topic
### Fundamental:
  - JVM JRE JDK classLoader/ Memory Model : GC, heap,stack,permGen etc.
    - custom ClassLoader - load classes from `non-standard sources`(databases, network-locations, or encrypted files)
    - dynamic loading : classes at runtime based on certain conditions, user-input,etc.
  - SourceCode --> [compile]  byteCode --> [interpreter] --> execute
    - frequently executed byteCode -->  [JIT] --> native machine-code
    - `JIT Compile` (performance)
      - identifies portions of the bytecode that are `frequently executed`
      - Compiles them into native machine-code at runtime.
      - native code is cached and reused.
    
  - more building-blocks:
    - Operators & precedence, Expression & statement
    - control/conditional statement, switch expression & block
    - loop, break/continue.

    
  - primitives types/8:
    - char and boolean
    - Number :
      - byte, int **, short, long
      - double **, floating
      
  - More Reference Type : WrapperForPrimitive with autoboxing, `BigInteger`, `AtomicInteger`, `BigDecimal`
  - `varargs` in methods : 
    - variable-length arguments. eg: psvm(String[]), psvm(String...)
    - can have only one vararg, and must be last arg.

---   
### OOPS 
  - Concepts to create modular, maintainable, and scalable Java applications
  - class(Enum/Record), object, access specifier, immutable class, Encapsulation
  - inheritance, abstraction, Association(has-a)/dependencies.
  - constructor chaining and `static-block/s`
  - Interface / built-in marker-interface
    - `private final static` feilds / constants
    - `public` abstract method
    - more flexibility after java 8.
  - Polymorphism - override and overload
  - keywords : this, super, this(), super(), final, static
  - More on classes:
    - `Generic class / interface`
      - improved typing, compile-time type safety.
      - if myClass is operating on multiple types, make it generic.
      - wildcard : <?>, <T>, <T extends MyType>,  <? extends MyType>, <? extends T>
    - `SingleTon Class, inner class, annonymous Class`
    - `Immutable class`:
      - final class, final method, final property
      - no setter,
      - make defensive copies... create new object.
    some fact:
      - Constructors are not inherited by subclasses, but a subclass constructor implicitly calls a superclass constructor before executing its own code.
      - In inheritance, subclass can provide broader value for overridden method : `accessSpecifier`, throws `exceptionType`, covariant `returnType`.
      - Overloaded methods are resolved at compile time.
      
--- 
###  Strings (Immutable)
  - StringPool : intern()
  - String Manipulation : charAt, length, substring, reverse, 
  - StringBuffer(Thread-Safe) and StringBuilder(Mutable variant of String)

---
### Java Collection (Data structure)
  - `Array` : int[3], int{1,2,3} : Core DS.
  - List :
    - `ArrayList` : internally Array [varyLength], dynamic Array-grows & shrinks.
    - `LinkedList` 
      - Nodes with forward/backward references. 
      - less efficient for random access.
      - adding/removing  -beginning or middle is fast.
    - `vector`: Thread-Safe version of ArrayList, provides sync methods. SLOW
    - `stack`** : vectors with additional methods: `push,pop,peek`. SLOW
    
  - Map 
    - `HashMap`<K,V>  
      - ArrayList(bucket) Of Entry(k,v)
      - hashCode(Key)== bucket/index on array + onCollision:add(Tree,J8+/Linked-list,J7)
      - null allowed, no ordering, O(1)
        
    - `HashTable` 
      - Thread-Safe of hashMap
      - null not allowed, thus slower.
      
    - I:SortedMap<K,V>  
      - `TreeMap` : 
        - self-balancing BinaryTree(R&B), Entry/Nodes has reference to child entry/Nodes.
        - null NOT allowed, ordered, sub-map views, O(log n)
        
  - Set (no duplicate)
    - `HashSet`<V>      : HashMap<K,null> :: bucket -> ArrayList  Of Node
    - `LinkedHashSet`** : HashMap<K,null> :: bucket -> linkedList Of Node
    
    - I:SortedSet<V> 
      - `TreeSet` : Treemap<K,null>
    
  - Queue : `priorityQueue` , `ArrayDeque`
  - DeQue : `LinkedList` has also implemented methods from Deque Interface.

  - Utils:
    - Collections : `toArray()`, sort(C), binarySearch(), `Shuffle()`
    - Arrays : `asList()`, toString(), sort(), binarySearch(), `copyOf()`
    - Comparator/FI and Comparable
    - Iterators 
    - ListIterator - bi-diretion, hasPrevious(),add(),set()
    - Spliterator-J8
    - enhanced loop - for(item:collection){...}

> - Side-Note:
  > - can think, Linked-list as tree with single branch.
  > - and, tree as object/s randomly stored on heap/main-memory with references.
  > - graph : circular, tree has end note.

- More:
  - `Fail-fast` (ConcurrentModificationException) vs `fail-safe` (works on cloned copy)
  - eg: CopyOnWriteArrayList - failSafe, ArrayList - failFast

---
### Exception handing
  - checked
  - un-checked / RuntimeExcetion
  - `throwable`, 

---
### IO  
- io (old) and nio(New) : `Files`, `Path`, `scanner`
- > Check:Java7Andbefore.IO
- Serializable, transient
- File READ ways:
``` 
  - Stream<String> lines = `Files`.lines(`Paths`.get(file))
  - file :: `InputStream::FileInputStream`(bytes) --> `InputStreamReader`(chars) --> `BufferReader`(efficient)  :: readline
  - resource > file :: `SB:resourceLoader` --> InputStream::FileInputStream(bytes) --> InputStreamReader(chars) --> BufferReader(efficient)  :: readline
```
- File WRITE ways:
```
  - List<String> lines --> `fileWriter.write`(line)
  - `Files`.write( `Paths`.get(fileName1), lines, StandardOpenOption...);
```
---
### Extra
- `natively complied languages`
  - source code is directly compiled into machine code
  - C, C++, Golang
  - offer better performance
  - they may require more effort in managing memory and dealing with low-level details of the hardware architecture.
