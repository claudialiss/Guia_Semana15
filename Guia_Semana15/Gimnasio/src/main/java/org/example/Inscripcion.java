public class Inscripcion {

    static void validarEdad(int edad) {
        if (edad < 16 || edad > 80) {
            throw new IllegalArgumentException(
                    "Edad fuera de rango: " + edad);
        }
    }

    public static void main(String[] args) {

        int[] edades = {25, 12, 40, 95};
        int aceptados = 0;

        for (int e : edades) {
            try {
                validarEdad(e);
                aceptados++;
                System.out.println(e + ": inscrito");
            } catch (IllegalArgumentException ex) {
                System.out.println(e + ": " + ex.getMessage());
            }
        }

        System.out.println("Aceptados: " + aceptados);
    }
}