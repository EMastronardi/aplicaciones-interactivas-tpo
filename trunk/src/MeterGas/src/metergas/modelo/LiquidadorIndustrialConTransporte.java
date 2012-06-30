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
public class LiquidadorIndustrialConTransporte extends LiquidadorIndustrial{

    public LiquidadorIndustrialConTransporte(Collection<Concepto> conceptos) {
        super(conceptos);
    }
    
    public Factura liquidar(Cliente c){
        Factura factura = super.liquidarBase(c);
        
        if (factura != null){
            Concepto topeSinTransporte = buscarConcepto(ConceptoEnum.TOPESINTRANSPORTE.getTipoConcepto());
            Concepto transporte = buscarConcepto(ConceptoEnum.TRANSPORTE.getTipoConcepto());
            float tran;
            if (c.calcularUltimoConsumo() > topeSinTransporte.getValor()) {
                tran = factura.getTotal() * (transporte.getValor() / 100);
                factura.generarItemFactura(transporte.getConcepto(), tran);
                return factura;
            }
            return super.liquidarBase(c);
        }
        
        return null;
    }
}
