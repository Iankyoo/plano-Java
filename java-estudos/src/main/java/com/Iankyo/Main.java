package com.Iankyo;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        BankAccount account1 = new BankAccount("Ian", 1);
        BankAccount account2 = new BankAccount("Judah", 2);
        BankAccount account3 = new BankAccount("Isis", 3);
        BankAccount account4 = new BankAccount("Tony", 4);

        account1.deposit(100);
        account2.deposit(200);
        account3.deposit(300);
        account4.deposit(400);

        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);
        bank.addAccount(account4);

        bank.removeAccount(3);

        bank.displayAllAccounts();

        System.out.println(bank.totalBalance());

        Map<String, BankAccount> accountsByName = new HashMap<>();

        accountsByName.put(account1.getAccountHolder(), account1);
        accountsByName.put(account2.getAccountHolder(), account2);
        accountsByName.put(account4.getAccountHolder(), account4);

        BankAccount found = accountsByName.get("Ian");
        System.out.println(found);

        Optional<BankAccount> opt = bank.findAccount(1);
        opt.ifPresent(a -> a.displayBalance());
        Optional<BankAccount> optNull = bank.findAccount(99);

        BankAccount acc = optNull.orElse(new BankAccount("default", 0));
        System.out.println(acc);

        try {
            BankAccount acc2 = optNull.orElseThrow(
                    () -> new RuntimeException("Account not found")
            );
            System.out.println(acc2);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }


        Optional<String> accountNames = opt.map(a -> a.getAccountHolder());
        accountNames.stream()
                .forEach(System.out::println);
    }
}