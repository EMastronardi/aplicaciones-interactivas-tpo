/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.vistas.conceptos;

import java.lang.reflect.Field;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import metergas.modelo.views.ViewConcepto;

/**
 *
 * @author eteodoro
 */
public class ConceptosTableModel {
    private Vector<ViewConcepto> conceptos;

    public ConceptosTableModel(Vector<ViewConcepto> conceptos) {
        this.conceptos = conceptos;
    }

    public Object[][] getRowData(){
        Object[][] conceptosData = new Object[conceptos.size()][3];
        
        for (int i = 0; i < conceptos.size(); i++) {
            ViewConcepto item = conceptos.get(i);
            
            conceptosData[i] = new Object[]{item.getCodigo(),item.getConcepto(),item.getValor()};
        }
        return conceptosData;
    }
    
    public Object[] getColumnNames(){
        return new Object[]{"codigo","concepto","valor"};
    }
}
