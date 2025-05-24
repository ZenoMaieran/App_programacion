package Backend_Logica_Reservas;

import java.io.*;
import java.util.ArrayList;

public class GestorArchivosReservas {
    private static final String RUTA_RESERVAS = "reservas.dat";

    public static void guardarReservas(ArrayList<Reserva> reservas) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(RUTA_RESERVAS))) {
            out.writeObject(reservas);
        } catch (IOException e) {
            System.err.println("Error al guardar reservas: " + e.getMessage());
        }
    }

    public static ArrayList<Reserva> cargarReservas() {
        File archivo = new File(RUTA_RESERVAS);
        if (!archivo.exists()) return new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(RUTA_RESERVAS))) {
            return (ArrayList<Reserva>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar reservas: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
