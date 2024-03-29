/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.controller;

import metergas.modelo.LiquidadorResidencial;
import metergas.modelo.Domicilio;
import metergas.modelo.Concepto;
import metergas.modelo.Factura;
import metergas.modelo.ConceptoEnum;
import metergas.modelo.ClienteResidencial;
import metergas.modelo.Liquidador;
import metergas.modelo.ClienteIndustrial;
import metergas.modelo.LiquidadorIndustrial;
import metergas.modelo.Cliente;
import metergas.modelo.LiquidadorResidencialSubsidiado;
import metergas.modelo.LiquidadorIndustrialConTransporte;
import java.util.Collection;
import java.util.Date;
import java.util.Vector;
import metergas.modelo.views.ClienteView;
import metergas.modelo.views.ClienteResidencialView;
import metergas.modelo.views.ClienteIndustrialView;
import metergas.modelo.views.DomicilioView;
import metergas.modelo.views.ViewConcepto;
import metergas.modelo.views.ViewDataItem;
import metergas.modelo.persistencia.ClienteDataAccess;
import metergas.modelo.persistencia.ConceptoDataAccess;
import metergas.modelo.persistencia.FacturaDataAccess;

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
        this.liquidadores = new Vector<Liquidador>();
        this.acumuladorSubsidios = 0;
        
        inicializar();
        this.clientes = ClienteDataAccess.getInstance().getClientes();
        this.facturas = FacturaDataAccess.getInstance().getFacturas();
        this.conceptos = ConceptoDataAccess.getInstance().getConceptos();
        
        
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
        ClienteDataAccess.getInstance().update(cliente);
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
            
            ConceptoDataAccess.getInstance().update(c);
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
        FacturaDataAccess.getInstance().insert(f);
    }

    private void addCliente(Cliente c) {
        this.clientes.add(c);
        ClienteDataAccess.getInstance().insert(c);
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

    public int altaCliente(ClienteView vc) {
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
        return c.getId();
        
    }

    public void modificarCliente(ClienteView vc) throws Exception {
        Cliente c = this.buscarCliente(vc.getId());
        
        if(c == null)
            throw new Exception("El cliente ingresado no existe");
        
        if(!c.isActivo())
            throw new Exception("El cliente no puede ser modificado ya que se encuentra inhabilitado");
        
        c.actualizarCliente(vc);
        ClienteDataAccess.getInstance().update(c);
    }

    public void eliminarCliente(int idCliente) throws Exception {
        Cliente c;

        c = this.buscarCliente(idCliente);
        
        if(c == null)
            throw new Exception("El cliente ingresado no existe");
        
        if(!c.isActivo())
            throw new Exception("El cliente ya se encuentra inhabilitado");
        
        c.bajaCliente();
        ClienteDataAccess.getInstance().update(c);
    }
    
    public void generarLiquidacion(){
        Factura factura = null;
        float sub;
        
        inicializarAcumuladorSubsidios();
        for (Cliente elementoCliente : clientes) {
            if (elementoCliente.getEstado() == "Activo") {
                for (Liquidador elementoLiquidador: liquidadores){
                    factura = elementoLiquidador.liquidar(elementoCliente);
                    if (factura != null){
                        factura.setCliente(elementoCliente);
                        elementoCliente.addFactura(factura);
                        elementoCliente.liquidarUltimaMedicion();
                        this.addFactura(factura);
                        ClienteDataAccess.getInstance().update(elementoCliente);
                        // si aplico subsidio actualizo el acumulador de subsidios
                        sub = factura.getSubsidio();
                        if (sub > 0){
                            this.incrementarAcumuladorSubsidios(sub);
                        } 
                        break;
                    }
                }
            }
        }
        if (this.getAcumuladorSubsidios() > 0){
            LiquidacionSubsidioSubject.getInstance().notifySubsidiosAplicados(this.getAcumuladorSubsidios());
        }
        
        imprimirFacturas();
    }
    
    public void inicializar() {
        facturas  = new Vector<Factura>();
        conceptos = new Vector<Concepto>();
        clientes = new Vector<Cliente>();
        ClienteDataAccess.getInstance().removeAll();
        ConceptoDataAccess.getInstance().removeAll();
        FacturaDataAccess.getInstance().removeAll();
        //Crear los parámetros
        conceptos.add(new Concepto("M3 Residencial", 1, ConceptoEnum.M3RESIDENCIAL.getTipoConcepto()));
        conceptos.add(new Concepto("M3 Industrial", 2, ConceptoEnum.M3INDUSTRIAL.getTipoConcepto()));
        conceptos.add(new Concepto("IVA Consumidor Final", 21, ConceptoEnum.IVACONSUMIDORFINAL.getTipoConcepto()));
        conceptos.add(new Concepto("IVA Responsable Inscripto",(float)10.5,ConceptoEnum.IVARESPONSABLE.getTipoConcepto()));
        conceptos.add(new Concepto("Contribuciones Municipales", 3,ConceptoEnum.CONTRIBUCIONESMUNICIPALES.getTipoConcepto() ));
        conceptos.add(new Concepto("Tope Subsidio Residencial", 150,ConceptoEnum.TOPESUBSIDIORESIDENCIAL.getTipoConcepto() ));
        conceptos.add(new Concepto("Tope Sin Transporte", 700, ConceptoEnum.TOPESINTRANSPORTE.getTipoConcepto()));
        conceptos.add(new Concepto("Subsidio Residencial", 5,ConceptoEnum.SUBSIDIORESIDENCIAL.getTipoConcepto() ));
        conceptos.add(new Concepto("Impuesto Ingresos Brutos", 3, ConceptoEnum.IIBB.getTipoConcepto()));
        conceptos.add(new Concepto("Costo por Transporte", 3, ConceptoEnum.TRANSPORTE.getTipoConcepto()));
        
        for (Concepto concepto : conceptos) {
            ConceptoDataAccess.getInstance().insert(concepto);
        }
        
        Collection<Concepto> con = new Vector<Concepto>();
        con.add(buscarConcepto(ConceptoEnum.M3RESIDENCIAL.getTipoConcepto()));
        con.add(buscarConcepto(ConceptoEnum.IVACONSUMIDORFINAL.getTipoConcepto()));
        con.add(buscarConcepto(ConceptoEnum.CONTRIBUCIONESMUNICIPALES.getTipoConcepto()));
        con.add(buscarConcepto(ConceptoEnum.TOPESUBSIDIORESIDENCIAL.getTipoConcepto()));
        con.add(buscarConcepto(ConceptoEnum.SUBSIDIORESIDENCIAL.getTipoConcepto()));
        
        //Crear los liquidadrores
        liquidadores.add(new LiquidadorResidencialSubsidiado(con));
        
        con.removeAll(con);
        
        con.add(buscarConcepto(ConceptoEnum.M3RESIDENCIAL.getTipoConcepto()));
        con.add(buscarConcepto(ConceptoEnum.IVACONSUMIDORFINAL.getTipoConcepto()));
        con.add(buscarConcepto(ConceptoEnum.CONTRIBUCIONESMUNICIPALES.getTipoConcepto()));
        
        liquidadores.add(new LiquidadorResidencial(con));
        
        con.removeAll(con);
        
        con.add(buscarConcepto(ConceptoEnum.M3INDUSTRIAL.getTipoConcepto()));
        con.add(buscarConcepto(ConceptoEnum.IVARESPONSABLE.getTipoConcepto()));
        con.add(buscarConcepto(ConceptoEnum.IIBB.getTipoConcepto()));
        con.add(buscarConcepto(ConceptoEnum.TOPESINTRANSPORTE.getTipoConcepto()));
        con.add(buscarConcepto(ConceptoEnum.TRANSPORTE.getTipoConcepto()));
        
        liquidadores.add(new LiquidadorIndustrialConTransporte(con));
        
        con.removeAll(con);
        con.add(buscarConcepto(ConceptoEnum.M3INDUSTRIAL.getTipoConcepto()));
        con.add(buscarConcepto(ConceptoEnum.IVARESPONSABLE.getTipoConcepto()));
        con.add(buscarConcepto(ConceptoEnum.IIBB.getTipoConcepto()));
        
        liquidadores.add(new LiquidadorIndustrial(con));
    }

    public void imprimirFacturas() {
        for (Factura factura : facturas) {
            System.out.println(factura.toString());
        }
        
    }

    public void imprimirSubsidio() {
        System.out.println(getAcumuladorSubsidios());
    }

    public Vector<ViewConcepto> getConceptos() {
        Vector<ViewConcepto> resultado = new Vector<ViewConcepto>();
        
        for (Concepto concepto : this.conceptos) {
            resultado.add(concepto.getViewConcepto());
        }
        
        return resultado;
    }
    
}
