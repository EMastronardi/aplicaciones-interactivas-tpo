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
public class LiquidadorResidencialSubsidiado extends LiquidadorResidencial {

    public LiquidadorResidencialSubsidiado() {
        this.conceptos = new Vector<Concepto>();
    }

    public Factura liquidar(Cliente c) {

        Concepto topeSubsidio = buscarConcepto(ConceptoEnum.TOPESUBSIDIORESIDENCIAL.getTipoConcepto());
        Concepto subsidio = buscarConcepto(ConceptoEnum.SUBSIDIORESIDENCIAL.getTipoConcepto());
        float sub;
        Factura factura = super.liquidarBase(c);


        if (factura != null) {
            if (factura.getTotal() < topeSubsidio.getValor()) {
                sub = factura.getTotal() * -1 * (subsidio.getValor() / 100);
                factura.generarItemFactura(subsidio.getConcepto(), sub);
                return new Factura();
            }
        }
        return null;
    }
}