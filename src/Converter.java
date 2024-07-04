import java.util.Scanner;
import java.text.DecimalFormat;

public class Converter {
    public static void currencyConverter(String baseCurrency, String targetCurrency, CoinsAPI api, Scanner read) {
        try {
            Coins coins = api.checkCoins(baseCurrency, targetCurrency);
            System.out.println("La tasa de conversión " + baseCurrency + " a " + targetCurrency + " es " + coins.conversion_rate());
            System.out.println("Ingrese el valor que deseas convertir:");

            double value = Double.parseDouble(read.nextLine());
            double total = value * coins.conversion_rate();
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.println(value + " " + baseCurrency + " = " + df.format(total) + " " + targetCurrency);
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Por favor, ingrese un número.");
        } catch (RuntimeException e) {
            System.out.println("Error al realizar la conversión: " + e.getMessage());
        }
    }
}
