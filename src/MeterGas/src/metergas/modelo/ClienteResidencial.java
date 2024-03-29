/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.modelo;

import metergas.modelo.views.ClienteResidencialView;
import metergas.modelo.views.ClienteView;
import metergas.modelo.views.DomicilioView;

/**
 *
 * @author Checho
 */
public class ClienteResidencial extends Cliente {

    private String nombre;
    private String apellido;
    private String dni;

    public ClienteResidencial(String nombre, String apellido, String dni,
            Domicilio dom) {
        super(dom);
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

    @Override
    public String toString() {
        return getApellido() + ", " + getNombre();
    }

    @Override
    public ClienteView getView() {
        return new ClienteResidencialView(nombre, apellido, dni, getId(), apellido, getDomicilio().getView());
    }
    
    public void actualizarCliente(ClienteView vc){
        ClienteResidencialView vcn = (ClienteResidencialView)vc;
        DomicilioView vd = vc.getDomicilio();
        Domicilio d;
        
        this.nombre = vcn.getNombre();
        this.apellido = vcn.getApellido();
        this.dni = vcn.getDni();
        this.nombre = vcn.getNombre();
        d = new Domicilio(vd.getCalle(), vd.getAltura(), vd.getPiso(), vd.getDepartamento(), vd.getCodigoPostal(), vd.getLocalidad(), vd.getProvincia());
        this.setDomicilio(d);
    }
}
