/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.model;

import java.util.Collections;
import java.util.Date;
import java.util.Vector;
import metergas.model.views.ClienteView;
import metergas.model.views.ViewDataItem;

/**
 *
 * @author Checho
 */
public abstract class Cliente {

    /**
     * @return the ultimoId
     */
    public static int getUltimoId() {
        ultimoId++;
        return ultimoId;
    }

    /**
     * @param aUltimoId the ultimoId to set
     */
    private static void setUltimoId(int aUltimoId) {
        ultimoId = aUltimoId;
    }
    private int id;
    private Domicilio domicilio;
    private String estado;
    private Vector<Medicion> mediciones;
    private static int ultimoId = 0;
    private Vector<Factura> facturas;

    protected Cliente(Domicilio domicilio) {
        this.id = getUltimoId();
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
}
