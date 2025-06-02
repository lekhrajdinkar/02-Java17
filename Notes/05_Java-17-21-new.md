# Java 21 new Feature 

## java 18
- Pattern Matching for instanceof (Standard): Enhances the instanceof operator to allow pattern matching and conditional extraction.
- JEP 406: Pattern Matching for switch (Standard): Extends pattern matching to switch expressions.
- JEP 413: Code Snippets in Java API Documentation: Allows Java API documentation to include examples as code snippets.
- JEP 401: Primitive Objects (Preview): Introduces primitive objects as a preview feature, providing a way to treat primitives as objects.
- JEP 415: Context API: Introduces a new API for accessing contextual information in a more flexible and efficient way.
---

## java 19 / 20
- Features for Java 19 have not been finalized yet, as it is still in development at the time of my last update.
---

## java 21
- **Pattern Matching in switch Expressions**
```java
// example -1
Object obj = // some object;
String formatted = switch (obj) {
    case Integer i -> String.format("int %d", i);
    case Long l    -> String.format("long %d", l);
    case Double d  -> String.format("double %f", d);
    
    case String s  -> String.format("String %s", s);
    case String s when s.length() > 5 -> System.out.println("Long string");  // <<< Guarded patterns (with when):
    
    case null -> System.out.println("null");
    default        -> obj.toString();
};

// example -2 - Deconstruction patterns (for records) in switch
record Point(int x, int y) {}

switch (shape) {
    case Point(int x, int y) when x == y -> System.out.println("Square point");
    case Point(int x, int y) -> System.out.println("Point at " + x + "," + y);
    // ...
}

// example -3
Object obj = new Point(3, 4);
if (obj instanceof Point(int x, int y)) {
        System.out.println(x + "," + y); // 3,4
}
```
