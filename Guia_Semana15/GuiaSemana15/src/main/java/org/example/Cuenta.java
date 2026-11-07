import javax.swing.JOptionPane;
public class Cuenta {
    private String titular;
    private int saldo; // O puedes cambiarlo a double si requiere centavos

    public Cuenta(String titular, int saldo) {
        if (saldo < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo: " + saldo);
        }
        this.titular = titular;
        this.saldo = saldo;
    }

    public void depositar(int monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo: " + monto);
        }
        saldo += monto;
    }

    public void retirar(int monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo: " + monto);
        }
        if (monto > saldo) {
            throw new IllegalStateException("Saldo insuficiente: disponible " + saldo);
        }
        saldo -= monto;
    }

    public String getTitular() {
        return titular;
    }

    public int getSaldo() {
        return saldo;
    }
}