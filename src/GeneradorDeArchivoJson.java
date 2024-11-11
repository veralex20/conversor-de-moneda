import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeneradorDeArchivoJson {
    public static final String ARCHIVO_HISTORIAL = "historial.json";
    private final Gson gson;

    public GeneradorDeArchivoJson() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    /**
     * Guarda el historial de conversiones en un archivo JSON.
     *
     * @param historial Lista de conversiones realizadas.
     */
    public void guardarConversion(List<Conversion> historial) {
        try (FileWriter writer = new FileWriter(ARCHIVO_HISTORIAL)) {
            gson.toJson(historial, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar el historial: " + e.getMessage());
        }
    }
}