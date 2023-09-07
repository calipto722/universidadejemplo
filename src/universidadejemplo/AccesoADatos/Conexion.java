/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadejemplo.AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author alejo
 */
public class Conexion {
    private static final String url="jdbc:mariadb://localhost:3306/";
    private static final String Db="universidadejemplo";
    private static final String usuario="root";
    private static  String password="";

    private static Connection connection;
    
    private Conexion() {
    }
   

    
    public static Connection getConexion() {
//        Connection con=null;
    
        if(connection == null){
          
           
        
        try {
            Class.forName("org.mariadb.jbdc.Driver");
        
            // Setup the connection with the DB
            connection = DriverManager.getConnection(url +Db+ "?useLegacyDatetimeCode=false&serverTimezone=UTC" + "&user=" + usuario + "&password=" + password);
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion "+ ex.getMessage());
        }   catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar los drivers"+ex.getMessage());
            }
        
        
    }
    return connection;    

}
}

