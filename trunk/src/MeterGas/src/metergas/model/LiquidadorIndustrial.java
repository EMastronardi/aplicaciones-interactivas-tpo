/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.model;

import java.util.Collection;
import java.util.Vector;

/**
 *
 * @author chalom85
 */
public class LiquidadorIndustrial extends Liquidador {

    public LiquidadorIndustrial(Collection<Concepto> conceptos) {
        super(conceptos);
    }

    
    @Override
    public Factura liquidar(Cliente c) {

        return liquidarBase(c);

    }

    protected Factura liquidarBase(Cliente c) {
        if (c instanceof ClienteIndustrial) {
            /*
             * Valor de base: consumo * valor metro
             * IVA Industrial
             * Contribuciones Munici 
             */
            
            float acumulado;
            Factura f = new Factura();
            
            Concepto valorM3 = buscarConcepto(ConceptoEnum.M3INDUSTRIAL.getTipoConcepto());
            Concepto IVA = buscarConcepto(ConceptoEnum.IVARESPONSABLE.getTipoConcepto());
            Concepto IIBB = buscarConcepto(ConceptoEnum.IIBB.getTipoConcepto());
            Concepto ContribMuni = buscarConcepto(ConceptoEnum.CONTRIBUCIONESMUNICIPALES.getTipoConcepto());

            acumulado = valorM3.getValor() * c.calcularUltimoConsumo();
            f.generarItemFactura(valorM3.toString(), acumulado);
            acumulado = acumulado * 1 + (IVA.getValor() / 100);
            f.generarItemFactura(IVA.toString(), acumulado);
            acumulado = acumulado * 1 + (ContribMuni.getValor() / 100);
            f.generarItemFactura(IVA.toString(), acumulado);

            
            return f;

        }
        return null;
    }
    
}
