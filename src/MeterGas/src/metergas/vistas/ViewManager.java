/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.vistas;

import java.util.HashMap;
import metergas.vistas.clientes.JFrameBase;

/**
 *
 * @author eteodoro
 */
public class ViewManager {

    private static ViewManager instancia;
    private HashMap<String, JFrameBase> vistas;

    private ViewManager() {
        vistas = new HashMap<String, JFrameBase>();
        vistas.put("Clientes.Alta", new metergas.vistas.clientes.Alta());
        vistas.put("Clientes.Baja", new metergas.vistas.clientes.Baja());
        vistas.put("Clientes.Modificacion", new metergas.vistas.clientes.Modificacion());
    }

    public static ViewManager getInstance() {
        if (instancia == null) {
            instancia = new ViewManager();
        }
        return instancia;
    }

    public JFrameBase getVista(String vista) {
        
        return vistas.get(vista);
    }
}