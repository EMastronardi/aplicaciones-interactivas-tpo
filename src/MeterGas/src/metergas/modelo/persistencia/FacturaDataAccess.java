/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.modelo.persistencia;

import java.sql.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import metergas.modelo.Cliente;
import metergas.modelo.Factura;
import metergas.modelo.ItemFactura;

/**
 *
 * @author eteodoro
 */
public class FacturaDataAccess {

    private static FacturaDataAccess instance;

    private FacturaDataAccess() {
    }

    public static FacturaDataAccess getInstance() {
        if (instance == null) {
            instance = new FacturaDataAccess();
        }

        return instance;
    }

    public Collection<Factura> getFacturas() {
        Vector<Factura> facturas = new Vector<Factura>();

        Connection connection = PoolConexiones.getPoolConexiones().getConnection();
        Statement createStatement = null;
        String sentencia = "SELECT nro, clienteId, fecha, subsidio, consumo FROM Factura";

        try {
            createStatement = connection.createStatement();
            ResultSet executeQuery = createStatement.executeQuery(sentencia);

            while (executeQuery.next()) {
                int nro = executeQuery.getInt(1);
                int clienteId = executeQuery.getInt(2);
                Date fecha = executeQuery.getDate(3);
                float subsidio = executeQuery.getFloat(4);
                float consumo = executeQuery.getFloat(5);
                Cliente cliente = ClienteDataAccess.getInstance().findCliente(clienteId);
                Collection<ItemFactura> items = getItems(nro);
                Factura item = new Factura(nro, fecha, consumo, cliente, items, subsidio);

                facturas.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConceptoDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            PoolConexiones.getPoolConexiones().realeaseConnection(connection);
        }

        return facturas;
    }

    private Collection<ItemFactura> getItems(int nroFactura) {
        Vector<ItemFactura> items = new Vector<ItemFactura>();

        Connection connection = PoolConexiones.getPoolConexiones().getConnection();
        PreparedStatement createStatement = null;
        String sentencia = "SELECT concepto, valor FROM ItemFactura WHERE nroFactura = ?";

        try {
            createStatement = connection.prepareStatement(sentencia);
            createStatement.setInt(1, nroFactura);
            ResultSet executeQuery = createStatement.executeQuery();

            while (executeQuery.next()) {
                String concepto = executeQuery.getString(1);
                float valor = executeQuery.getFloat(2);

                ItemFactura item = new ItemFactura(concepto, valor);

                items.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConceptoDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            PoolConexiones.getPoolConexiones().realeaseConnection(connection);
        }

        return items;
    }

    public void insert(Factura factura) {
           Connection connection = PoolConexiones.getPoolConexiones().getConnection();
        try {
            String sentencia = "INSERT INTO Factura(clienteId, fecha, subsidio, consumo) VALUES (?, ?, ?, ?)";
            PreparedStatement prepareStatement = connection.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
            
            prepareStatement.setInt(1, factura.getCliente().getId());
            prepareStatement.setDate(2, new java.sql.Date(factura.getFecha().getYear(),factura.getFecha().getMonth(),factura.getFecha().getDay()));
            prepareStatement.setFloat(3, factura.getSubsidio());
            prepareStatement.setFloat(4, factura.getConsumo());
            
            prepareStatement.executeUpdate();
            prepareStatement.getGeneratedKeys().next();
            
            factura.setNro(prepareStatement.getGeneratedKeys().getInt(1));
            
            insertItems(factura);
            
        } catch (SQLException ex) {
            Logger.getLogger(ConceptoDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            PoolConexiones.getPoolConexiones().realeaseConnection(connection);
        }
    }

    private void insertItems(Factura factura) {
        Connection connection = PoolConexiones.getPoolConexiones().getConnection();
        try {
            String sentencia = "INSERT INTO ItemFactura(nroFactura, concepto, valor) VALUES (?, ?, ?)";
            PreparedStatement prepareStatement = connection.prepareStatement(sentencia, PreparedStatement.RETURN_GENERATED_KEYS);
            
            prepareStatement.setInt(1, factura.getNro());
            
            for (ItemFactura item : factura.getItems()) {
                prepareStatement.setString(2, item.getConcepto());
                prepareStatement.setFloat(3, item.getValor());
                prepareStatement.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConceptoDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            PoolConexiones.getPoolConexiones().realeaseConnection(connection);
        }
    }

    public void removeAll() {
        Connection connection = PoolConexiones.getPoolConexiones().getConnection();
        try {
            String sentencia = "DELETE FROM ItemFactura;DELETE FROM Factura;";
            PreparedStatement prepareStatement = connection.prepareStatement(sentencia);
            prepareStatement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(ConceptoDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            PoolConexiones.getPoolConexiones().realeaseConnection(connection);
        }
    }
}
