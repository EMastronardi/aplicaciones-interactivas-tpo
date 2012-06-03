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
        Factura factura = super.liquidarBase(c);
        
        if (factura != null){
            Concepto topeSinTransporte = buscarConcepto(ConceptoEnum.TOPESINTRANSPORTE.getTipoConcepto());
            Concepto transporte = buscarConcepto(ConceptoEnum.TRANSPORTE.getTipoConcepto());
            float tran;
            if (factura.getTotal() < topeSinTransporte.getValor()) {
                tran = factura.getTotal() * (transporte.getValor() / 100);
                factura.generarItemFactura(transporte.getConcepto(), tran);
                return new Factura();
            }
            return super.liquidarBase(c);
        }
        
        return null;
    }
}
