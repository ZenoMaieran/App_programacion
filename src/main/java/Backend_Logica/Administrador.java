/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend_Logica;
import java.io.Serializable;
/**
 *
 * @author Antonio Zeno Maieran
 */
public class Administrador extends Persona implements Serializable  {

    public Administrador(String nombre, String correo, String clave) {
        super(nombre, correo, clave);
    }
    
}