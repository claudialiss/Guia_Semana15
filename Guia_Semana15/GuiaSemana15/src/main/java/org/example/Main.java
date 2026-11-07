import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args) {

        System.out.println("=== 1. PRUEBA DE DEPÓSITOS (Con Try-Catch) ===");
        Cuenta cuentaAna = new Cuenta("Ana", 100);
        int[] depositos = { 50, -20, 30 };

        for (int d : depositos) {
            try {
                cuentaAna.depositar(d);
                System.out.println("Depósito de " + d + " aceptado");
            } catch (IllegalArgumentException e) {
                System.out.println("Rechazado: " + e.getMessage());
            }
        }
        System.out.println("Saldo final (Ana): " + cuentaAna.getSaldo() + "\n");


        System.out.println("=== 2. PRUEBA DE RETIROS (Múltiples Catch) ===");
        Cuenta cuentaMarta = new Cuenta("Marta", 120);
        int[] retiros = { 50, 200, -5, 70 };

        for (int r : retiros) {
            try {
                cuentaMarta.retirar(r);
                System.out.println("Retiro de " + r + " -> saldo " + cuentaMarta.getSaldo());
            } catch (IllegalArgumentException e) {
                System.out.println("Monto inválido: " + e.getMessage());
            } catch (IllegalStateException e) {
                System.out.println("No se pudo: " + e.getMessage());
            }
        }
        System.out.println("Saldo final (Marta): " + cuentaMarta.getSaldo() + "\n");


        System.out.println("=== 3. PRUEBA SIN TRY-CATCH (Comportamiento de fallo) ===");
        Cuenta cuentaLuis = new Cuenta("Luis", 80);
        cuentaLuis.depositar(20);
        System.out.println("Saldo actual (Luis): " + cuentaLuis.getSaldo());

        // ADVERTENCIA: Si descomentas la siguiente línea, lanzará una excepción
        // no controlada y el programa se detendrá de golpe aquí mismo,
        // impidiendo que se ejecute cualquier código posterior.
        // cuentaLuis.depositar(0);
        // System.out.println("Esta línea nunca se imprimiría.");
    }
}