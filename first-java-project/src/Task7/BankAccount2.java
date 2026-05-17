package Task7;

public class BankAccount2 {
    private String accountHolder;
    private int accountNumber;
    protected double balance;

    public BankAccount2(String accountHolder, int accountNumber){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount){
        this.balance += amount;
    }

    public void withdraw(double amount){
        if (amount <= 0){
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (this.balance < amount) {
            throw new InsufficientBalanceException(amount);
        }
        this.balance -= amount;
    }

    public void displayBalance(){
        System.out.println("Account Holder: " + this.accountHolder + " | Balance: " + this.balance );
    }
}
