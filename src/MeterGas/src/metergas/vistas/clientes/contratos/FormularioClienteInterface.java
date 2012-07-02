/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.vistas.clientes.contratos;

import metergas.model.views.ClienteView;

/**
 *
 * @author eteodoro
 */
public interface FormularioClienteInterface {
    public ClienteView getCliente();
    public void cargarCliente(ClienteView cliente);
    public void clear();
}
