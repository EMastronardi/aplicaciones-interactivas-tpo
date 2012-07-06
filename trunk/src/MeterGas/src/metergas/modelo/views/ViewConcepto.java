/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.modelo.views;

import metergas.modelo.Concepto;

/**
 *
 * @author chalom85
 */
public class ViewConcepto {

    private String concepto;
    private float valor;
    private int codigo;

    public ViewConcepto(Concepto c) {
        this.concepto = c.getConcepto();
        this.valor = c.getValor();
        this.codigo = c.getCodigo();
    }

    /**
     * @return the concepto
     */
    public String getConcepto() {
        return concepto;
    }

    public int getCodigo() {
        return codigo;
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

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
