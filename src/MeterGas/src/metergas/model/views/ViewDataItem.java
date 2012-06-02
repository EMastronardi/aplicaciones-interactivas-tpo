/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.model.views;

/**
 *
 * @author eteodoro
 */
public class ViewDataItem {
    private String descripcion;
    private String codigo;

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ViewDataItem(String descripcion, String codigo) {
        this.descripcion = descripcion;
        this.codigo = codigo;
    }
    
}
