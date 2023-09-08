
package universidadejemplo.Entidades;


public class Inscripcion {
    private int idInscripcion;
    private Materia materia;
    private Alumno alumno;
    private double nota;

    public Inscripcion(Materia materia, Alumno alumno, double nota) {
        this.materia = materia;
        this.alumno = alumno;
        this.nota = nota;
    }

    public Inscripcion(int idInscripcion, Materia materia, Alumno alumno, double nota) {
        this.idInscripcion = idInscripcion;
        this.materia = materia;
        this.alumno = alumno;
        this.nota = nota;
    }

    public Inscripcion() {
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "idInscripcion=" + idInscripcion + ", materia=" + materia + ", alumno=" + alumno + ", nota=" + nota + '}';
    }
    
}
