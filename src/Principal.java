import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consultaMoneda = new ConsultaMoneda();
        ConversorDeMoneda conversor = new ConversorDeMoneda();
        GeneradorDeArchivoJson generadorJson = new GeneradorDeArchivoJson();
        List<Conversion> historial = new ArrayList<>();

        System.out.println("*****************************************");
        System.out.println("Bienvenido a nuestro conversor de monedas");

        String menu = """
                *** Escriba el número de la opción deseada ***
                1) Dólar a Peso Argentino
                2) Peso Argentino a Dólar
                3) Dólar a Real Brasileño
                4) Real Brasileño a Dólar
                5) Dólar a Peso Colombiano
                6) Peso Colombiano a Dólar
                7) Dólar a Euro
                8) Euro a Dólar
                9) Dólar a Peso Chileno
                10) Peso Chileno a Dólar
                11) Ingresar un par de divisas personalizado
                12) Mostrar historial de conversiones
                13) Guardar historial en archivo JSON
                14) Salir
                Eliga una opción:
                """;

        boolean salir = false;
        while (!salir) {
            System.out.println(menu);
            int opcion = lectura.nextInt();

            String divisaOrigen = "";
            String divisaDestino = "";

            switch (opcion) {
                case 1:
                    divisaOrigen = "USD";
                    divisaDestino = "ARS";
                    break;
                case 2:
                    divisaOrigen = "ARS";
                    divisaDestino = "USD";
                    break;
                case 3:
                    divisaOrigen = "USD";
                    divisaDestino = "BRL";
                    break;
                case 4:
                    divisaOrigen = "BRL";
                    divisaDestino = "USD";
                    break;
                case 5:
                    divisaOrigen = "USD";
                    divisaDestino = "COP";
                    break;
                case 6:
                    divisaOrigen = "COP";
                    divisaDestino = "USD";
                    break;
                case 7:
                    divisaOrigen = "USD";
                    divisaDestino = "EUR";
                    break;
                case 8:
                    divisaOrigen = "EUR";
                    divisaDestino = "USD";
                    break;
                case 9:
                    divisaOrigen = "USD";
                    divisaDestino = "CLP";
                    break;
                case 10:
                    divisaOrigen = "CLP";
                    divisaDestino = "USD";
                    break;
                case 11:
                    // Opción para ingresar un par de divisas personalizado
                    System.out.print("Ingrese la divisa de origen (por ejemplo, USD, EUR): ");
                    String divisaOrigenPersonalizada = lectura.next();
                    System.out.print("Ingrese la divisa de destino (por ejemplo, USD, EUR): ");
                    String divisaDestinoPersonalizada = lectura.next();
                    realizarConversion(lectura, conversor, consultaMoneda, historial, divisaOrigenPersonalizada, divisaDestinoPersonalizada);
                    continue;
                case 12:
                    mostrarHistorial(historial);
                    continue;
                case 13:
                    generadorJson.guardarConversion(historial);
                    System.out.println("Historial guardado en archivo JSON.");
                    continue;
                case 14:
                    salir = true;
                    System.out.println("Gracias por su preferencia.");
                    continue;
                default:
                    System.out.println("Opción ingresada no es válida. Intente nuevamente.");
                    continue;
            }

            // Realizar la conversión seleccionada
            realizarConversion(lectura, conversor, consultaMoneda, historial, divisaOrigen, divisaDestino);
        }

        // Guardar el historial al salir, si no está vacío
        if (!historial.isEmpty()) {
            generadorJson.guardarConversion(historial);
            System.out.println("Historial guardado en archivo JSON.");
        }

        lectura.close();
    }

    private static void realizarConversion(Scanner lectura, ConversorDeMoneda conversor,
                                           ConsultaMoneda consultaMoneda, List<Conversion> historial,
                                           String divisaOrigen, String divisaDestino) {
        System.out.print("Ingrese el valor a convertir: ");
        double montoAConvertir = lectura.nextDouble();

        if (montoAConvertir < 0) {
            System.out.println("La cantidad a convertir debe ser positiva.");
            return;
        }

        // Obtener tasas de cambio
        Map<String, Double> tasas = consultaMoneda.obtenerTasas(divisaOrigen);
        if (tasas == null || !tasas.containsKey(divisaDestino)) {
            System.out.println("Error al obtener las tasas de cambio. Intente nuevamente.");
            return;
        }

        // Realizar conversión
        double resultado = conversor.convertir(montoAConvertir, divisaOrigen, divisaDestino, tasas);
        System.out.printf("Resultado: %.2f %s = %.2f %s\n", montoAConvertir, divisaOrigen, resultado, divisaDestino);

        // Guardar en el historial
        historial.add(new Conversion(montoAConvertir, divisaOrigen, divisaDestino, resultado));
    }

    private static void mostrarHistorial(List<Conversion> historial) {
        System.out.println("\n=== Historial de Conversiones ===");
        if (historial.isEmpty()) {
            System.out.println("No hay conversiones registradas.");
        } else {
            for (Conversion conversion : historial) {
                System.out.printf("%.2f %s a %s: %.2f\n",
                        conversion.getCantidad(), conversion.getDivisaOrigen(),
                        conversion.getDivisaDestino(), conversion.getResultado());
            }
        }
    }
}