public class Retiros {
    public static void main(String[] args) {
        Cuenta c = new Cuenta("Marta", 120);
        int[] retiros = { 50, 200, -5, 70 };
        for (int r : retiros) {
            try {
                c.retirar(r);
                System.out.println("Retiro de " + r + " -> saldo " + c.getSaldo());
            } catch (IllegalArgumentException e) {
                System.out.println("Monto invalido: " + e.getMessage());
            } catch (IllegalStateException e) {
                System.out.println("No se pudo: " + e.getMessage());
            }
        }
    }
}
