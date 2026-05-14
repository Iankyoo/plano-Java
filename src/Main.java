import Task3.BankAccount;
import Task6.BusinessAccount;
import Task6.SalaryAccount;
import Task6.Taxable;
import Task7.BankAccount2;
import Task7.InsufficientBalanceException;
import task5.SavingsAccount;

public class Main {
    public static void main(String[] args) {
    BankAccount2 account = new BankAccount2("Ian", 1);

    try {
        account.withdraw(500);
    } catch (InsufficientBalanceException e){
        System.out.println("Error: " + e.getMessage());
    } catch (IllegalArgumentException e){
        System.out.println("Error: " + e.getMessage());
    }finally {
        account.displayBalance();
    }
    }
}