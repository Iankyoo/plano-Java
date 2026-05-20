package com.Iankyo;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPractice {
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

        accounts.stream()
                .filter(a -> a.getBalance() > 150 && a.getBalance() < 350)
                .map(a -> a.getAccountHolder())
                .forEach(System.out::println);

        BankAccount highestAccount = accounts.stream()
                .max(Comparator.comparingDouble(BankAccount::getBalance))
                .get();

        System.out.println(highestAccount);

        List<BankAccount> accountsLength = accounts.stream()
                .filter(a -> a.getBalance() < 250)
                .collect(Collectors.toList());

        System.out.println(accountsLength.stream().count());

        Map<String, Double> bank = accounts.stream()
                .collect(Collectors.toMap(
                        a -> a.getAccountHolder(),
                        a -> a.getBalance()
                ));

        System.out.println(bank);

        boolean existing_account = accounts.stream()
                .anyMatch(a -> a.getAccountHolder().equals(("Ian")));

        System.out.println(existing_account);
    }
}
