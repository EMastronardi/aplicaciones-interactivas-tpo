/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.model;

import java.util.Vector;

/**
 *
 * @author chalom85
 */
public class LiquidadorIndustrialConTransporte extends LiquidadorIndustrial{
    
    public LiquidadorIndustrialConTransporte(){
        this.conceptos = new Vector<Concepto>();
    }
    
    public Factura liquidar(Cliente c){
        return new Factura();
    }
}
