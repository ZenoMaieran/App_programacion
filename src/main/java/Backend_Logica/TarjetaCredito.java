/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend_Logica;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Antonio Zeno Maieran
 */
public class TarjetaCredito implements Serializable {

    public TarjetaCredito(String nombreTitular, String numero, LocalDate fechaCaducidad, double dinero) {
        this.nombreTitular = nombreTitular;
        this.numero = numero;
        this.fechaCaducidad = fechaCaducidad;
        this.dinero = dinero;
    }
    
    private String nombreTitular;
    private String numero;   //int a String porque int no soporta un número enorme
    private LocalDate fechaCaducidad;
    
    private double dinero;

    /**
     * Get the value of dinero
     *
     * @return the value of dinero
     */
    public double getDinero() {
        return dinero;
    }

    /**
     * Set the value of dinero
     *
     * @param dinero new value of dinero
     */
    public void setDinero(double dinero) {
        this.dinero = dinero;
    }


    /**
     * Get the value of fechaCaducidad
     *
     * @return the value of fechaCaducidad
     */
    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    /**
     * Set the value of fechaCaducidad
     *
     * @param fechaCaducidad new value of fechaCaducidad
     */
    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        if (fechaCaducidad == null || fechaCaducidad.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de caducidad debe estar en el futuro.");
        }
        this.fechaCaducidad = fechaCaducidad;
    }


    /**
     * Get the value of numero
     *
     * @return the value of numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Set the value of numero
     *
     * @param numero new value of numero
     */
    public void setNumero(String numero) {
        if (numero == null || !numero.matches("\\d{16}")) {
            throw new IllegalArgumentException("El número de tarjeta debe tener exactamente 16 dígitos.");
        }
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
        if (nombreTitular == null || nombreTitular.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del titular no puede estar vacío.");
        }
        this.nombreTitular = nombreTitular;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "TarjetaCredito{" + "nombreTitular=" + nombreTitular + ", numero=" + numero + ", fechaCaducidad=" + fechaCaducidad + '}';
    }
    

}
