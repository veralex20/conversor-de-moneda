import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import com.google.gson.Gson;

public class ConsultaMoneda {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    /**
     * Obtiene las tasas de cambio para una divisa base específica.
     *
     * @param base La divisa base (código ISO).
     * @return Un mapa de tasas de cambio.
     */
    public Map<String, Double> obtenerTasas(String base) {
        try {
            URL url = new URL(API_URL + base);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Verificar la respuesta
            int respuesta = conn.getResponseCode();
            if (respuesta != 200) {
                System.out.println("Error en la conexión: Código " + respuesta);
                return null;
            }

            // Parsear la respuesta JSON
            Gson gson = new Gson();
            ApiResponse apiResponse = gson.fromJson(new InputStreamReader(conn.getInputStream()), ApiResponse.class);
            return apiResponse.getRates();
        } catch (Exception e) {
            System.out.println("Exception en obtenerTasas: " + e.getMessage());
            return null;
        }
    }

    // Clase interna para mapear la respuesta de la API
    private class ApiResponse {
        private String base;
        private String date;
        private Map<String, Double> rates;

        public String getBase() {
            return base;
        }

        public String getDate() {
            return date;
        }

        public Map<String, Double> getRates() {
            return rates;
        }
    }
}