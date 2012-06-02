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
abstract class Liquidador {
    protected Collection<Concepto> conceptos;
    
    abstract Factura liquidar(Cliente c);
    
    protected Concepto buscarConcepto(int codigo){
        Concepto valorRetorno;
 
        valorRetorno = null;
        for (Concepto elemento: conceptos){
            if (elemento.getCodigo() == codigo){
                valorRetorno = elemento;
                break;
            }    
        }
        return valorRetorno;
    }
    
}
