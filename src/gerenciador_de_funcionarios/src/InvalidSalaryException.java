package gerenciador_de_funcionarios.src;

public class InvalidSalaryException extends RuntimeException{
    public InvalidSalaryException(double amount){
        super("amount most be positive");
    }
}
