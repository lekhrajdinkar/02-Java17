# Java 11 new Features

## Java 9
1. JShell: A Read-Eval-Print Loop (REPL) tool for evaluating code snippets.
2. Module System (Project Jigsaw): Introduces a module system for better modularizing of code.
3. Private Methods in Interfaces: Interfaces can have private methods now.
4. HTTP/2 Client: A new HTTP client to support HTTP/2 and WebSocket out-of-the-box.
5. Process API Updates: Improved API for managing and controlling operating system processes.
6. Try-With-Resources Improvement: The try-with-resources statement can now declare resources outside the parentheses.
7. Diamond Operator Enhancement: Allows the diamond operator to be used with anonymous classes.
8. Stream API Enhancements: Added several new methods to the Stream API, like takeWhile, dropWhile, etc.
9. Optional Class Enhancements: Added ifPresentOrElse, stream, or, isEmpty methods to the Optional class.
10. Multi-Resolution Image API: An API for working with images at different resolutions.
11. Enhanced Deprecation: Deprecated APIs can now be marked with a @Deprecated(forRemoval=true) annotation to indicate they will be removed in future releases.

---

## Java 10:

1. Local-Variable Type Inference (var): Allows the type of local variables to be inferred by the compiler.
2. Parallel Full GC for G1: G1 garbage collector now supports full GC parallelism.
3. Application Class-Data Sharing: Improves startup time and reduces memory footprint by sharing common class metadata across JVM instances.
4. Heap Allocation on Alternative Memory Devices: Experimental support for allocating the Java object heap on alternative memory devices.
5. Time-Based Release Versioning: Changes the versioning scheme to a time-based model.

---

## java 11

1. Local-Variable Syntax for Lambda Parameters: Allows the use of var in lambda expressions.
2. HTTP Client (Standard): The incubating HTTP client introduced in Java 9 is now a standard feature.
3. Flight Recorder: A low-overhead data collection framework for troubleshooting and profiling.
4. Epsilon: A no-op garbage collector, useful for performance testing and short-lived jobs.
5. Launch Single-File Source-Code Programs: Allows running a Java source file as a script.
6. Nest-Based Access Control: Enhances the accessibility of classes by grouping them in nests.
7. Dynamic Class-File Constants: Allows the invokedynamic bytecode instruction to reference a dynamically-computed constant.
8. TLS 1.3: Adds support for the TLS 1.3 protocol.
9. Remove the Java EE and CORBA Modules: Removes the Java EE and CORBA modules from the JDK.
---

https://www.baeldung.com/java-httpclient-post