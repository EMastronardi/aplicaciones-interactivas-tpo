/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.modelo;

import metergas.modelo.ClienteIndustrial;
import metergas.modelo.views.ClienteIndustrialView;
import metergas.modelo.views.ClienteResidencialView;
import metergas.modelo.views.ClienteView;
import metergas.modelo.views.DomicilioView;

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
    
     public ClienteIndustrial(int id, String razonSocial, String nroIIBB, String condicionFiscal, String CUIT, Domicilio domicilio) {
        super(id, domicilio);
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
    public String toString() {
        return getRazonSocial();
    }

    @Override
    public ClienteView getView() {
        return new ClienteIndustrialView(razonSocial, nroIIBB, condicionFiscal, CUIT, getId(), CUIT, getDomicilio().getView());
    }

    public void actualizarCliente(ClienteView vc) {
        ClienteIndustrialView vcn = (ClienteIndustrialView) vc;
        DomicilioView vd = vc.getDomicilio();
        Domicilio d;

        this.razonSocial = vcn.getRazonSocial();
        this.nroIIBB = vcn.getNroIIBB();
        this.condicionFiscal = vcn.getCondicionFiscal();
        this.CUIT = vcn.getCUIT();
        d = new Domicilio(vd.getCalle(), vd.getAltura(), vd.getPiso(), vd.getDepartamento(), vd.getCodigoPostal(), vd.getLocalidad(), vd.getProvincia());
        this.setDomicilio(d);
    }
}
