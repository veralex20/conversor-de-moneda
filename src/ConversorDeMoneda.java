import java.util.Map;

public class ConversorDeMoneda {
    /**
     * Convierte una cantidad de una divisa a otra utilizando las tasas proporcionadas.
     *
     * @param cantidad      La cantidad a convertir.
     * @param divisaOrigen  La divisa de origen (código ISO).
     * @param divisaDestino La divisa de destino (código ISO).
     * @param tasas         Mapa de tasas de cambio con la divisa como clave y la tasa como valor.
     * @return La cantidad convertida.
     */
    public double convertir(double cantidad, String divisaOrigen, String divisaDestino, Map<String, Double> tasas) {
        double tasaOrigen = tasas.getOrDefault(divisaOrigen, 1.0);
        double tasaDestino = tasas.getOrDefault(divisaDestino, 1.0);
        return cantidad * (tasaDestino / tasaOrigen);
    }
}