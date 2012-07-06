/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.modelo.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import metergas.modelo.Cliente;
import metergas.modelo.ClienteIndustrial;
import metergas.modelo.ClienteResidencial;
import metergas.modelo.Domicilio;

/**
 *
 * @author eteodoro
 */
public class ClienteIndustrialDataAccess {

    private static ClienteIndustrialDataAccess instance;

    private ClienteIndustrialDataAccess() {
    }

    public static ClienteIndustrialDataAccess getInstance() {
        if (instance == null) {
            instance = new ClienteIndustrialDataAccess();
        }

        return instance;
    }

    public ClienteIndustrial findCliente(int id, Domicilio domicilio) {
        ClienteIndustrial cliente = null;
        Connection connection = PoolConexiones.getPoolConexiones().getConnection();
        String sentencia = "SELECT clienteId, razonSocial, nroIBBB, condicionFiscal, CUIT FROM ClienteIndustrial WHERE clienteid = ?";
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sentencia);
            prepareStatement.setInt(1, id);
            ResultSet executeQuery = prepareStatement.executeQuery();
            
            if (executeQuery.next()) {
                String razonSocial  =executeQuery.getString(2);
                String nroIBBB  =executeQuery.getString(3);
                String condicionFiscal  =executeQuery.getString(4);
                String CUIT  =executeQuery.getString(5);
                
                cliente = new ClienteIndustrial(id, razonSocial, nroIBBB, condicionFiscal, CUIT,domicilio);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteResidencialDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cliente;
    }

    void insert(ClienteIndustrial cliente) {
         Connection connection = PoolConexiones.getPoolConexiones().getConnection();
        String sentencia = "INSERT INTO ClienteIndustrial  (clienteId, razonSocial, nroIBBB, condicionFiscal, CUIT)  VALUES(?, ?, ?,?,?)";
        
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sentencia);
            prepareStatement.setInt(1, cliente.getId());
            prepareStatement.setString(2, cliente.getRazonSocial());
            prepareStatement.setString(3, cliente.getNroIIBB());
            prepareStatement.setString(4, cliente.getCondicionFiscal());
            prepareStatement.setString(5, cliente.getCUIT());
            
            prepareStatement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteResidencialDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void update(ClienteIndustrial cliente) {
        Connection connection = PoolConexiones.getPoolConexiones().getConnection();
        String sentencia = "UPDATE ClienteIndustrial SET razonSocial = ?, nroIBBB = ?, condicionFiscal = ?, CUIT = ? WHERE clienteid = ?";
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sentencia);
            
            prepareStatement.setString(1, cliente.getRazonSocial());
            prepareStatement.setString(2, cliente.getNroIIBB());
            prepareStatement.setString(3, cliente.getCondicionFiscal());
            prepareStatement.setString(4, cliente.getCUIT());
            prepareStatement.setInt(5, cliente.getId());
            
            prepareStatement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteResidencialDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
