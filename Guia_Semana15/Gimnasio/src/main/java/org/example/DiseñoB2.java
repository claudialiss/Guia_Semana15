import javax.swing.JOptionPane;

public class DiseñoB2 {

    public static void main(String[] args) {

        int r = JOptionPane.showConfirmDialog(
                null,
                "Desea salir del cajero?",
                "Salir",
                JOptionPane.YES_NO_CANCEL_OPTION);

        if (r == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Hasta pronto");
        } else if (r == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Continuemos");
        } else {
            JOptionPane.showMessageDialog(null, "Operacion cancelada");
        }
    }
}