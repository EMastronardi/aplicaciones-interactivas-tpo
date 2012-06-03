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
public class LiquidadorResidencial extends Liquidador {

    public LiquidadorResidencial(Collection<Concepto> conceptos) {
        super(conceptos);
    }

    @Override
    public Factura liquidar(Cliente c) {

        return liquidarBase(c);

    }

    protected Factura liquidarBase(Cliente c) {
        if (c instanceof ClienteResidencial) {
            /*
             * Valor de base: consumo * valor metro IVA Consumidor Final
             * Contribuciones
             */

            float acumulado;
            float actual;
            Factura f = new Factura();

            Concepto valorM3 = buscarConcepto(ConceptoEnum.M3RESIDENCIAL.getTipoConcepto());
            Concepto IVA = buscarConcepto(ConceptoEnum.IVACONSUMIDORFINAL.getTipoConcepto());
            Concepto ContribMuni = buscarConcepto(ConceptoEnum.CONTRIBUCIONESMUNICIPALES.getTipoConcepto());

            acumulado = valorM3.getValor() * c.calcularUltimoConsumo();
            f.generarItemFactura(valorM3.toString(), acumulado);
            actual = acumulado * (IVA.getValor() / 100);
            acumulado+=actual;
            f.generarItemFactura(IVA.toString(), actual);
            actual = acumulado * (ContribMuni.getValor() / 100);
            acumulado+=actual;
            f.generarItemFactura(ContribMuni.toString(), actual);

            
            return f;

        }
        return null;
    }
}
