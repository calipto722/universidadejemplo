package UniversidadEjemplo.AccesoADatos;

import UniversidadEjemplo.Entidades.Alumno;
import UniversidadEjemplo.Entidades.Inscripcion;
import UniversidadEjemplo.Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class InscripcionData {

    private Connection con = null;
    private MateriaData materiaData;
    private AlumnoData alumnoData;

    public InscripcionData() {
        con = Conexion.getConexion();
    }

    public void guardarInscripcion(Inscripcion insc) {

        String sql = "INSERT INTO `inscripcion`( `nota`, `idAlumno`, `idMateria`) "
                + "VALUES (?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // Alumno alumno = alumnoData.buscarAlumno(Statement.RETURN_GENERATED_KEYS);
            //  Materia materia = materiaData.buscarMateria(Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, (int) insc.getNota());
            ps.setInt(2, insc.getAlumno().getIdAlumno());
            ps.setInt(3, insc.getMateria().getIdMateria());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                insc.setIdInscripcion(rs.getInt("idInscripto"));
                JOptionPane.showMessageDialog(null, "Inscripcion añadida con exito ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Inscripcion> obtenerInscripciones() {
        List<Inscripcion> inscripciones = new ArrayList<>();
        String sql = "SELECT * FROM `inscripcion` WHERE 1";
//consultar si se puede guardar asi la inscripcion
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion inscripcion = new Inscripcion();
                Alumno alumno = new Alumno();
                Materia materia = new Materia();
                alumno = alumnoData.buscarAlumno(rs.getInt("idAlumno"));
                materia = materiaData.buscarMateria(rs.getInt("idMateria"));
                inscripcion.setIdInscripcion(rs.getInt("idInscripcion"));
                inscripcion.setAlumno(alumno);
                inscripcion.setMateria(materia);
                inscripcion.setNota(rs.getInt("nota"));
                inscripcion.setMateria(materia);
                inscripciones.add(inscripcion);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion " + ex.getMessage());
        }

        return inscripciones;
    }

    public List<Inscripcion> obtenerInscripcionesPorAlumno(int id) {
        List<Inscripcion> inscripciones = new ArrayList<>();
        String sql = "SELECT * FROM `inscripcion` WHERE inscripcion.idAlumno = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion inscripcion = new Inscripcion();
                Alumno alumno = new Alumno();
                Materia materia = new Materia();
                alumno = alumnoData.buscarAlumno(rs.getInt(id));
                materia = materiaData.buscarMateria(rs.getInt("idMateria"));
                inscripcion.setIdInscripcion(rs.getInt("idInscripcion"));
                inscripcion.setAlumno(alumno);
                inscripcion.setNota(rs.getInt("nota"));
                inscripcion.setMateria(materia);
                inscripciones.add(inscripcion);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion " + ex.getMessage());
        }
        return inscripciones;
    }

    public List<Materia> obtenerMateriasCursadas(int id) {
        List<Materia> materias = new ArrayList<Materia>();
        try {
            String sql = "SELECT `Inscripcion.idMateria`, `nombre`, `año` FROM `inscripcion`, materia "
                    + "WHERE inscripcion.idMateria =materia.idMateria and inscripcion.idAlumno = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Materia materia;
            while (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materias.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener Inscripciones " + ex.getMessage());
        }
        return materias;
    }
    // Revisar
    public List<Materia> obtenerMatriasNOCursadas(int id ){
        List<Materia> materiasNO = new ArrayList<Materia>();
        try {
            String sql = "SELECT `Inscripcion.idMateria`, `nombre`, `año` FROM `inscripcion`, materia "
                    + "WHERE inscripcion.idMateria =materia.idMateria and inscripcion.idAlumno = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Materia materia;
            while (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materiasNO.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener Inscripciones " + ex.getMessage());
        }
        
        return materiasNO;
    }
}
