/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend_Logica;

/**
 *
 * @author Antonio Zeno Maieran
 */
public class Cliente extends Persona {

    public Cliente(Direccion direccion, TarjetaCredito tarjetaCredito, int telefono, boolean vip, String nombre, String correo, String clave) {
        super(nombre, correo, clave);
        this.direccion = direccion;
        this.tarjetaCredito = tarjetaCredito;
        this.telefono = telefono;
        this.vip = vip;
    }
    
    private Direccion direccion;
    private TarjetaCredito tarjetaCredito;
    private int telefono;
    private boolean vip;

    /**
     * Get the value of vip
     *
     * @return the value of vip
     */
    public boolean isVip() {
        return vip;
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
    public int getTelefono() {
        return telefono;
    }

    /**
     * Set the value of telefono
     *
     * @param telefono new value of telefono
     */
    public void setTelefono(int telefono) {
        String aux = String.valueOf(telefono);
        if (aux.length() != 9){
            throw new IllegalArgumentException("El telefono es incorrecto (9 digitos).");
        }
        this.telefono = telefono;
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
        this.tarjetaCredito = tarjetaCredito;
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

    @Override
    public String toString() {
        return "Cliente{" + "direccion=" + direccion + ", tarjetaCredito=" + tarjetaCredito + ", telefono=" + telefono + ", vip=" + vip + '}';
    }

    
}
