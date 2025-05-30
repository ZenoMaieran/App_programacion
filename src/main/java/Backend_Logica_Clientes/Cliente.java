/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend_Logica_Clientes;
import Backend_Logica.Direccion;
import Backend_Logica.Persona;
import Backend_Logica.TarjetaCredito;
import Backend_Logica_Reservas.Reserva;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Antonio Zeno Maieran
 */
public class Cliente extends Persona implements Serializable {

    public Cliente(Direccion direccion, TarjetaCredito tarjetaCredito, String telefono, boolean vip, String nombre, String correo, String clave) {
        super(nombre, correo, clave);
        this.setDireccion(direccion);
        this.setTarjetaCredito(tarjetaCredito);
        this.setTelefono(telefono);
        this.setVip(vip);
    }
    
    
    private Direccion direccion;
    private TarjetaCredito tarjetaCredito;
    private String telefono;
    private boolean vip;
    private ArrayList<Reserva> listaReservas;

    /**
     * Get the value of listaReservas
     *
     * @return the value of listaReservas
     */
    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    /**
     * Set the value of listaReservas
     *
     * @param listaReservas new value of listaReservas
     */
    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }


    /**
     * Get the value of vip
     *
     * @return the value of vip
     */
    public boolean isVip() {
        return this.vip;
    }

    /**
     * Set the value of vip
     *
     * @param vip new value of vip
     */
    public void setVip(boolean vip) {
        this.vip = vip;
    }


    /**
     * Get the value of telefono
     *
     * @return the value of telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Set the value of telefono
     *
     * @param telefono new value of telefono
     */
    public void setTelefono(String telefono) {
        if (telefono == null || telefono.length() < 9) {
            System.out.println("Teléfono no válido.");
        } else {
            this.telefono = telefono;
        }
}

    /**
     * Get the value of tarjetaCredito
     *
     * @return the value of tarjetaCredito
     */
    public TarjetaCredito getTarjetaCredito() {
        return tarjetaCredito;
    }

    /**
     * Set the value of tarjetaCredito
     *
     * @param tarjetaCredito new value of tarjetaCredito
     */
    public void setTarjetaCredito(TarjetaCredito tarjetaCredito) {
        if (tarjetaCredito == null) {
            System.out.println("La tarjeta de crédito no puede ser nula.");
        } else {
            this.tarjetaCredito = tarjetaCredito;
        }
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
        if (direccion == null) {
        System.out.println("La dirección no puede ser nula.");
        } else {
           this.direccion = direccion;
        }
}
    
    
    public String getId() {
        return getCorreo();
}

    @Override
    public String toString() {
        return "Cliente{" + "direccion=" + direccion + ", tarjetaCredito=" + tarjetaCredito + ", telefono=" + telefono + ", vip=" + vip + ", listaReservas=" + listaReservas + '}';
    }



}
