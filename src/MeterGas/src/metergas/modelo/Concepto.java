/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.modelo;

import metergas.modelo.views.ViewConcepto;

/**
 *
 * @author chalom85
 */
public class Concepto {
    private String concepto;
    private float valor;
    private int codigo;

    public Concepto(String concepto, float valor, int codigo) {
        this.concepto = concepto;
        this.valor = valor;
        this.codigo = codigo;
    }
    
     /**
     * @return the concepto
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * @param concepto the concepto to set
     */
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }
    
    public ViewConcepto getViewConcepto(){
        return new ViewConcepto(this);
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    public String toString() {
        return getConcepto() + " - " + String.valueOf(getValor());
    }
    
}
