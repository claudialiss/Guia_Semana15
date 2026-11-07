public class PruebaEntrada {

    public static void main(String[] args) {

        String[] casos = { "18", "edad", "150", " 65 " };

        for (String c : casos) {
            try {
                System.out.println("\"" + c + "\" -> "
                        + Entrada.validarEntero(c, 16, 80));
            } catch (NumberFormatException e) {
                System.out.println("\"" + c + "\" -> no es numero");
            } catch (IllegalArgumentException e) {
                System.out.println("\"" + c + "\" -> " + e.getMessage());
            }
        }
    }
}