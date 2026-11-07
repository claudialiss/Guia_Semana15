public class Ej4 {

    static int dividirCuota(int total, int meses) {
        if (meses <= 0) {
            throw new IllegalArgumentException("meses debe ser positivo");
        }

        System.out.println(" dividiendo " + total + " en " + meses);
        return total / meses;
    }

    static int planPago(int total, int meses) {
        System.out.println(" plan para " + meses + " meses");
        int cuota = dividirCuota(total, meses);
        System.out.println(" cuota calculada");
        return cuota;
    }

    public static void main(String[] args) {

        int[] opciones = {4, 0};

        for (int m : opciones) {
            try {
                System.out.println("Cuota: " + planPago(120, m));
            } catch (IllegalArgumentException e) {
                System.out.println("Plan rechazado: " + e.getMessage());
            }
        }
    }
}
