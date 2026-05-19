package com.Iankyo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class StreamExercises {
    public static void main(String[] args){
        BankAccount account01 = new BankAccount("Ian", 01);
        BankAccount account02 = new BankAccount("Judah", 02);
        BankAccount account03 = new BankAccount("Isis", 03);
        BankAccount account04 = new BankAccount("Tony", 04);

        account01.deposit(100);
        account02.deposit(200);
        account03.deposit(300);
        account04.deposit(400);

        List<BankAccount> accounts = List.of(account01, account02, account03, account04);

        List<BankAccount> highAccounts = accounts.stream()
                .filter(b -> b.getBalance() > 300)
                .collect(Collectors.toList());

        System.out.println(highAccounts);

        double totalBalance = accounts.stream()
                .mapToDouble(BankAccount::getBalance)
                .sum();

        System.out.println(totalBalance);

        List<String> accountHolderUppercase = accounts.stream()
                .map(a -> a.getAccountHolder().toUpperCase())
                .collect(Collectors.toList());

        System.out.println(accountHolderUppercase);

        List<BankAccount> sortedAccounts = accounts.stream()
                .sorted(Comparator.comparingDouble(BankAccount::getBalance))
                .collect(Collectors.toList());

        System.out.println(sortedAccounts);

        boolean hasNegative = accounts.stream()
                .anyMatch(x -> x.getBalance() < 0);

        System.out.println(hasNegative);

        accounts.stream()
                .limit(3)
                .forEach(System.out::println);
    }

}
