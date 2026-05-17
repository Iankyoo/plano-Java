package com.Iankyo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class BankAccount {
    private String accountHolder;
    private int accountNumber;
    private double balance;

    public BankAccount(String accountHolder, int accountNumber){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount){
        if (amount>0) {
            this.balance += amount;
        }
    }

    public void withdraw(double amount){
        if (amount<=balance){
            this.balance -= amount;
        }
    }

}
