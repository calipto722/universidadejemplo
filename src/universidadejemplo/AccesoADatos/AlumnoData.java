/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadejemplo.AccesoADatos;

import java.sql.Connection;
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
        
        
    }
    
    
}
