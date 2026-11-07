import javax.swing.JOptionPane;

public class Deposito {

    // 1. AQUÍ COLOCAS EL MÉTODO DE LA NUEVA IMAGEN
    static int leerMonto(String texto) {
        int monto = Integer.parseInt(texto.trim());
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que cero");
        }
        return monto;
    }

    // 2. Método principal (main) que llama al método anterior y maneja las ventanas
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta("Ana", 100);

        String texto = JOptionPane.showInputDialog(
                null,
                "Monto a depositar:",
                "Cajero",
                JOptionPane.QUESTION_MESSAGE
        );

        if (texto == null) {
            return; // El usuario canceló la operación
        }

        try {
            // Aquí se usa el método leerMonto que definiste arriba
            cuenta.depositar(leerMonto(texto));

            JOptionPane.showMessageDialog(
                    null,
                    "Depósito aceptado. Saldo: $" + cuenta.getSaldo(),
                    "Cajero",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } catch (NumberFormatException e) {
            // Se activa si escriben letras en lugar de números
            JOptionPane.showMessageDialog(
                    null,
                    "Escriba solo números: \"" + texto + "\"",
                    "Dato inválido",
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (IllegalArgumentException e) {
            // Se activa si el monto es menor o igual a cero
            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage(),
                    "Monto inválido",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }
}