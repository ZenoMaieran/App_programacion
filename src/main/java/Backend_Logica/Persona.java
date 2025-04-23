/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend_Logica;

/**
 *
 * @author Antonio Zeno Maieran
 */
public class Persona {

    public Persona(String nombre, String correo, String clave) {
        setNombre(nombre);
        setCorreo(correo);
        setClave(clave);
    }

    private String nombre;
    private String correo;
    private String clave;

    /**
     * Get the value of clave
     *
     * @return the value of clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * Set the value of clave
     *
     * @param clave new value of clave
     */
    public void setClave(String clave) {
        if (clave == null || clave.length() < 8) {
            throw new IllegalArgumentException("La clave debe tener al menos 8 caracteres.");
        }
        boolean tieneMayus = false;
        boolean tieneMinus = false;
        boolean tieneNum = false;
        boolean tieneEspecial = false;
        String caracteresEspeciales = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
        for (char c : clave.toCharArray()) {
            if (Character.isUpperCase(c)) {
                tieneMayus = true;
            } else if (Character.isLowerCase(c)) {
                tieneMinus = true;
            } else if (Character.isDigit(c)) {
                tieneNum = true;
            } else if (caracteresEspeciales.indexOf(c) != -1) tieneEspecial = true;
        }
        if(!tieneMayus || !tieneMinus || !tieneNum || !tieneEspecial){
            throw new IllegalArgumentException("La clave debe incluir mayusculas, minusculas, numeros y caracteres especiales. ");
        }
        this.clave = clave;
        
    }

    /**
     * Get the value of correo
     *
     * @return the value of correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Set the value of correo
     *
     * @param correo new value of correo
     */
    public void setCorreo(String correo) {
        if (correo == null || !correo.contains("@")) {
            throw new IllegalArgumentException("Correo electrónico inválido.");
        }
        this.correo = correo;
    }

    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the value of nombre
     *
     * @param nombre new value of nombre
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", correo=" + correo + ", clave=" + clave + '}';
    }
}
