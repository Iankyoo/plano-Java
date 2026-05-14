import Task3.BankAccount;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Ian", 1 );
        BankAccount account2 = new BankAccount("Judah", 2);
        account1.deposit(500);
        account1.withdraw(200);
        account2.deposit(500);
        account2.withdraw(250);
        account2.withdraw(600);
        account1.displayBalance();
        account2.displayBalance();

    }
}