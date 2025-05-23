/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend_Logica_Eventos;

import Backend_Logica.Direccion;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Antonio Zeno Maieran
 */
public class Evento implements Serializable {
    private static final long serialVersionUID = 1L; // Para serialización segura
    public Evento(String titulo, String tipo, Direccion direccion, LocalDateTime fecha, double precio, int calificacion) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.direccion = direccion;
        this.fecha = fecha;
        this.precio = precio;
        this.calificacion = calificacion;
        //this.tickets = tickets;
    }
    
    private String titulo;
    private String tipo;    
    private Direccion direccion;
    private LocalDateTime fecha;
    private double precio;
    private int calificacion;
    //private int tickets;

    /**
     * Get the value of tickets
     *
     * @return the value of tickets
     */
    /*
    public int getTickets() {
        return tickets;
    }

    /**
     * Set the value of tickets
     *
     * @param tickets new value of tickets
     */
    /*
    public void setTickets(int tickets) {
        this.tickets = tickets;
    }
    

    /**
     * Get the value of calificacion
     *
     * @return the value of calificacion
     */
    public int getCalificacion() {
        return calificacion;
    }

    /**
     * Set the value of calificacion
     *
     * @param calificacion new value of calificacion
     */
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }


    /**
     * Get the value of precio
     *
     * @return the value of precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Set the value of precio
     *
     * @param precio new value of precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }


    /**
     * Get the value of fecha
     *
     * @return the value of fecha
     */
    public LocalDateTime getFecha() {
        return fecha;
    }

    /**
     * Set the value of fecha
     *
     * @param fecha new value of fecha
     */
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }


    /**
     * Get the value of direccion
     *
     * @return the value of direccion
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * Set the value of direccion
     *
     * @param direccion new value of direccion
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }


    /**
     * Get the value of tipo
     *
     * @return the value of tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Set the value of tipo
     *
     * @param tipo new value of tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Get the value of Titulo
     *
     * @return the value of Titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Set the value of Titulo
     *
     * @param Titulo new value of Titulo
     */
    public void setTitulo(String Titulo) {
        this.titulo = Titulo;
    }

}
