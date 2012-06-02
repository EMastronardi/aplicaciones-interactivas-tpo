/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.model;

import java.util.Date;

/**
 *
 * @author chalom85
 */
public class Medicion {
    private float valor;
    private Date fecha;
    private boolean liquidado;
    
    public Medicion(float valor, Date fecha){
        this.valor = valor;
        this.fecha = fecha;
        this.liquidado = false;
    }

    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @return the liquidado
     */
    public boolean isLiquidado() {
        return liquidado;
    }

    /**
     * @param liquidado the liquidado to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public void setLiquidado(boolean liquidado) {
        this.liquidado = liquidado;
    }
    
}

