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
public class LiquidadorResidencialSubsidiado extends LiquidadorResidencial{
    
    public LiquidadorResidencialSubsidiado(){
        this.conceptos = new Vector<Concepto>();
    }
    
    public Factura liquidar(Cliente c){
        float valorM3 = buscarConcepto(ConceptoEnum.M3RESIDENCIAL.getTipoConcepto()).getValor();
        float IVA = (buscarConcepto(ConceptoEnum.IVA.getTipoConcepto()).getValor() / 100) + 1;
        float ContribMuni = (buscarConcepto(ConceptoEnum.CONTRIBUCIONESMUNICIPALES.getTipoConcepto()).getValor()/100)+1;
        float topeSubsidio = buscarConcepto(ConceptoEnum.TOPESUBSIDIORESIDENCIAL.getTipoConcepto()).getValor();
        
        float total = valorM3 * c.calcularUltimoConsumo() * IVA * ContribMuni;
        
        if (total < topeSubsidio){
            
        }
        
        
        
        Factura f = new Factura();
        
        
        
        return new Factura();
    }
    
    
}
