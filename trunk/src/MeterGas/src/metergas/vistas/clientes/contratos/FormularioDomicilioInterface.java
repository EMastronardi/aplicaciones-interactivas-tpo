/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.vistas.clientes.contratos;

import metergas.model.vistas.DomicilioView;


/**
 *
 * @author eteodoro
 */
public interface FormularioDomicilioInterface {
    public DomicilioView getDomicilio();
    public void cargarDomicilio(DomicilioView domicilio);
    public void clean();
}
