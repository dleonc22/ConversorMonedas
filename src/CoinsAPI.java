import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CoinsAPI {
    private static final String API_KEY = "175a084abc6bdf7d66e54376";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public Coins checkCoins(String baseCurrency, String targetCurrency) {
        URI api = URI.create(BASE_URL + baseCurrency);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(api)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JsonObject jsonResponse = new Gson().fromJson(response.body(), JsonObject.class);
                JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");
                double conversionRate = conversionRates.get(targetCurrency).getAsDouble();
                return new Coins(conversionRate);
            } else {
                throw new RuntimeException("Error en la respuesta de la API: " + response.statusCode());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error durante la solicitud HTTP: " + e.getMessage(), e);
        }
    }
}