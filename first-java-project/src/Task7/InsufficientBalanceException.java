package Task7;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(double amount){
        super("insufficient balance for withdrawal of: " + amount);
    }
}
