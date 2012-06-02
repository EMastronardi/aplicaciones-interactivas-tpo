/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.model.views;

/**
 *
 * @author Checho
 */
public class ClienteView {

    int id;
    String estado;
    DomicilioView domicilio;

    public ClienteView(int id, String estado, DomicilioView domicilio) {
        this.id = id;
        this.estado = estado;
        this.domicilio = domicilio;
    }

    
    public int getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }
    
    public DomicilioView getDomicilio(){
        return domicilio;
    }
    
}

