public class Cuenta {

    private String titular;
    private double saldo;

    public Cuenta(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public void depositar(double cantidad) {
        saldo += cantidad;
    }

    public void retirar(double cantidad) {
        if (cantidad > saldo) {
            throw new IllegalStateException("Saldo insuficiente");
        }
        saldo -= cantidad;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }
}
