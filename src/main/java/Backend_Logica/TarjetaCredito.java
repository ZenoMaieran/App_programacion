/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend_Logica;

import java.time.LocalDateTime;

/**
 *
 * @author Antonio Zeno Maieran
 */
public class TarjetaCredito {

    public TarjetaCredito(String nombreTitular, int numero, LocalDateTime fechaCaducidad) {
        this.nombreTitular = nombreTitular;
        this.numero = numero;
        this.fechaCaducidad = fechaCaducidad;
    }
    
    private String nombreTitular;
    private int numero;
    private LocalDateTime fechaCaducidad;

    /**
     * Get the value of fechaCaducidad
     *
     * @return the value of fechaCaducidad
     */
    public LocalDateTime getFechaCaducidad() {
        return fechaCaducidad;
    }

    /**
     * Set the value of fechaCaducidad
     *
     * @param fechaCaducidad new value of fechaCaducidad
     */
    public void setFechaCaducidad(LocalDateTime fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }


    /**
     * Get the value of numero
     *
     * @return the value of numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Set the value of numero
     *
     * @param numero new value of numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }


    /**
     * Get the value of nombreTitular
     *
     * @return the value of nombreTitular
     */
    public String getNombreTitular() {
        return nombreTitular;
    }

    /**
     * Set the value of nombreTitular
     *
     * @param nombreTitular new value of nombreTitular
     */
    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    @Override
    public String toString() {
        return "TarjetaCredito{" + "nombreTitular=" + nombreTitular + ", numero=" + numero + ", fechaCaducidad=" + fechaCaducidad + '}';
    }
    

}
