/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.model;

/**
 *
 * @author chalom85
 */
public class ItemFactura {
    private String concepto;
    private float valor;
    
    public ItemFactura(String concepto, float valor){
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
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }
    
    public String toString(){
        return getConcepto() + " - " + String.valueOf(getValor());
        
    }
}
