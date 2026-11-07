import javax.swing.JOptionPane;

public class Dialogos {

    // Método para mostrar las opciones personalizadas de la imagen
    static void opciones() {
        // Arreglo con los textos de los botones que aparecerán en la ventana
        String[] ops = { "Depositar", "Retirar", "Salir" };

        int i = JOptionPane.showOptionDialog(
                null,
                "Que desea hacer?",
                "Cajero",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                ops,
                ops[0]
        );

        // Si el usuario hace clic en una opción (índice 0 o mayor) y no cierra la ventana
        if (i >= 0) {
            JOptionPane.showMessageDialog(null, "Eligio: " + ops[i]);
        }
    }

    // Método principal para poder ejecutarlo en IntelliJ
    public static void main(String[] args) {
        opciones();
    }
}