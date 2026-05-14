import Task3.BankAccount;
import task5.SavingsAccount;

public class Main {
    public static void main(String[] args) {
        SavingsAccount account1 = new SavingsAccount("Ian", 1, 0.02 );
        account1.deposit(1000000);
        account1.applyInterest();
        account1.displayBalance();

    }
}