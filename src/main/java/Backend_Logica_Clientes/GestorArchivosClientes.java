package Backend_Logica_Clientes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GestorArchivosClientes {
    private static final String RUTA_CLIENTES = "clientes.dat";

    public static ArrayList<Cliente> cargarClientes() throws ClassNotFoundException {
        File archivo = new File(RUTA_CLIENTES);
        if (!archivo.exists()) return new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(RUTA_CLIENTES))) {
            return (ArrayList<Cliente>) in.readObject();
        } catch (IOException e) {
            System.err.println("Error al cargar clientes: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void guardarClientes(ArrayList<Cliente> clientes) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(RUTA_CLIENTES))) {
            out.writeObject(clientes);
        } catch (IOException e) {
            System.err.println("Error al guardar clientes: " + e.getMessage());
        }
    }
}
