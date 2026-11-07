import javax.swing.JOptionPane;

public class MenuPrincipal {

    public static void main(String[] args) {
        // 1. Inicializamos nuestra clase molde Cuenta con un saldo inicial
        Cuenta cuenta = new Cuenta("Ana", 100);
        boolean salir = false;

        // 2. Ciclo principal para mantener el cajero abierto hasta que el usuario decida salir
        while (!salir) {
            String[] ops = { "Depositar", "Retirar", "Ver Saldo", "Opciones Extra (Listas)", "Salir" };

            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Saldo actual: $" + cuenta.getSaldo() + "\n¿Qué desea hacer?",
                    "Cajero Automático - Principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    ops,
                    ops[0]
            );

            // Evaluamos qué botón presionó el usuario
            switch (seleccion) {
                case 0: // Depositar (con repetición si hay error)
                    realizarDeposito(cuenta);
                    break;

                case 1: // Retirar (con confirmación y control de excepciones)
                    realizarRetiro(cuenta);
                    break;

                case 2: // Ver Saldo
                    JOptionPane.showMessageDialog(null, "Su saldo actual es: $" + cuenta.getSaldo(), "Saldo", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 3: // Probar la lista desplegable que vimos en los diálogos
                    probarListaDesplegable();
                    break;

                default: // Si selecciona "Salir" o cierra la ventana (X)
                    salir = true;
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema. ¡Hasta luego!");
                    break;
            }
        }
    }

    // --- MÉTODO PARA DEPOSITAR (Reutiliza la lógica de validación repetida) ---
    static void realizarDeposito(Cuenta cuenta) {
        boolean listo = false;
        while (!listo) {
            String texto = JOptionPane.showInputDialog("Monto a depositar:");
            if (texto == null) return; // Si cancela, regresa al menú principal

            try {
                int monto = Integer.parseInt(texto.trim());
                if (monto <= 0) {
                    throw new IllegalArgumentException("El monto debe ser mayor que cero");
                }

                cuenta.depositar(monto);
                JOptionPane.showMessageDialog(null, "Depósito aceptado. Nuevo saldo: $" + cuenta.getSaldo());
                listo = true; // Rompe el ciclo si todo salió bien

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Escriba solo números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Monto inválido", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    // --- MÉTODO PARA RETIRAR (Integra showConfirmDialog y excepciones de saldo) ---
    static void realizarRetiro(Cuenta cuenta) {
        String texto = JOptionPane.showInputDialog("Monto a retirar:");
        if (texto == null) return;

        try {
            int monto = Integer.parseInt(texto.trim());
            if (monto <= 0) {
                throw new IllegalArgumentException("El monto debe ser mayor que cero");
            }

            // Pedimos confirmación antes de aplicar el retiro
            int confirmacion = JOptionPane.showConfirmDialog(
                    null,
                    "¿Confirma el retiro de $" + monto + "?",
                    "Confirmar Retiro",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirmacion == JOptionPane.YES_OPTION) {
                cuenta.retirar(monto); // Esto puede lanzar IllegalStateException si no hay saldo
                JOptionPane.showMessageDialog(null, "Retiro exitoso. Saldo restante: $" + cuenta.getSaldo());
            } else {
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Escriba solo números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException | IllegalStateException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error en el retiro", JOptionPane.WARNING_MESSAGE);
        }
    }

    // --- MÉTODO PARA PROBAR EL DIÁLOGO CON LISTA DESPLEGABLE ---
    static void probarListaDesplegable() {
        String[] tipos = { "Ahorro", "Corriente", "Plazo fijo" };
        Object t = JOptionPane.showInputDialog(
                null,
                "Seleccione el tipo de cuenta:",
                "Apertura / Consulta",
                JOptionPane.QUESTION_MESSAGE,
                null,
                tipos,
                tipos[0]
        );

        if (t != null) {
            JOptionPane.showMessageDialog(null, "Has consultado la cuenta de tipo: " + t);
        }
    }
}
