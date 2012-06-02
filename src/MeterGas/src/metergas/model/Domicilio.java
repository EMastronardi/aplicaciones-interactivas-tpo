/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.model;

/**
 *
 * @author Checho
 */
class Domicilio {

    private String calle;
    private String altura;
    private String piso;
    private String departamento;
    private String codigoPostal;
    private String localidad;
    private String provincia;

    public String toString(){
        return getCalle() + " " + getAltura() + "-" + getPiso() + getDepartamento() + ","
                + getLocalidad() + " (" + getCodigoPostal() + "), " + getProvincia();
    }
    
    /**
     * @return the calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * @return the altura
     */
    public String getAltura() {
        return altura;
    }

    /**
     * @return the piso
     */
    public String getPiso() {
        return piso;
    }

    /**
     * @return the departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @return the codigoPostal
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * @return the localidad
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * @return the provincia
     */
    public String getProvincia() {
        return provincia;
    }
    
    
}
