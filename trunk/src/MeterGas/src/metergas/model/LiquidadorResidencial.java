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
public class LiquidadorResidencial extends Liquidador {

    public LiquidadorResidencial() {
        this.conceptos = new Vector<Concepto>();
    }

    @Override
    public Factura liquidar(Cliente c) {

        return liquidarBase(c);

    }

    protected Factura liquidarBase(Cliente c) {
        if (c instanceof ClienteResidencial) {
            /*
             * Valor de base: consumo * valor metro
             * IVA
             * Contribuciones 
             */
            
            float acumulado;
            Factura f = new Factura();
            
            Concepto valorM3 = buscarConcepto(ConceptoEnum.M3RESIDENCIAL.getTipoConcepto());
            Concepto IVA = buscarConcepto(ConceptoEnum.IVA.getTipoConcepto());
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
