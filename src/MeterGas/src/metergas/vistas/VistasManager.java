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
public class VistasManager {

    private static VistasManager instancia;
    private HashMap<String, JFrameBase> vistas;

    private VistasManager() {
        vistas = new HashMap<String, JFrameBase>();
        vistas.put("Clientes.Alta", new metergas.vistas.clientes.Alta());
        
        
        vistas.put("Clientes.Baja", new metergas.vistas.clientes.Baja());
        vistas.put("Clientes.Modificacion", new metergas.vistas.clientes.Modificacion());
    }

    public static VistasManager getInstance() {
        if (instancia == null) {
            instancia = new VistasManager();
        }
        return instancia;
    }

    public JFrameBase getVista(String vista) {
        
        return vistas.get(vista);
    }
}