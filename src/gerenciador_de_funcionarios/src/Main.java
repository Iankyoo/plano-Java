package gerenciador_de_funcionarios.src;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Manager Isis = new Manager(1, "Isis", 3000);
        Manager Tony = new Manager(2, "Tony", 3000);
        Developer Ian = new Developer(3, "Ian", 2400);
        Developer Judah = new Developer(4, "Judah", 2400);
        try {
            Manager Arthur = new Manager(6, "Arthur", -1000);
        } catch (InvalidSalaryException e){
            System.out.println("error: " + e.getMessage());
        }

        Isis.promote();
        Judah.promote();

        Employee[] employees = {Isis, Tony, Ian, Judah};

        for (Employee i: employees){
            i.displayInfo();
        }
    }
}