public class Ej1 {

    public static void main(String[] args) {

        Cuenta c = new Cuenta("Rosa", 60);

        try {
            c.depositar(40);
            System.out.println("A: " + c.getSaldo());

            c.retirar(150);
            System.out.println("B: " + c.getSaldo());

            c.retirar(30);
            System.out.println("C: " + c.getSaldo());

        } catch (IllegalStateException e) {
            System.out.println("D: " + e.getMessage());
        }

        System.out.println("E: " + c.getSaldo());
    }
}
