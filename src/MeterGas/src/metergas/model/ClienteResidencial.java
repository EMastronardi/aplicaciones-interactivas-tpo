/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.model;

/**
 *
 * @author Checho
 */
public class ClienteResidencial extends Cliente {
    
    String nombre;
    String apellido;
    int edad;

    public Cliente(String nombre){
        this.nombre = nombre;
    }
    
    public Cliente(String nombre, int edad){
        Cliente(nombre);
        this.setEdad(edad);
    }
    
    public void setEdad(int edad){
        this.edad = edad;
    }
}

