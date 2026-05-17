package com.Iankyo;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<BankAccount> accounts = new ArrayList<>();

    public void addAccount(BankAccount account){
        accounts.add((account));
    }

    public void removeAccount(int accountNumber){
        accounts.removeIf(account -> account.getAccountNumber() == accountNumber);
    }

    public BankAccount findAccount(int accountNumber){
        for (BankAccount account: accounts){
            if (account.getAccountNumber() == accountNumber){
                return account;
            }
        }
        return null;
    }

    public void displayAllAccounts(){
        for (BankAccount account: accounts){
            System.out.println(account.toString());
        }
    }

    public double totalBalance(){
        double totalBalance = 0.0;
        for (BankAccount account: accounts){
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }
}
