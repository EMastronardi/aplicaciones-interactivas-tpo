/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.modelo;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author chalom85
 */
public class Factura {

    private int nro ;
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

    public Factura(int nro, Date fecha, float consumo, Cliente cliente, Collection<ItemFactura> items, float subsidio) {
        this.nro = nro;
        this.fecha = fecha;
        this.consumo = consumo;
        this.cliente = cliente;
        this.items = items;
        this.subsidio = subsidio;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @return the consumo
     */
    public float getConsumo() {
        return consumo;
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
    
    public String toString(){
        StringBuffer retorno;
        
        retorno = new StringBuffer("Nro: " + String.valueOf(getNro()) + "\n");
        retorno.append("Fecha: " + getFecha().toString() + "\n");
        retorno.append("Cliente: " + getCliente().toString() + "\n");
        for (Iterator<ItemFactura> it = items.iterator(); it.hasNext();) {
            ItemFactura itemFactura = it.next();
            retorno.append("    " + itemFactura.toString() + "\n");
        }
        retorno.append(String.valueOf(getTotal())+"\n");
        
        return retorno.toString();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public Collection<ItemFactura> getItems(){
        return this.items;
    }
    
}
