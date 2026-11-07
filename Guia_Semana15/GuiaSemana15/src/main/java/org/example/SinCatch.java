public class SinCatch {
    public static void main(String[] args) {
        Cuenta c = new Cuenta("Luis", 80);
        c.depositar(20);
        System.out.println("Saldo: " + c.getSaldo());
        c.depositar(0);
        System.out.println("Esta linea no se imprime");
    }
}