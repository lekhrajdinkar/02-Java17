## CompletableFuture (Promise in js)

### thenApply(),thenApply()...thenAccept()

- used to handle asynchronous computation
- allowing you to work with results or errors in an efficient, non-blocking way.
- check chaining:

```
public class CompletableFutureExample
 {
    public static void main(String[] args)
    {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> { // runs a task asynchronously
            return 10;
        });

        future
        .thenApply(result -> result * 2)                                      // Processing result asynchronously
        .thenApply(result -> result + 10)
        ...
        .thenAccept(result -> System.out.println("Final result: " + result)); // Consuming the final result
    }
 }
```

### handle()

- can also updated result

```
        future.handle((result, exception) -> {
            if (exception == null) {
                System.out.println("Completed with result: " + result * 2);
            } else {
                System.out.println("Completed with error: " + exception.getMessage());
            }
        });
```

### whenComplete()

- same like handle
- but cannot update result.

```
        future.whenComplete((result, exception) -> {
            if (exception == null) {
                System.out.println("Completed with result: " + result );
            } else {
                System.out.println("Completed with error: " + exception.getMessage());
            }
        });
```

### thenCombine()

```
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 20);

        CompletableFuture<Integer> combinedFuture = future1
            .thenCombine(future2, (result1, result2) -> result1 + result2);

        combinedFuture.thenAccept(result -> System.out.println("Combined result: " + result));
```

### thenCompose()

- used for flat-mapping, When the next computation depends on the result of the previous one.
- future2 is dependent on future1

```
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);

        CompletableFuture<Integer> future2 = future1.thenCompose(result -> {
            return CompletableFuture.supplyAsync(() -> result * 2);
        });

        future2.thenAccept(result -> System.out.println("Final result: " + result));
```

### .completeOnTimeout
```Java
@GetMapping("/async-with-timeout")
public CompletableFuture<ResponseEntity<String>> asyncWithTimeout() {
    return asyncService.performTask("data")
            .thenApply(ResponseEntity::ok)
            .completeOnTimeout(         // Timeout Handling in REST api, asyn
                ResponseEntity.status(504).body("Request timeout"),
                2, TimeUnit.SECONDS
            );
}
```