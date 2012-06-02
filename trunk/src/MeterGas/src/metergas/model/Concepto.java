/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.model;

import metergas.model.views.ViewConcepto;

/**
 *
 * @author chalom85
 */
public class Concepto {
    private String concepto;
    private String valor;
    
    public Concepto(String concepto, String valor){
        this.concepto = concepto;
        this.valor = valor;
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
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }
    
    public ViewConcepto getViewConcepto(){
        return new ViewConcepto(this);
    }
    
}
