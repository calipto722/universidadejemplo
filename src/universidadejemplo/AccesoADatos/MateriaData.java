/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadejemplo.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import universidadejemplo.Entidades.Materia;
/**
 *
 * @author noelia
 */
public class MateriaData {
    
    private Connection con =null;
    
    public MateriaData(){
     con =Conexion.getConexion();
}
public void guargarMateria (Materia materia){
 String sql= "INSERT INTO `materia`( `nombre`, `año`, `estado`) VALUES ('?','?','?','?')";

        try {
            PreparedStatement ps= con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }



}
}
