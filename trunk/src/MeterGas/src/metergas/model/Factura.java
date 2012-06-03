/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.model;

import java.util.Collection;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author chalom85
 */
public class Factura {

    private Date fecha;
    private float consumo;
    private Cliente cliente;
    private Collection<ItemFactura> items;
    private float subsidio;

    public Factura() {
        this.subsidio = 0;
        this.fecha = new Date();
        this.items = new Vector<ItemFactura>();
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

    public float getSubsidio() {
        return subsidio;
    }

    private void addItemFactura(ItemFactura item) {
        items.add(item);
    }

    public void setCliente(Cliente c) {
        this.cliente = c;
    }

    public void generarItemFactura(String descripcion, float valor) {
        this.addItemFactura(new ItemFactura(descripcion, valor));
    }

    public float getTotal() {
        float total = 0;
        for (ItemFactura itemFactura : items) {
            total += itemFactura.getValor();
        }
        return total;

    }

    void setSubsidio(float sub) {
        this.subsidio = sub;
    }
}
