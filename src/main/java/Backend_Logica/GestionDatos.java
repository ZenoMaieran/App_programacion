/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend_Logica;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author anton
 */
public class GestionDatos implements Serializable{

    public GestionDatos() {
        this.listaUsuarios = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
    }
    
    private ArrayList listaUsuarios; 
    private ArrayList listaClientes;

    /**
     * Get the value of listaClientes
     *
     * @return the value of listaClientes
     */
    public ArrayList getListaClientes() {
        return listaClientes;
    }

    /**
     * Set the value of listaClientes
     *
     * @param listaClientes new value of listaClientes
     */
    public void setListaClientes(ArrayList listaClientes) {
        this.listaClientes = listaClientes;
    }


    /**
     * Get the value of listaUsuarios
     *
     * @return the value of listaUsuarios
     */
    public ArrayList getListaUsuarios() {
        return listaUsuarios;
    }

    /**
     * Set the value of listaUsuarios
     *
     * @param listaUsuarios new value of listaUsuarios
     */
    public void setListaUsuarios(ArrayList listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    public void agregarUsuario(Persona usuario){
        if (!listaUsuarios.contains(usuario)){
            listaUsuarios.add(usuario);
        } else {
            System.out.println("El usuario ya ha sido registrado anteriormente. ");
        }
    }
    public void agregarCliente(Cliente cliente){
        if (!listaClientes.contains(cliente)){
            listaClientes.add(cliente);
        } else {
            System.out.println("El cliente ya ha sido registrado anteriormente");
        }
    }

}
