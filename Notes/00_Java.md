# 1. JVM option 
- -Xms1g 
- -Xmx1g 
- -XX:MaxRAMPercentage=75.0
- -Xms512m -Xmx1024m
- -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=9090 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false

# 2. Profiling
1. heap dump
   - on local :: JVisualVM (GUI Tool) + UI for basic inspection
   - spring boot actuator API
   - `-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/path/to/dump.hprof`
   - Analyze dump:
     - **Eclipse MAT** (Memory Analyzer Tool) – Best for detailed memory leak analysis
     - **JProfiler** – Commercial tools with advanced features.
     - Jhat or jconsole
2. heap dump on pod
   - set env var
   - ```
     env:
     - name: JAVA_OPTS
       value: "-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/path/to/dump.hprof"

     envFrom:
     - configMapRef:
         name: jvm-config-1
    ```
3. **Sidecar Containers for JMX/Profiling**