/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.vistas;

import java.util.HashMap;
import javax.swing.JFrame;

/**
 *
 * @author eteodoro
 */
public class ViewManager {

    private static ViewManager instancia;
    private HashMap<String, JFrame> vistas;

    private ViewManager() {
        vistas = new HashMap<String, JFrame>();
        vistas.put("AltaCliente", new metergas.vistas.clientes.Alta());
        vistas.put("BajaCliente", new metergas.vistas.clientes.Baja());
        vistas.put("ModificacionCliente", new metergas.vistas.clientes.Modificacion());
    }

    public static ViewManager getInstance() {
        if (instancia == null) {
            instancia = new ViewManager();
        }
        return instancia;
    }

    public JFrame getVista(String vista) throws InstantiationException, IllegalAccessException {
        return vistas.get(vista);
    }
}