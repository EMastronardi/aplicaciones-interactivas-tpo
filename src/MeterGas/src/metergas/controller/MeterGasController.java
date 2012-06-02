/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.controller;

import java.util.Collection;
import java.util.Vector;
import metergas.model.views.ViewDataItem;

/**
 *
 * @author eteodoro
 */
public class MeterGasController {

    private static MeterGasController instancia;

    private MeterGasController() {
    }

    public static MeterGasController getInstance() {
        if (instancia == null) {
            instancia = new MeterGasController();
        }
        return instancia;
    }

    public Collection<ViewDataItem> getTiposCliente() {
        Collection<ViewDataItem> items = new Vector<ViewDataItem>();
        
        items.add(new ViewDataItem("Residencial", "metergas.vistas.clientes.FormularioResidencial"));
        items.add(new ViewDataItem("Industrial", "metergas.vistas.clientes.FormularioIndustrial"));

        return items;
    }
}
