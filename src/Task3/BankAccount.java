package Task3;

public class BankAccount {
    private String accountHolder;
    private int accountNumber;
    private double balance;

    public BankAccount(String accountHolder, int accountNumber){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount){
        this.balance += amount;
    }

    public void withdraw(double amount){
        if (this.balance>amount){
            this.balance -= amount;
        } else {
            System.out.println("Balance is not sufficient");
        }
    }

    public void displayBalance(){
        System.out.println("Account Holder: " + this.accountHolder + " | Balance: " + this.balance );
    }
}
