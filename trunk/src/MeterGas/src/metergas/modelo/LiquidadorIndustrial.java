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
            float actual;
            Factura f = new Factura();
            
            Concepto valorM3 = buscarConcepto(ConceptoEnum.M3INDUSTRIAL.getTipoConcepto());
            Concepto IVA = buscarConcepto(ConceptoEnum.IVARESPONSABLE.getTipoConcepto());
            Concepto IIBB = buscarConcepto(ConceptoEnum.IIBB.getTipoConcepto());

            acumulado = valorM3.getValor() * c.calcularUltimoConsumo();
            f.generarItemFactura(valorM3.toString(), acumulado);
            actual = acumulado * (IVA.getValor() / 100);
            acumulado += actual;
            f.generarItemFactura(IVA.toString(), actual);
            actual = acumulado * (IIBB.getValor() / 100);
            acumulado += actual;
            f.generarItemFactura(IIBB.toString(), actual);

            
            return f;

        }
        return null;
    }
    
}
