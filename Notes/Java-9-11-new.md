# Java 11 new Features

## Java 9
1. `JShell`: A Read-Eval-Print Loop (REPL) tool.
2. `Module System` (Project Jigsaw): for better modularizing of code,  help to encapsulate packages.
3. `Interfaces` Enhancement : `private methods`.
4. `try-with-resources statement`.
5. Stream API Enhancements: `takeWhile`, `dropWhile`
6. `Optional`:  
   - ifPresentOrElse(Consumer,Runnable)
   - stream() 
   - isEmpty() 
7. `Diamond Operator Enhancement`: 
   - Allows the diamond operator to be used with `anonymous classes`.
8. @Deprecated(`forRemoval=true`) : annotation to indicate they will be removed in future releases.
> 9. `new HTTP/2 Client`: `HTTP/2` and `WebSocket` protocol support.

More:
- `Multi-Resolution Image API`: An API for working with images at different resolutions.
- `Process` : Improved API for managing and controlling operating system processes.
- `Multi-Release JARs`: Allowed a single JAR to support multiple versions of Java.

---

## Java 10,11
1. Allows running a Java source file as a `script`.
   - Allowed running a single-file program without compilation (`java MyClass.java`).
2. Local-Variable Type Inference (`var`): 
   - Allows the type of local variables to be inferred by the compiler.
   - use of var in lambda expressions.
> 3. `Nest-Based Access Control`: 
>  - access the private member of nested class.
>  - had to use reflection API before.
4. `TLS 1.3 protocol` support.

4. internal improvements:
   - Parallel Full GC for G1: G1 garbage collector now supports `full GC parallelism`.
   - Application Class-Data Sharing: Improves `startup time` and `reduces memory` footprint by sharing common class metadata across JVM instances.
   > - `Heap Allocation on Alternative Memory Devices` : Experimental support for allocating the Java object heap on alternative memory devices.
   - `Epsilon`: A no-op garbage collector, useful for performance testing and short-lived jobs.
   - `Root Certificates`: Open-source root certificates to improve the OpenJDK build process.

5. `Flight Recorder`:  tools
 - A low-overhead data collection framework for troubleshooting and `profiling`.
