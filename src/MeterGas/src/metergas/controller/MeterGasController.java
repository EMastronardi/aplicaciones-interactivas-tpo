/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.controller;

import java.util.Collection;
import java.util.Date;
import java.util.Vector;
import metergas.model.Cliente;
import metergas.model.Concepto;
import metergas.model.Factura;
import metergas.model.views.ViewConcepto;
import metergas.model.views.ViewDataItem;
import metergas.model.Liquidador;

/**
 *
 * @author eteodoro
 */
public class MeterGasController {

    private static MeterGasController instancia;
    private Collection<Cliente> clientes;
    private Collection<Concepto> conceptos;
    private Collection<Factura> facturas;
    private Collection<Liquidador> liquidadores;
    private float acumuladorSubsidios;

    private MeterGasController() {
        this.clientes = new Vector<Cliente>();
        this.conceptos = new Vector<Concepto>();
        this.facturas = new Vector<Factura>();
        this.liquidadores = new Vector<Liquidador>();
        this.acumuladorSubsidios = 0;
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
    
    public Cliente buscarCliente(int id){
        Cliente cliente;
 
        cliente = null;
        for (Cliente elemento: clientes){
            if (elemento.getId() == id){
                cliente = elemento;
                break;
            }    
        }
        return cliente;
        
    }
    
    public void registrarMedicion(int idCliente, Date fecha, float valor){
        Cliente cliente;
                
        cliente = this.buscarCliente(idCliente);
        cliente.generarMedicion(valor, fecha);
    }
    
    public void buscarYMostrarCliente(int idCliente){

    }
    
    public Concepto buscarConcepto(int codigo){
        Concepto concepto;
 
        concepto = null;
        for (Concepto elemento: conceptos){
            if (elemento.getCodigo() == codigo){
                concepto = elemento;
                break;
            }    
        }
        return concepto;
    }
    
    public boolean modificarTarifa(int codigo, String concepto, float valor){
        Concepto c;
        boolean resultado;
        
        c = this.buscarConcepto(codigo);
        if (c.equals(null)){
            resultado = false;  
        }    
        else{
            c.setConcepto(concepto);
            c.setValor(valor);
            resultado = true;
        }
        
        return resultado;
    }
    
    public ViewConcepto buscarYMostrarConcepto(int codigo){
        Concepto concepto;
        ViewConcepto vistaConcepto;
        
        concepto = buscarConcepto(codigo);
        vistaConcepto = concepto.getViewConcepto();
        
        return vistaConcepto;
    }
    
    private void addFactura(Factura f){
        this.facturas.add(f);
    }

    /**
     * @return the acumuladorSubsidios
     */
    public float getAcumuladorSubsidios() {
        return acumuladorSubsidios;
    }
    
    private void inicializarAcumuladorSubsidios(){
        this.acumuladorSubsidios = 0;
    }
    
    public void incrementarAcumuladorSubsidios(float m){
        this.acumuladorSubsidios = this.acumuladorSubsidios + m;
    }
    
    public Collection<Liquidador> getLiquidadores(){
        return this.liquidadores;
    }
}
