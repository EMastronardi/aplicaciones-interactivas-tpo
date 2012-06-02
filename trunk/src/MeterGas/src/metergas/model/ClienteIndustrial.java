/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.model;

import metergas.model.ClienteIndustrial;

/**
 *
 * @author Checho
 */
public class ClienteIndustrial extends Cliente {

    private String razonSocial;
    private String nroIIBB;
    private String condicionFiscal;
    private String CUIT;

    public ClienteIndustrial(String razonSocial, String nroIIBB, String condicionFiscal, String CUIT, Domicilio domicilio) {
        super(domicilio);
        this.razonSocial = razonSocial;
        this.nroIIBB = nroIIBB;
        this.condicionFiscal = condicionFiscal;
        this.CUIT = CUIT;
    }

    
    
    /**
     * @return the razonSocial
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * @return the nroIIBB
     */
    public String getNroIIBB() {
        return nroIIBB;
    }

    /**
     * @return the condicionFiscal
     */
    public String getCondicionFiscal() {
        return condicionFiscal;
    }

    /**
     * @return the CUIT
     */
    public String getCUIT() {
        return CUIT;
    }

    @Override
    public String getDescripcion() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}