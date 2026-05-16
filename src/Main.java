import Task3.BankAccount;
import Task6.BusinessAccount;
import Task6.SalaryAccount;
import Task6.Taxable;
import Task7.BankAccount2;
import Task7.InsufficientBalanceException;
import Task8.Bank;
import task5.SavingsAccount;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        BankAccount account1 = new BankAccount("Ian", 1);
        BankAccount account2 = new BankAccount("Judah", 2);
        BankAccount account3 = new BankAccount("Isis", 3);
        BankAccount account4 = new BankAccount("Tony", 4);
        account1.deposit(300);
        account2.deposit(400);
        account3.deposit(350);
        account4.deposit(500);
        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);
        bank.addAccount(account4);

        bank.removeAccount(3);
        bank.displayAllAccounts();
        System.out.println(bank.totalBalance());
        bank.findAccount(1);

        Map<String, BankAccount> accountsByName = new HashMap<>();
        accountsByName.put(account1.getAccountHolder(), account1);
        accountsByName.put(account2.getAccountHolder(), account2);

        BankAccount found = accountsByName.get("Ian");
        found.displayBalance();
        }
    }