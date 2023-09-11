
package UniversidadEjemplo.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import UniversidadEjemplo.Entidades.Materia;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MateriaData {

    private Connection con = null;
    
    
    public MateriaData() {
        con = Conexion.getConexion();
    }

    public void guargarMateria(Materia materia) {

        String sql = "INSERT INTO `materia`( `nombre`, `año`, `estado`) VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isActivo());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setIdMateria(rs.getInt("idMateria"));
                JOptionPane.showMessageDialog(null, "Materia añadida con exito ");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia " + ex.getMessage());
        }

    }

    public Materia buscarMateria(int id) {
        Materia materia = null;
        String sql = "SELECT `nombre`, `año`, `estado` FROM `materia` WHERE idMateria=? and `estado` =1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(id);
                materia.setAnioMateria(rs.getInt("año"));
                materia.setNombre(rs.getString("nombre"));
                materia.setActivo(true);
            } else {
                JOptionPane.showMessageDialog(null, "No existe la Materia");
                ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno " + ex.getMessage());
        }

        return materia;
    }

    public void modificarMateria(Materia materia ) {
 String sql = " UPDATE `materia` SET `nombre`=?,`año`=?,`estado`=? WHERE idMateria= ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isActivo());
            ps.setInt(4, materia.getIdMateria());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente. ");
            } else {
                JOptionPane.showMessageDialog(null, "La Materia no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia" + ex.getMessage());
        }

    }

    public void eliminarMateria(int id) {
        String sql = "UPDATE materia SET estado= 0 WHERE idAlumno= ? ";

        try {
           PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
        int fila = ps.executeUpdate();
        if (fila== 1) {
            JOptionPane.showMessageDialog(null, "Se elimino la materia, ");
        }
        ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia");
        }
       
    }

    public List<Materia> listarMaterias() {
        List<Materia> materias = new ArrayList<>();

        String sql = "SELECT*FROM materia WHERE estado =1 ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setAnioMateria(rs.getInt("año"));
                materia.setNombre(rs.getString("nombre"));
                materia.setActivo(true);
                materias.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia " + ex.getMessage());
        }
        return materias;
    }

}
