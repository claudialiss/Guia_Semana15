import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class DiseñoB4 {

    public static void main(String[] args) {

        UIManager.put(
                "OptionPane.messageFont",
                new Font("SansSerif", Font.PLAIN, 18));

        String[] plazos = {
                "6 meses",
                "12 meses",
                "24 meses"
        };

        Object seleccion = JOptionPane.showInputDialog(
                null,
                "Plazo del credito:",
                "Credito",
                JOptionPane.QUESTION_MESSAGE,
                null,
                plazos,
                "12 meses");

        if (seleccion == null) {
            JOptionPane.showMessageDialog(null, "Sin seleccion");
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Plazo elegido: " + seleccion);
        }
    }
}
