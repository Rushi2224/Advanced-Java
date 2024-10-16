package rushikapatel_sec001_ex01;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// AccountTest class to test multiple transactions
public class AccountTest {
    public static void main(String[] args) {
        // An account with initial balance of 1100
        Account account = new Account(1100);

        //list of Transaction objects
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(account, "deposit", 450));
        transactions.add(new Transaction(account, "withdraw", 300));
        transactions.add(new Transaction(account, "deposit", 125));
        transactions.add(new Transaction(account, "withdraw", 350));

        //a thread pool
        ExecutorService executor = Executors.newCachedThreadPool();

        //the threads are executed
        for (Transaction transaction : transactions) {
            executor.execute(transaction);
        }

        // Shutting the executor
        executor.shutdown();

        // Waiting for the threads to finish
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}