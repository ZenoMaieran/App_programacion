package Backend_Logica_Eventos;

import java.io.*;
import java.util.ArrayList;

public class GestorArchivosEventos {
    private static final String RUTA_FICHERO = "eventos.dat";

    // Guardar lista de eventos en fichero
    public static void guardarEventos(ArrayList<Evento> eventos) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(RUTA_FICHERO))) {
            out.writeObject(eventos);
        } catch (IOException e) {
            System.err.println("Error al guardar eventos: " + e.getMessage());
        }
    }

    // Leer lista de eventos desde fichero
    public static ArrayList<Evento> cargarEventos() {
        File fichero = new File(RUTA_FICHERO);
        if (!fichero.exists()) return new ArrayList<>(); // Si no existe, devuelve lista vacía

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(RUTA_FICHERO))) {
            return (ArrayList<Evento>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar eventos: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
