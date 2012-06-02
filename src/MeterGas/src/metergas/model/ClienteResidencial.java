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
    String dni;

    public ClienteResidencial(String nombre, String apellido, String dni, 
            Domicilio dom) {
        super(dom);
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
      }
      
    
    @Override
    public String getDescripcion() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

