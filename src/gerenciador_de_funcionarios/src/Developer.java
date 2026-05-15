package gerenciador_de_funcionarios.src;

public class Developer extends Employee implements Promotable {
    public Developer(int id, String name, double baseSalary){
        super(id,name,baseSalary);
    }

    @Override
    public double calculateBonus() {
        return this.baseSalary * 0.20;
    }

    @Override
    public void promote(){
        this.baseSalary += this.baseSalary * 0.10;
    }
}
