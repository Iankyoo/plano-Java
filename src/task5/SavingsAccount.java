package task5;

import Task3.BankAccount;

public class SavingsAccount extends BankAccount {
    private double interestRate;
    public SavingsAccount(String accountHolder, int accountNumber, double interestRate) {
        super(accountHolder, accountNumber);
        this.interestRate = interestRate;
    }

    public void applyInterest(){
        double rate = this.balance * interestRate;
        this.balance += rate;
    }
}
