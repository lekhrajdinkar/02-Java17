package java8;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

@Slf4j
public class Fibonacci extends RecursiveTask<Integer>
{
    final int n;
    Fibonacci(int n) { this.n = n; }
    protected Integer compute()
    {
        if (n <= 1) return n;
        Fibonacci f1 = new Fibonacci(n - 1);
        f1.fork();
        Fibonacci f2 = new Fibonacci(n - 2);
        Integer temp = f2.compute() + f1.join();
        log.info(" {}",temp);
        return temp;
    }

    public static void main(String[] args)
    {
        ForkJoinPool pool = new ForkJoinPool(1);
        Fibonacci task = new Fibonacci(10);
        System.out.println(pool.invoke(task));
    }
}

/*
ForkJoinPool
    invoke(ForkJoinTask<T> task): Executes the given task, returning its result
    execute(ForkJoinTask<?> task): Arranges for asynchronous execution
    submit(ForkJoinTask<T> task): Submits a ForkJoinTask for execution

ForkJoinTask
    fork(): Arranges to asynchronously execute this task
    join(): Returns the result of the computation when complete
    invoke(): Starts execution and returns result when complete

ForkJoinPool (with 4 worker threads)
┌───────────────────────────────────────────────────┐
│ Thread 1       Thread 2       Thread 3       Thread 4 │
│ ┌─────────┐    ┌─────────┐    ┌─────────┐    ┌─────────┐ │
│ │ Task A1 │    │ Task B1 │    │         │    │         │ │
│ └─────────┘    └─────────┘    └─────────┘    └─────────┘ │
│    │               │                                     │
│    ▼               ▼                                     │
│ ┌─────────┐    ┌─────────┐                              │
│ │ Task A2 │    │ Task B2 │                              │
│ └─────────┘    └─────────┘                              │
│    │                                                     │
│    ▼                                                     │
│ ┌─────────┐                                             │
│ │ Task A3 │                                             │
│ └─────────┘                                             │
└──────────────────────────────────────────────────------─┘
 */
