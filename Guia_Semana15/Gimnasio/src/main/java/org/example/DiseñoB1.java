import javax.swing.JOptionPane;

public class DiseñoB1 {

    static void diseno1() {

        JOptionPane.showMessageDialog(
                null,
                "<html>Horario de atencion:<br>lunes a viernes, 8:00 a 16:00</html>",
                "Aviso importante",
                JOptionPane.WARNING_MESSAGE);
    }

    public static void main(String[] args) {
        diseno1();
    }
}