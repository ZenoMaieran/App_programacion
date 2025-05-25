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
public class Direccion implements Serializable {

    public Direccion(String calle, int numero, String ciudad, int codigoPostal) {
        this.setCalle(calle);
        this.setCiudad(ciudad);
        this.setNumero(numero);
        this.setCodigoPostal(codigoPostal);
    }

    private String calle;
    private int numero;
    private String ciudad;
    private int codigoPostal;

    /**
     * Get the value of codigoPostal
     *
     * @return the value of codigoPostal
     */
    public int getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Set the value of codigoPostal
     *
     * @param codigoPostal new value of codigoPostal
     */
    public void setCodigoPostal(int codigoPostal) {
        String aux = String.valueOf(codigoPostal);
        if (aux.length() != 5) {
            throw new IllegalArgumentException("El codigo postal es incorrecto (5 digitos).");
        }
        this.codigoPostal = codigoPostal;
    }

    /**
     * Get the value of ciudad
     *
     * @return the value of ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Set the value of ciudad
     *
     * @param ciudad new value of ciudad
     */
    public void setCiudad(String ciudad) {
        if (ciudad == null || ciudad.trim().isEmpty() || !ciudad.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]+")) {
            throw new IllegalArgumentException("El campo de ciudad esta vacio o no tiene caracteres correctos.");
        }
        this.ciudad = ciudad;
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
        if (numero == 0) {
            throw new IllegalArgumentException("El numero introducido no es correcto.");
        }
        this.numero = numero;
    }

    /**
     * Get the value of calle
     *
     * @return the value of calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Set the value of calle
     *
     * @param calle new value of calle
     */
    public void setCalle(String calle) {
        if (calle == null || calle.trim().isEmpty() || !calle.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]+")) {
            throw new IllegalArgumentException("El campo de calle esta vacio o no tiene caracteres correctos.");
        }
        this.calle = calle;
    }

    public static Direccion parsearDireccion(String texto) {
        // Quitar "Direccion{" al principio y "}" al final
        texto = texto.replace("Direccion{", "").replace("}", "");

        // Separar por comas
        String[] partes = texto.split(",");

        String calle = "";
        int numero = 0;
        String ciudad = "";
        int codigoPostal = 0;

        for (String parte : partes) {
            String[] claveValor = parte.trim().split("=");

            if (claveValor.length == 2) {
                String clave = claveValor[0].trim();
                String valor = claveValor[1].trim();

                switch (clave) {
                    case "calle":
                        calle = valor;
                        break;
                    case "numero":
                        numero = Integer.parseInt(valor);
                        break;
                    case "ciudad":
                        ciudad = valor;
                        break;
                    case "codigoPostal":
                        codigoPostal = Integer.parseInt(valor);
                        break;
                }
            }
        }

        return new Direccion(calle, numero, ciudad, codigoPostal);
    }

    @Override
    public String toString() {
        return "Direccion{" + "calle=" + calle + ", numero=" + numero + ", ciudad=" + ciudad + ", codigoPostal=" + codigoPostal + '}';
    }

}
