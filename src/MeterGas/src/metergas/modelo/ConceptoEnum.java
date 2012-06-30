/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.modelo;

/**
 *
 * @author Checho
 */
public enum ConceptoEnum {
    M3RESIDENCIAL(1), 
    M3INDUSTRIAL(2), 
    IVACONSUMIDORFINAL(3),
    CONTRIBUCIONESMUNICIPALES(4),
    TOPESUBSIDIORESIDENCIAL(5),
    TOPESINTRANSPORTE(6),
    SUBSIDIORESIDENCIAL(7),
    IVARESPONSABLE(8), 
    IIBB(9),
    TRANSPORTE(10);
    

    private int tipoConcepto;
    
    private ConceptoEnum(int concepto){
        this.tipoConcepto = concepto;
    }
    
    public int getTipoConcepto(){
        return this.tipoConcepto;
    }

    
    
}
