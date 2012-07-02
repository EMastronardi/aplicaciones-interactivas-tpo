/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.model.views;

/**
 *
 * @author Checho
 */
public abstract class ClienteView {
    public static final ViewDataItem VIEW_INDUSTRIAL = new ViewDataItem("Industrial", "metergas.vistas.clientes.FormularioIndustrial");
    public static final ViewDataItem VIEW_RESIDENCIAL = new ViewDataItem("Residencial", "metergas.vistas.clientes.FormularioResidencial");
    int id;
    String estado;
    DomicilioView domicilio;
    
    public ClienteView(int id, String estado, DomicilioView domicilio) {
        this.id = id;
        this.estado = estado;
        this.domicilio = domicilio;
    }
    
    public abstract ViewDataItem getViewType();
    
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

