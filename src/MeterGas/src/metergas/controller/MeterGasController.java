/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.controller;

import java.util.Collection;
import java.util.Date;
import java.util.Vector;
import metergas.model.Cliente;
import metergas.model.ClienteResidencial;
import metergas.model.ClienteIndustrial;
import metergas.model.Concepto;
import metergas.model.Domicilio;
import metergas.model.Factura;
import metergas.model.views.ClienteView;
import metergas.model.views.ClienteResidencialView;
import metergas.model.views.ClienteIndustrialView;
import metergas.model.views.DomicilioView;
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

        items.add(ClienteView.VIEW_RESIDENCIAL);
        items.add(ClienteView.VIEW_INDUSTRIAL);

        return items;
    }

    private Cliente buscarCliente(int id) {
        Cliente cliente;

        cliente = null;
        for (Cliente elemento : clientes) {
            if (elemento.getId() == id) {
                cliente = elemento;
                break;
            }
        }
        return cliente;
    }

    public void registrarMedicion(int idCliente, Date fecha, float valor) {
        Cliente cliente;

        cliente = this.buscarCliente(idCliente);
        cliente.generarMedicion(valor, fecha);
    }

    public ClienteView buscarYMostrarCliente(int idCliente) {
        if(buscarCliente(idCliente) != null)
            return buscarCliente(idCliente).getView();
        
       return null;
    }

    private Concepto buscarConcepto(int codigo) {
        Concepto concepto;

        concepto = null;
        for (Concepto elemento : conceptos) {
            if (elemento.getCodigo() == codigo) {
                concepto = elemento;
                break;
            }
        }
        return concepto;
    }

    public boolean modificarTarifa(int codigo, String concepto, float valor) {
        Concepto c;
        boolean resultado;

        c = this.buscarConcepto(codigo);
        if (c.equals(null)) {
            resultado = false;
        } else {
            c.setConcepto(concepto);
            c.setValor(valor);
            resultado = true;
        }

        return resultado;
    }

    public ViewConcepto buscarYMostrarConcepto(int codigo) {
        Concepto concepto;
        ViewConcepto vistaConcepto;

        concepto = buscarConcepto(codigo);
        vistaConcepto = concepto.getViewConcepto();

        return vistaConcepto;
    }

    private void addFactura(Factura f) {
        this.facturas.add(f);
    }

    private void addCliente(Cliente c) {
        this.clientes.add(c);
    }

    /**
     * @return the acumuladorSubsidios
     */
    public float getAcumuladorSubsidios() {
        return acumuladorSubsidios;
    }

    private void inicializarAcumuladorSubsidios() {
        this.acumuladorSubsidios = 0;
    }

    public void incrementarAcumuladorSubsidios(float m) {
        this.acumuladorSubsidios = this.acumuladorSubsidios + m;
    }

    public Collection<Liquidador> getLiquidadores() {
        return this.liquidadores;
    }

    public void altaCliente(ClienteView vc) {
        Cliente c = null;
        DomicilioView vd;
        Domicilio d;

        if (vc instanceof ClienteResidencialView) {
            ClienteResidencialView vcn;

            vcn = (ClienteResidencialView) vc;
            vd = vc.getDomicilio();
            d = new Domicilio(vd.getCalle(), vd.getAltura(), vd.getPiso(), vd.getDepartamento(), vd.getCodigoPostal(), vd.getLocalidad(), vd.getProvincia());
            c = new ClienteResidencial(vcn.getNombre(), vcn.getApellido(), vcn.getDni(), d);
        } else if (vc instanceof ClienteIndustrialView) {
            ClienteIndustrialView vcn;

            vcn = (ClienteIndustrialView) vc;
            vd = vc.getDomicilio();
            d = new Domicilio(vd.getCalle(), vd.getAltura(), vd.getPiso(), vd.getDepartamento(), vd.getCodigoPostal(), vd.getLocalidad(), vd.getProvincia());
            c = new ClienteIndustrial(vcn.getRazonSocial(), vcn.getNroIIBB(), vcn.getCondicionFiscal(), vcn.getCUIT(), d);

        }

        this.addCliente(c);
    }

    public void modificarCliente(ClienteView vc) {
        Cliente c = this.buscarCliente(vc.getId());
        
        c.actualizarCliente(vc);
    }

    public void eliminarCliente(int idCliente) {
        Cliente c;

        c = this.buscarCliente(idCliente);
        c.bajaCliente();
    }
}
