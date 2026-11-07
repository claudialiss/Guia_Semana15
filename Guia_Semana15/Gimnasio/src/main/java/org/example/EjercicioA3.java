public class EjercicioA3 {

    public static void validarEdad(int edad) {
        if (edad < 16 || edad > 80) {
            throw new IllegalArgumentException(
                    "Edad fuera de rango: " + edad);
        }
    }

    public static void main(String[] args) {

        int[] edades = {25, 12, 40, 95};
        int aceptados = 0;

        for (int edad : edades) {
            try {
                validarEdad(edad);
                System.out.println(edad + " -> Aceptado");
                aceptados++;
            } catch (IllegalArgumentException e) {
                System.out.println(edad + " -> " + e.getMessage());
            }
        }

        System.out.println("Total aceptados: " + aceptados);
    }
}