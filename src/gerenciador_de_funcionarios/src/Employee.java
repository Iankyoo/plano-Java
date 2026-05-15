package gerenciador_de_funcionarios.src;

public abstract class Employee {
    int id;
    String name;
    double baseSalary;

    public Employee(int id, String name, double baseSalary){
        if (baseSalary < 0){
            throw new InvalidSalaryException(baseSalary);
        }
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateBonus();

    public void displayInfo(){
        System.out.println("ID: " + this.id + "| name: " + this.name + "| salary: " + (this.baseSalary + calculateBonus()));
    }
}

