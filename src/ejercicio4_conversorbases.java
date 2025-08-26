import java.util.Scanner;
import java.math.BigInteger;

public class ejercicio4_conversorbases {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Paso 1: Leer número y base de origen
        System.out.print("Ingrese el número: ");
        String numeroStr = sc.nextLine().trim();

        System.out.print("Ingrese la base de origen (2, 10, 16): ");
        int baseOrigen = sc.nextInt();

        try {
            long valorLong = Long.parseLong(numeroStr, baseOrigen);

            System.out.println("Conversión usando long:");
            System.out.println("Binario: " + Long.toBinaryString(valorLong));
            System.out.println("Decimal: " + valorLong);
        } catch (NumberFormatException e) {
            System.out.println("Número demasiado grande para tipo long, usando BigInteger...");

            try {
                BigInteger valorBig = new BigInteger(numeroStr, baseOrigen);
                System.out.println("Conversión usando BigInteger:");
                System.out.println("Binario: " + valorBig.toString(2));
                System.out.println("Decimal: " + valorBig.toString(10));
            } catch (NumberFormatException ex) {
                System.out.println("Error: el número ingresado no es válido en la base especificada.");
            }
        }

        sc.close();
    }
}
