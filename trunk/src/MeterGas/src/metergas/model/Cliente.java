/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.model;

/**
 *
 * @author Checho
 */
public class Cliente {
    
    int id;
    

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

