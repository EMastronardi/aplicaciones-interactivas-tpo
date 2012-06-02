/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.model;

import java.util.Collections;
import java.util.Vector;

/**
 *
 * @author Checho
 */
public abstract class Cliente {

    /**
     * @return the ultimoId
     */
    public static int getUltimoId() {
        ultimoId ++;
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
    private Vector<Medicion>  mediciones;
    private static int ultimoId = 0;
    private Vector<Factura> facturas;
    

    protected Cliente(Domicilio domicilio) {
        this.id = getUltimoId();
        this.domicilio = domicilio;
        this.estado = "Activo";
        this.mediciones = new Vector<Medicion>();
        this.facturas = new Vector<Factura>();
    }

   
    private Medicion buscarUltimaMedicion(){
        Collections.sort(getMediciones());
        getMediciones().lastElement();     
        return null;
    }

    private Medicion buscarAnteUltimaMedicion(){
        if (getMediciones().size() >= 2){
            return getMediciones().get(getMediciones().size()-2);
        }
        return null;
    }

    public float calcularUltimoConsumo(){
        
        return buscarUltimaMedicion().getValor() - buscarAnteUltimaMedicion().getValor();
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
    
    public void addFactura(Factura f){
        facturas.add(f);
    }
    
    public void liquidarUltimaMedicion(){
        Collections.sort(getMediciones());
        getMediciones().lastElement().setLiquidado(true);
    }
    
}
