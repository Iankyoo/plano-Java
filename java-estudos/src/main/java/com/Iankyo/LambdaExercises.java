package com.Iankyo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaExercises {
    public static void main(String[] args){
        Predicate<Double> isHighBalance = n -> n > 500;
        Function<BankAccount,String> accountSummary = c -> "[" + c.getAccountNumber() + "] " + c.getAccountHolder() + " - R$ " + c.getBalance();
        Consumer<BankAccount> printAccount = s -> System.out.println(accountSummary.apply(s));
        BankAccount account01 = new BankAccount("Ian", 01);
        BankAccount account02 = new BankAccount("Judah", 02);
        BankAccount account03 = new BankAccount("Isis", 03);
        BankAccount account04 = new BankAccount("Tony", 04);

        account01.deposit(100);
        account02.deposit(200);
        account03.deposit(300);
        account04.deposit(600);

        List<BankAccount> accounts = List.of(account01,account02,account03,account04);

        for (BankAccount account: accounts){
            printAccount.accept(account);
        }

        for (BankAccount account: accounts){
            System.out.println(isHighBalance.test(account.getBalance()));
        }






    }
}
