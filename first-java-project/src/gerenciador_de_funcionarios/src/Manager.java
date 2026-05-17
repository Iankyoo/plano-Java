package gerenciador_de_funcionarios.src;

public class Manager extends Employee implements Promotable {
    public Manager(int id, String name, double baseSalary) {
        super(id, name, baseSalary);
    }

    @Override
    public double calculateBonus() {
        return this.baseSalary * 0.30;
    }

    @Override
    public void promote() {
        this.baseSalary = this.baseSalary * 0.10;
    }
}
