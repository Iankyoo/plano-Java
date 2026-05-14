package Task6;

import Task3.BankAccount;

public class SalaryAccount extends BankAccount implements Taxable {
    public SalaryAccount(String accountHolder, int accountNumber) {
        super(accountHolder, accountNumber);
    }

    @Override
    public double calculateTax() {
        return this.balance * 0.15;
    }
}
