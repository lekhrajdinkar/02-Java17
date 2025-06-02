package java8;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.CompletableFuture;
import static java.lang.Thread.sleep;

@Slf4j
public class CompletableFutureDemo
{
/*
Creation
    supplyAsync() - Runs a Supplier asynchronously
    runAsync() - Runs a Runnable asynchronously

Chaining:
    thenApply() - Transform result
    thenAccept() - Consume result
    thenRun() - Run action after completion

Combining
    thenCombine() - Combine two futures
    allOf() - Wait for all futures
    anyOf() - Wait for any future

Error Handling
    exceptionally() - Handle exceptions
    handle() - Handle both success and failure
*/

    // --------- Example-1
    String fetchUser(Long id) //throws Exception
    {
        String temp = "lekhraj_Dinkar, (#" +id+")";
        log.info(temp);
        return temp;
        //return throw new Exception("fetchUser:ManualError");
    }
    String enrichUser(String UserAsString){
        String temp = UserAsString+"_enrichUser";
        log.info(temp);
        return temp;
    }
    String sendNotification(String UserAsString){
        log.info("sent notification");
        return "sent notification";
    }

    void m1(Long userId){
        // Like promise in javaScript
        CompletableFuture.supplyAsync(() -> fetchUser(userId))
                .thenApply(user -> enrichUser(user))  // Transform result
                .thenAccept(user -> sendNotification(user)) // Consume result
                .exceptionally(ex -> {
                    log.error("Error processing user", ex);
                    return null;
                });
    }

    // ---------- Example 2------------
    void m2()
    {
        // 1. Creating CompletableFuture
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try { sleep(2000); }
            catch (InterruptedException e) {throw new RuntimeException(e);}
            return "future1 :: Hello after 2sec !";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try { sleep(3000); }
            catch (InterruptedException e) {throw new RuntimeException(e);}
            return "future2 :: Hello after 3sec !";
        });

        // 2. Basic consumption : thenAccept
        future1.thenAccept(result -> {
            log.info("1. Basic consumption: " + result + " on " + Thread.currentThread().getName());
        });

        // 2. Running multiple in parallel
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2);
        allFutures.thenRun(() -> {
            log.info("All completed: " + future1.join() + " and " + future2.join());
        });

        // 3. Chaining with thenApply (transformation)
        CompletableFuture<String> future1_transformed = future1.thenApply(s -> {
            log.info("2. Transforming: " + s );
            return s + " World";
        });
    }

    public static void main(String[] args) throws InterruptedException {
        CompletableFutureDemo temp = new CompletableFutureDemo();
        temp.m1(100L);
        temp.m2();

        // Keep main thread alive to see all results
        sleep(10000);
    }
}