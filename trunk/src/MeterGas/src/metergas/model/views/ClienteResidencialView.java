/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.model.views;

/**
 *
 * @author Checho
 */
public class ClienteResidencialView extends ClienteView {
    private String nombre;
    private String apellido;
    private String dni;

    public ClienteResidencialView(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }
    
    
}
