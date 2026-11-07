import javax.swing.JOptionPane;

public class MenuCajero {
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta("Ana", 100);
        String[] ops = { "Depositar", "Retirar", "Saldo", "Salir" };
        int opcion;

        do {
            opcion = JOptionPane.showOptionDialog(null,
                    "Que desea hacer?", "Cajero", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, ops, ops[0]);
            try {
                if (opcion == 0 || opcion == 1) {
                    String txt = JOptionPane.showInputDialog("Monto:");
                    if (txt == null) {
                        continue;
                    }
                    int monto = Deposito.leerMonto(txt);
                    if (opcion == 0) {
                        cuenta.depositar(monto);
                    } else {
                        cuenta.retirar(monto);
                    }
                    JOptionPane.showMessageDialog(null,
                            "Listo. Saldo: $" + cuenta.getSaldo());
                } else if (opcion == 2) {
                    JOptionPane.showMessageDialog(null,
                            "Saldo: $" + cuenta.getSaldo());
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Escriba solo numeros",
                        "Dato invalido", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException | IllegalStateException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(),
                        "Operacion rechazada", JOptionPane.WARNING_MESSAGE);
            }
        } while (opcion != 3 && opcion != JOptionPane.CLOSED_OPTION);
    }
}