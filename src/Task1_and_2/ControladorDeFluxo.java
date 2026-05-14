package Task1_and_2;

public class ControladorDeFluxo {
    public void executar() {
        int idade = 17;

        if (idade>=18) {
            System.out.println("Maior de idade");
        } else {
            System.out.println("Menor de idade");
        }

        for (int i=1; i<=5; i++) {
            System.out.println(i);
        }

        for (int i=1; i<=10; i++) {
            if(i%2==0) {
                System.out.println(i);
            }
        }
    }
}
