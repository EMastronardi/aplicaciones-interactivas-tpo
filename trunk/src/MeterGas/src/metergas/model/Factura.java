/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.model;

import java.util.Collection;
import java.util.Date;

/**
 *
 * @author chalom85
 */
public class Factura {
    private Date fecha;
    private float consumo;
    private Cliente cliente;
    private Collection<ItemFactura> items;
    
    public Factura(){
        this.fecha = new Date();
    }
    
    public Factura(Date fecha){
        this.setFecha(fecha);
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the consumo
     */
    public float getConsumo() {
        return consumo;
    }

    /**
     * @param consumo the consumo to set
     */
    public void setConsumo(float consumo) {
        this.consumo = consumo;
    }
    
    public float calcularTotalSubsidio(){
        return 0;
    }
    
    public void addItemFactura(ItemFactura item){
        items.add(item);
    }
    
    public void setCliente(Cliente c){
        this.cliente = c;
    }
}
