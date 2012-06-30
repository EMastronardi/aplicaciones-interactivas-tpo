/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.modelo;

import java.util.Collection;
import java.util.Vector;

/**
 *
 * @author chalom85
 */
public abstract class Liquidador {
    
    
    protected Collection<Concepto> conceptos;

    protected Liquidador(Collection<Concepto> conceptos) {
        this.conceptos = new Vector<Concepto>();
        this.conceptos.addAll(conceptos);
    }

    
    public abstract Factura liquidar(Cliente c);
    
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
