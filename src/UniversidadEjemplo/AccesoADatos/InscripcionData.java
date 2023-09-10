package UniversidadEjemplo.AccesoADatos;

import UniversidadEjemplo.Entidades.Alumno;
import UniversidadEjemplo.Entidades.Inscripcion;
import UniversidadEjemplo.Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class InscripcionData {

    private Connection con = null;
    private MateriaData materiaData;
    private AlumnoData alumnoData;

    public InscripcionData() {
        con = Conexion.getConexion();
    }

    public void guardarInscripcion(Inscripcion insc) {

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
                inscripcion.setNota(rs.getInt("nota"));
                inscripciones.add(inscripcion);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion " + ex.getMessage());
        }

        return inscripciones;
    }
}
