import Task3.BankAccount;
import Task6.BusinessAccount;
import Task6.SalaryAccount;
import Task6.Taxable;
import task5.SavingsAccount;

public class Main {
    public static void main(String[] args) {
        SalaryAccount account1 = new SalaryAccount("Ian", 1);
        BusinessAccount account2 = new BusinessAccount("Judah", 2);
        account1.deposit(100000);
        account2.deposit(100000);

        Taxable[] accounts = {account1, account2};
        for (Taxable account: accounts) {
            System.out.println(account.calculateTax());
        }
    }
}