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
import metergas.modelo.ClienteResidencial;
import metergas.modelo.Domicilio;

/**
 *
 * @author eteodoro
 */
public class ClienteResidencialDataAccess {

    private static ClienteResidencialDataAccess instance;

    private ClienteResidencialDataAccess() {
    }

    public static ClienteResidencialDataAccess getInstance() {
        if (instance == null) {
            instance = new ClienteResidencialDataAccess();
        }

        return instance;
    }

    public ClienteResidencial findCliente(int id, Domicilio domicilio) {
        ClienteResidencial cliente = null;
        Connection connection = PoolConexiones.getPoolConexiones().getConnection();
        String sentencia = "SELECT clienteid, nombre, apellido, dni FROM ClienteResidencial WHERE clienteid = ?";
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sentencia);
            prepareStatement.setInt(1, id);
            ResultSet executeQuery = prepareStatement.executeQuery();
            
            if (executeQuery.next()) {
                String nombre  =executeQuery.getString(2);
                String apellido  =executeQuery.getString(3);
                String dni  =executeQuery.getString(4);
                
                cliente = new ClienteResidencial(nombre, apellido, dni, domicilio);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteResidencialDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cliente;
    }

    void insert(ClienteResidencial cliente) {
        Connection connection = PoolConexiones.getPoolConexiones().getConnection();
        String sentencia = "INSERT INTO ClienteResidencial(clienteid, nombre,apellido, dni) VALUES(?,?, ?,?)";
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sentencia);
            prepareStatement.setInt(1, cliente.getId());
            prepareStatement.setString(2, cliente.getNombre());
            prepareStatement.setString(3, cliente.getApellido());
            prepareStatement.setString(4, cliente.getDni());
            
            prepareStatement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteResidencialDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void update(ClienteResidencial cliente) {
        Connection connection = PoolConexiones.getPoolConexiones().getConnection();
        String sentencia = "UPDATE ClienteResidencial SET  nombre = ?, apellido = ?, dni = ? WHERE clienteid = ?";
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sentencia);
            
            prepareStatement.setString(1, cliente.getNombre());
            prepareStatement.setString(2, cliente.getApellido());
            prepareStatement.setString(3, cliente.getDni());
            prepareStatement.setInt(4, cliente.getId());
            
            prepareStatement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteResidencialDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
