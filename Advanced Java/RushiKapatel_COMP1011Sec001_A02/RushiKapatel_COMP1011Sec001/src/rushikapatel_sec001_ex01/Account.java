package rushikapatel_sec001_ex01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
public class Account {private double balance;

    public Account(double initialBalance) {
        balance = initialBalance;
    }

    //method to deposit into the account
    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited Amount: " + amount + ", Current Balance: " + balance);
    }

    //method to withdraw from the account
    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal Amount: " + amount + ", Current Balance: " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}

// Transaction class implementing the Runnable interface
class Transaction implements Runnable {
    private Account account;
    private String type;
    private double amount;

    public Transaction(Account account, String type, double amount) {
        this.account = account;
        this.type = type;
        this.amount = amount;
    }

    // run method to perform deposit or withdrawal
    @Override
    public void run() {
        if (type.equals("deposit")) {
            account.deposit(amount);
        } else if (type.equals("withdraw")) {
            account.withdraw(amount);
        }
    }
}
