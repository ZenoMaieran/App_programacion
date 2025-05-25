/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend_Logica;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author Antonio Zeno Maieran
 */
public class GestorDatosSerializador {
    private static final String ARCHIVO = "usuarios.dat";
    
    public static void guardar(GestionDatos gestor) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
             oos.writeObject(gestor.getListaUsuarios());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static GestionDatos cargar() { 
        GestionDatos gestor = new GestionDatos();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            ArrayList<Persona> lista = (ArrayList<Persona>) ois.readObject();
            gestor.setListaUsuarios(lista);
            System.out.println("Usuarios cargados.");
         } catch (Exception e){
             System.out.println("No se han cargado los usuarios correctamente, se hara una lista vacia.");
         }
        return gestor;
    }
    public static GestionDatos cargarClientes() { 
        GestionDatos gestor = new GestionDatos();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            ArrayList<Cliente> lista = (ArrayList<Cliente>) ois.readObject();
            gestor.setListaUsuarios(lista);
            System.out.println("Clientes cargados.");
         } catch (Exception e){
             System.out.println("No se han cargado los clientes correctamente, se hara una lista vacia.");
         }
        return gestor;
    }
}

