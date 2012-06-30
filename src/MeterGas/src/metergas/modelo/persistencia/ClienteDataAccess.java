/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.modelo.persistencia;

import java.sql.*;
import java.util.Collection;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import metergas.modelo.*;

/**
 *
 * @author eteodoro
 */
public class ClienteDataAccess {

    private static ClienteDataAccess instance;

    private ClienteDataAccess() {
    }

    public static ClienteDataAccess getInstance() {
        if (instance == null) {
            instance = new ClienteDataAccess();
        }

        return instance;
    }

    public Collection<Cliente> getClientes() {
        Vector<Cliente> clientes = new Vector<Cliente>();

        Connection connection = PoolConexiones.getPoolConexiones().getConnection();
        Statement createStatement = null;
        String sentencia = "SELECT id, estado, tipo FROM Cliente";

        try {
            createStatement = connection.createStatement();
            ResultSet executeQuery = createStatement.executeQuery(sentencia);

            while (executeQuery.next()) {
                int id = executeQuery.getInt(1);
                String estado = executeQuery.getString(2);
                String tipo = executeQuery.getString(3);

                Domicilio domicilio = getDomicilio(id);
                Cliente item = findCliente(id, estado, tipo, domicilio);

                clientes.add(item);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ConceptoDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConceptoDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            PoolConexiones.getPoolConexiones().realeaseConnection(connection);
        }

        return clientes;
    }

    public Cliente findCliente(int clienteId) {
        Cliente cliente = null;
        Connection connection = PoolConexiones.getPoolConexiones().getConnection();
        PreparedStatement statement = null;
        String sentencia = "SELECT id, estado, tipo FROM Cliente WHERE id = ?";

        try {
            statement = connection.prepareStatement(sentencia);
            ResultSet executeQuery = statement.executeQuery(sentencia);

            if (executeQuery.next()) {
                int id = executeQuery.getInt(1);
                String estado = executeQuery.getString(2);
                String tipo = executeQuery.getString(3);

                Domicilio domicilio = getDomicilio(id);
                cliente = findCliente(id, estado, tipo, domicilio);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConceptoDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConceptoDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            PoolConexiones.getPoolConexiones().realeaseConnection(connection);
        }

        return cliente;
    }

    private Cliente findCliente(int id, String estado, String tipo, Domicilio domicilio) throws ClassNotFoundException {
        Cliente cliente = null;
        Class<?> tipoInstancia = Class.forName(tipo);

        if (tipoInstancia == ClienteResidencial.class) {
            cliente = ClienteResidencialDataAccess.getInstance().findCliente(id, domicilio);
        } else if (tipoInstancia ==  ClienteIndustrial.class) {
            cliente = ClienteIndustrialDataAccess.getInstance().findCliente(id, domicilio);
        }
        
        cliente.setEstado(estado);
        
        return cliente;
    }

    private Domicilio getDomicilio(int id) {
        Domicilio domicilio = null;
        Connection connection = PoolConexiones.getPoolConexiones().getConnection();
        String sentencia = "SELECT calle, altura, piso, departamento, codigoPostal, localidad, provincia, clienteId FROM Domicilio WHERE clienteid = ?";
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sentencia);
            prepareStatement.setInt(1, id);
            ResultSet executeQuery = prepareStatement.executeQuery();

            if (executeQuery.next()) {
                String calle = executeQuery.getString(2);
                String altura = executeQuery.getString(3);
                String piso = executeQuery.getString(4);
                String departamento = executeQuery.getString(5);
                String codigoPostal = executeQuery.getString(6);
                String localidad = executeQuery.getString(7);
                String provincia = executeQuery.getString(8);

                domicilio = new Domicilio(calle, altura, piso, departamento, codigoPostal, localidad, provincia);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteResidencialDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            PoolConexiones.getPoolConexiones().realeaseConnection(connection);
        }

        return domicilio;
    }

    public void insert(Cliente cliente) {
        Connection connection = PoolConexiones.getPoolConexiones().getConnection();
        try {
            String sentencia = "INSERT INTO Cliente (estado, tipo) VALUES (?, ?)";
            PreparedStatement prepareStatement = connection.prepareStatement(sentencia,Statement.RETURN_GENERATED_KEYS);

            prepareStatement.setString(1, cliente.getEstado());
            prepareStatement.setString(2, cliente.getClass().toString().replace("class ", ""));

            prepareStatement.executeUpdate();
            prepareStatement.getGeneratedKeys().next();
            
            cliente.setId(prepareStatement.getGeneratedKeys().getInt(1));
            
            if (cliente instanceof ClienteResidencial) {
                ClienteResidencialDataAccess.getInstance().insert((ClienteResidencial) cliente);
            } else if (cliente instanceof ClienteIndustrial) {
                ClienteIndustrialDataAccess.getInstance().insert((ClienteIndustrial) cliente);
            }
            
            insertDomicilio(cliente);

        } catch (SQLException ex) {
            Logger.getLogger(ConceptoDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            PoolConexiones.getPoolConexiones().realeaseConnection(connection);
        }
    }

    private void insertDomicilio(Cliente cliente) {
        Connection connection = PoolConexiones.getPoolConexiones().getConnection();
        try {
            String sentencia = "INSERT INTO Domicilio(calle, altura, piso, departamento, codigoPostal, localidad, provincia, clienteId) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement prepareStatement = connection.prepareStatement(sentencia);
            Domicilio domicilio = cliente.getDomicilio();
            prepareStatement.setString(1, domicilio.getCalle());
            prepareStatement.setString(2, domicilio.getAltura());
            prepareStatement.setString(3, domicilio.getPiso());
            prepareStatement.setString(4, domicilio.getDepartamento());
            prepareStatement.setString(5, domicilio.getCodigoPostal());
            prepareStatement.setString(6, domicilio.getLocalidad());
            prepareStatement.setString(7, domicilio.getProvincia());
            prepareStatement.setInt(8, cliente.getId());

            prepareStatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ConceptoDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            PoolConexiones.getPoolConexiones().realeaseConnection(connection);
        }
    }

    public void removeAll() {
        Connection connection = PoolConexiones.getPoolConexiones().getConnection();
        try {
            String sentencia = "DELETE FROM Medicion;DELETE FROM Domicilio; DELETE FROM ClienteResidencial; DELETE FROM ClienteIndustrial; DELETE FROM Cliente";
            PreparedStatement prepareStatement = connection.prepareStatement(sentencia);
            prepareStatement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(ConceptoDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            PoolConexiones.getPoolConexiones().realeaseConnection(connection);
        }
    }

    public void update(Cliente cliente) {
           
        if (cliente instanceof ClienteResidencial) {
            ClienteResidencialDataAccess.getInstance().update((ClienteResidencial) cliente);
        } else if (cliente instanceof ClienteIndustrial) {
            ClienteIndustrialDataAccess.getInstance().update((ClienteIndustrial) cliente);
        }
        
        updateDomicilio(cliente);
        updateMediciones(cliente);
    }

    private void updateDomicilio(Cliente cliente) {
        Connection connection = PoolConexiones.getPoolConexiones().getConnection();
        try {
            String sentencia = "UPDATE Domicilio SET calle = ?, altura = ?,   piso = ?, departamento = ?, codigoPostal = ?, localidad = ?, provincia = ? WHERE clienteId = ?" ;

            PreparedStatement prepareStatement = connection.prepareStatement(sentencia);
            Domicilio domicilio = cliente.getDomicilio();
            prepareStatement.setString(1, domicilio.getCalle());
            prepareStatement.setString(2, domicilio.getAltura());
            prepareStatement.setString(3, domicilio.getPiso());
            prepareStatement.setString(4, domicilio.getDepartamento());
            prepareStatement.setString(5, domicilio.getCodigoPostal());
            prepareStatement.setString(6, domicilio.getLocalidad());
            prepareStatement.setString(7, domicilio.getProvincia());
            prepareStatement.setInt(8, cliente.getId());

            prepareStatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ConceptoDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            PoolConexiones.getPoolConexiones().realeaseConnection(connection);
        }
    }

    private void updateMediciones(Cliente cliente) {
        Connection connection = PoolConexiones.getPoolConexiones().getConnection();
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("DELETE FROM Medicion WHERE clienteid = ?");
            prepareStatement.setInt(1, cliente.getId());
            
            prepareStatement.execute();
            
            prepareStatement = connection.prepareStatement("INSERT INTO Medicion(clienteId, valor,   liquidado,   fecha) VALUES (?, ?, ?, ?)");
            prepareStatement.setInt(1, cliente.getId());
            
            for (Medicion medicion : cliente.getMediciones()) {
                prepareStatement.setFloat(2, medicion.getValor());
                prepareStatement.setBoolean(3, medicion.isLiquidado());
                prepareStatement.setDate(4, new java.sql.Date(medicion.getFecha().getYear(), medicion.getFecha().getMonth(), medicion.getFecha().getDay()));
                
                prepareStatement.execute();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            PoolConexiones.getPoolConexiones().realeaseConnection(connection);
        }
                
        
    }
}
