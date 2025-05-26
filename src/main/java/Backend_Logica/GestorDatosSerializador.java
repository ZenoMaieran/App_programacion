/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend_Logica;
import java.io.*;
import java.util.ArrayList;
import Backend_Logica_Clientes.Cliente;
import Backend_Logica_Eventos.Evento;
/**
 *
 * @author Antonio Zeno Maieran
 */
public class GestorDatosSerializador {
    private static final String ARCHIVO_USUARIOS = "usuarios.dat";
    private static final String ARCHIVO_CLIENTES = "clientes.dat";

    public static void guardarUsuarios(GestionDatos gestor) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_USUARIOS))) {
            oos.writeObject(gestor.getListaUsuarios()); // ArrayList<Persona>
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void guardarClientes(GestionDatos gestor) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_CLIENTES))) {
            oos.writeObject(gestor.getListaClientes()); // ArrayList<Cliente>
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
public static GestionDatos cargarTodo() {
    GestionDatos gestor = new GestionDatos();

    // Cargar usuarios
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_USUARIOS))) {
        ArrayList<Persona> listaUsuarios = (ArrayList<Persona>) ois.readObject();
        gestor.setListaUsuarios(listaUsuarios);
        System.out.println("Usuarios cargados.");
    } catch (Exception e) {
        System.out.println("No se han cargado los usuarios correctamente, se creará una lista vacía.");
    }

    // Cargar clientes
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_CLIENTES))) {
        ArrayList<Cliente> listaClientes = (ArrayList<Cliente>) ois.readObject();
        gestor.setListaClientes(listaClientes);
        System.out.println("Clientes cargados.");
    } catch (Exception e) {
        System.out.println("No se han cargado los clientes correctamente, se creará una lista vacía.");
    }

    // Cargar eventos
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("eventos.dat"))) {
        ArrayList<Evento> listaEventos = (ArrayList<Evento>) ois.readObject();
        gestor.setListaEventos(listaEventos);
        System.out.println("Eventos cargados.");
    } catch (Exception e) {
        System.out.println("No se han cargado los eventos correctamente, se creará una lista vacía.");
    }

    return gestor;
}

}

