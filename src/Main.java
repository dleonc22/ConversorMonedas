import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        CoinsAPI consult = new CoinsAPI();

        int opcion = 0;
        while (opcion != 9) {
            mostrarMenu();
            try {
                opcion = Integer.parseInt(read.nextLine());

                switch (opcion) {
                    case 1:
                        Converter.currencyConverter("USD", "CRC", consult, read);
                        break;
                    case 2:
                        Converter.currencyConverter("CRC", "USD", consult, read);
                        break;
                    case 3:
                        Converter.currencyConverter("USD", "EUR", consult, read);
                        break;
                    case 4:
                        Converter.currencyConverter("EUR", "USD", consult, read);
                        break;
                    case 5:
                        Converter.currencyConverter("USD", "ARS", consult, read);
                        break;
                    case 6:
                        Converter.currencyConverter("ARS", "USD", consult, read);
                        break;
                    case 9:
                        System.out.println("Finalizando programa, hasta luego.");
                        break;
                    default:
                        System.out.println("Opción no válida. Digite un número del menú.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
            }
        }
        read.close();
    }

    private static void mostrarMenu() {
        System.out.println("""
                ***Bienvenido/a al Conversor de Monedas***
                Digite la opción que desea realizar:
                1. Dolares USA a Colones CR
                2. Colones CR a Dolares USA
                3. Dolares USA a Euros ESP
                4. Euros ESP a Dolares USA
                5. Dolares USA a Pesos ARG
                6. Pesos ARG a Dolares USA
                9. SALIR
                """);
    }
}