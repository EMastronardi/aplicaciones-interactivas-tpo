/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.model;

import java.util.Collection;
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
    private Collection<Medicion>  mediciones;
    private static int ultimoId;

    protected Cliente(Domicilio domicilio) {
        this.id = getUltimoId();
        this.domicilio = domicilio;
        this.estado = new String("Activo");
        this.mediciones = new Vector<Medicion>();
    }

   
    private Medicion buscarUltimaMedicion(){
        return null;
    }

    private Medicion buscarAnteUltimaMedicion(){
        return null;
    }

    public  float calcularUltimoConsumo(){
        return 0;
    }
             
    public abstract String getDescripcion();

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
    public Collection<Medicion> getMediciones() {
        return mediciones;
    }
    
    
    
}
