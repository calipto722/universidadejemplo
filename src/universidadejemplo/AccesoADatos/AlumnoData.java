/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadejemplo.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import universidadejemplo.Entidades.Alumno;

/**
 *
 * @author noelia
 */
public class AlumnoData {
    private Connection con=null;

    public AlumnoData() {
        
        con= Conexion.getConexion();
    }
    
    public void guardarAlumno(Alumno alumno){
        
        String sql= "INSERT INTO alumno (dni, apellido,nombre,fechaNacimiento,estado)"+
                "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.get);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
