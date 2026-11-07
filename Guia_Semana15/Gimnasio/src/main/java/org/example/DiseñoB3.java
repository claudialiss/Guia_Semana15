import javax.swing.JOptionPane;

public class DiseñoB3 {

    public static void main(String[] args) {

        String[] opciones = {
                "Consultar saldo",
                "Depositar",
                "Salir"
        };

        int r = JOptionPane.showOptionDialog(
                null,
                "Seleccione una operacion",
                "Menu principal",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);

        if (r == JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(null, "Ventana cerrada");
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Opcion: " + opciones[r]);
        }
    }
}