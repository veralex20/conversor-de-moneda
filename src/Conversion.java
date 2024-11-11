public class Conversion {
    private double cantidad;
    private String divisaOrigen;
    private String divisaDestino;
    private double resultado;

    public Conversion(double cantidad, String divisaOrigen, String divisaDestino, double resultado) {
        this.cantidad = cantidad;
        this.divisaOrigen = divisaOrigen;
        this.divisaDestino = divisaDestino;
        this.resultado = resultado;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getDivisaOrigen() {
        return divisaOrigen;
    }

    public String getDivisaDestino() {
        return divisaDestino;
    }

    public double getResultado() {
        return resultado;
    }
}