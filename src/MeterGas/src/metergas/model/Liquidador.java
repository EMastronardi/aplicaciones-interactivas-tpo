/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.model;

import java.util.Collection;

/**
 *
 * @author chalom85
 */
public abstract class Liquidador {
    protected Collection<Concepto> conceptos;
    
    abstract Factura liquidar(Cliente c);
    
    protected Concepto buscarConcepto(int codigo){
        Concepto c;
 
        c = null;
        for (Concepto elemento: conceptos){
            if (elemento.getCodigo() == codigo){
                c = elemento;
                break;
            }    
        }
        return c;
    }
    
}
