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
import metergas.modelo.Concepto;

/**
 *
 * @author eteodoro
 */
public class ConceptoDataAccess {
    private static ConceptoDataAccess instance;

    private ConceptoDataAccess() {
        
    }
    
    public static ConceptoDataAccess getInstance(){
        if(instance == null)
            instance = new ConceptoDataAccess();
        
        return instance;
    }

    public Collection<Concepto> getConceptos() {
        Vector<Concepto> conceptos = new Vector<Concepto>();
        
        Connection connection = PoolConexiones.getPoolConexiones().getConnection();
        Statement createStatement = null;
        String sentencia = "SELECT codigo, concepto, valor FROM Concepto";
        
        try {
            createStatement = connection.createStatement();
            ResultSet executeQuery = createStatement.executeQuery(sentencia);
            
            while (executeQuery.next()) {        
                int codigo = executeQuery.getInt(1);
                String concepto = executeQuery.getString(2);
                float valor = executeQuery.getFloat(3);
                
                
                Concepto item = new Concepto(concepto, valor, codigo);
                
                conceptos.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConceptoDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            PoolConexiones.getPoolConexiones().realeaseConnection(connection);
        }
        
        return conceptos;
    }

    public void update(Concepto c) {
        Connection connection = PoolConexiones.getPoolConexiones().getConnection();
        try {
            String sentencia = "UPDATE concepto SET concepto = ?, valor = ? WHERE codigo = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sentencia);
            prepareStatement.setString(1, c.getConcepto());
            prepareStatement.setFloat(2, c.getValor());
            prepareStatement.setFloat(3, c.getCodigo());
            
            prepareStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ConceptoDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            PoolConexiones.getPoolConexiones().realeaseConnection(connection);
        }
    }

    public void insert(Concepto concepto) {
         Connection connection = PoolConexiones.getPoolConexiones().getConnection();
        try {
            String sentencia = "INSERT INTO concepto(codigo, concepto, valor) VALUES(?,?,?)";
            PreparedStatement prepareStatement = connection.prepareStatement(sentencia);
            
            prepareStatement.setInt(1, concepto.getCodigo());
            prepareStatement.setString(2, concepto.getConcepto());
            prepareStatement.setFloat(3, concepto.getValor());
            
            prepareStatement.execute();
            
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
            String sentencia = "DELETE FROM Concepto";
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
