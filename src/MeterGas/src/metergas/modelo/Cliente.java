/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.modelo;

import java.util.Collections;
import java.util.Date;
import java.util.Vector;
import metergas.modelo.views.ClienteView;
import metergas.modelo.views.ViewDataItem;

/**
 *
 * @author Checho
 */
public abstract class Cliente {

    private int id;
    private Domicilio domicilio;
    private String estado;
    private Vector<Medicion> mediciones;
    private Vector<Factura> facturas;
    
    
    protected Cliente(Domicilio domicilio) {
        this.id = -1;
        this.domicilio = domicilio;
        this.estado = "Activo";
        this.mediciones = new Vector<Medicion>();
        this.facturas = new Vector<Factura>();
    }
    
    protected Cliente(int id, Domicilio domicilio) {
        this.id = id;
        this.domicilio = domicilio;
        this.estado = "Activo";
        this.mediciones = new Vector<Medicion>();
        this.facturas = new Vector<Factura>();
    }

    private Medicion buscarUltimaMedicion() {
        Collections.sort(getMediciones());
        return getMediciones().lastElement();
    }

    private Medicion buscarAnteUltimaMedicion() {
        if (getMediciones().size() >= 2) {
            return getMediciones().get(getMediciones().size() - 2);
        }
        return null;
    }

    public float calcularUltimoConsumo() {
        Medicion ultima = buscarUltimaMedicion();
        if (ultima != null){
            float ult = ultima.getValor();
            Medicion anteUltima = buscarAnteUltimaMedicion();
            if (anteUltima != null){
                float anteu = anteUltima.getValor();
                return ultima.getValor() - anteUltima.getValor();
            }
            else {
                return ult;
            }
            
        } 
        else {
            return 0;
        }
    }

    public abstract String toString();

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the domicilio
     */
    public Domicilio getDomicilio() {
        return domicilio;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    public boolean isActivo(){
        return !getEstado().equals("Inactivo");
    }
    /**
     * @return the mediocines
     */
    public Vector<Medicion> getMediciones() {
        return mediciones;
    }

    public void addFactura(Factura f) {
        facturas.add(f);
    }

    public void liquidarUltimaMedicion() {
        Collections.sort(getMediciones());
        getMediciones().lastElement().setLiquidado(true);
    }

    public void generarMedicion(float valor, Date fecha) {
        Medicion m = new Medicion(valor, fecha);
        addMedicion(m);
    }

    private void addMedicion(Medicion m) {
        getMediciones().add(m);
    }

    public abstract ClienteView getView();

    public void bajaCliente() {
        this.estado = "Inactivo";
    }

    public abstract void actualizarCliente(ClienteView vc);

    /**
     * @param domicilio the domicilio to set
     */
    protected void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public void setTipo(TipoClienteEnum tipo) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setId(int id) {
        this.id = id;
    }
}
