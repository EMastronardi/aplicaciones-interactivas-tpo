/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.model;

/**
 *
 * @author Checho
 */
public enum ConceptoEnum {
    M3RESIDENCIAL(1), 
    M3INDUSTRIAL(2), 
    IVA(3),
    CONTRIBUCIONESMUNICIPALES(4),
    TOPESUBSIDIORESIDENCIAL(5),
    TOPESUBSIDIOINDUSTRIAL(6),
    SUBSIDIORESIDENCIAL(7);

    private int tipoConcepto;
    
    private ConceptoEnum(int concepto){
        this.tipoConcepto = tipoConcepto;
    }
    
    public int getTipoConcepto(){
        return this.tipoConcepto;
    }

    
    
}
