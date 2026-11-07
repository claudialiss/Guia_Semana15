import javax.swing.JOptionPane;

public class Entrada {

    static int validarEntero(String texto, int min, int max) {
        int valor = Integer.parseInt(texto.trim());
        if (valor < min || valor > max) {
            throw new IllegalArgumentException(
                    "Debe estar entre " + min + " y " + max);
        }
        return valor;
    }

    static int leerEntero(String mensaje, int min, int max) {
        while (true) {
            String texto = JOptionPane.showInputDialog(mensaje);
            if (texto == null) {
                throw new IllegalStateException("Operacion cancelada");
            }

            try {
                return validarEntero(texto, min, max);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Escriba solo numeros",
                        "Dato invalido",
                        JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(
                        null,
                        e.getMessage(),
                        "Fuera de rango",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
