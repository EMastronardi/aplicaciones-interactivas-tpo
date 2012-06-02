/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.model.views;

/**
 *
 * @author Checho
 */
public class ClienteIndustrialView extends ClienteView {

    private String razonSocial;
    private String nroIIBB;
    private String condicionFiscal;
    private String CUIT;

    public ClienteIndustrialView(String razonSocial, String nroIIBB, String condicionFiscal, String CUIT, int id, String estado, DomicilioView domicilio) {
        super(id, estado, domicilio);
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
}
