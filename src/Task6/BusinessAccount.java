package Task6;

import Task3.BankAccount;

public class BusinessAccount extends BankAccount implements Taxable {

    public BusinessAccount(String accountHolder, int accountNumber) {
        super(accountHolder, accountNumber);
    }

    @Override
    public double calculateTax() {
        return this.balance * 0.25;
    }
}
