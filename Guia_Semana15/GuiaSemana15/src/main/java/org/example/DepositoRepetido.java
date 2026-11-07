import javax.swing.JOptionPane;

public class DepositoRepetido {
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta("Ana", 100);
        boolean listo = false;

        // El ciclo se repite mientras 'listo' sea falso
        while (!listo) {
            String texto = JOptionPane.showInputDialog("Monto a depositar:");

            if (texto == null) {
                return; // Si el usuario presiona Cancelar, el programa termina de forma segura
            }

            try {
                // Intenta validar y depositar usando el método que creamos en DepositoGUI
                cuenta.depositar(Deposito.leerMonto(texto));
                listo = true; // Si todo sale bien, cambia a true para romper el ciclo

            } catch (NumberFormatException e) {
                // Si escribe letras, muestra el aviso y el ciclo 'while' vuelve a empezar
                JOptionPane.showMessageDialog(null, "Escriba solo numeros");

            } catch (IllegalArgumentException e) {
                // Si escribe un número negativo o cero, muestra el error y vuelve a empezar
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

        // Al salir del ciclo (cuando ya se hizo el depósito con éxito), muestra el saldo final
        JOptionPane.showMessageDialog(null, "Saldo: $" + cuenta.getSaldo());
    }
}