/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.modelo.persistencia;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;

/**
 *
 * @author eteodoro
 */
public class PoolConexiones {

    private Vector<Connection> conexiones = new Vector<Connection>();
    protected String connectionString;
    protected String user;
    protected String password;
    
    protected int maxConnections;
    private static PoolConexiones instancia;

    private PoolConexiones() {
        cargarConfiguracion();
        for (int i = 0; i < maxConnections; i++) {
            conexiones.add(connect());
        }
    }

    public static PoolConexiones getPoolConexiones() {
        if (instancia == null) {
            instancia = new PoolConexiones();
        }
        return instancia;
    }

    private Connection connect() {
        try {
            //Setear driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection con = DriverManager.getConnection(connectionString, user, password);

            return con;
        } catch (SQLException e) {
            System.out.println("Mensaje Error: " + e.getMessage());
            System.out.println("Stack Trace: " + e.getStackTrace());
            return null;
        } catch (Exception ex) {
            System.out.println("Mensaje Error: " + ex.getMessage());
            System.out.println("Stack Trace: " + ex.getStackTrace());
            return null;
        }
    }

    public void cargarConfiguracion() {
        String configuracion = "configuracion.db.properties";
        Properties propiedades;

        // Carga del fichero de propiedades 
        try {
            FileInputStream f = new FileInputStream(configuracion);
            propiedades = new Properties();
            propiedades.load(f);
            f.close();

            // Leo los valores de configuracion
            connectionString = propiedades.getProperty("connectionString");
            user = propiedades.getProperty("user");
            password = propiedades.getProperty("password");
            maxConnections = Integer.parseInt(propiedades.getProperty("maxConnections"));
        } catch (Exception e) {
            System.out.println("Mensaje Error: " + e.getMessage());
            System.out.println("Stack Trace: " + e.getStackTrace());
        }
    }

    public void closeConnections() {
        for (int i = 0; i < conexiones.size(); i++) {
            try {
                conexiones.elementAt(i).close();
            } catch (Exception e) {
                System.out.println("Mensaje Error: " + e.getMessage());
                System.out.println("Stack Trace: " + e.getStackTrace());
            }
        }
    }

    public Connection getConnection() {
        Connection c = null;
        if (conexiones.size() > 0) {
            c = conexiones.remove(0);
        } else {
            c = connect();
            System.out.println("Se ha creado una nueva conexion fuera de los parametros de configuracion");
        }
        return c;
    }

    public void realeaseConnection(Connection c) {
        conexiones.add(c);
    }
}
