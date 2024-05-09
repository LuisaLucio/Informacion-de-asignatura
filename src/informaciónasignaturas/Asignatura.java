package informaciónasignaturas;


/**
 *
 * @author Usuario
 */
public class Asignatura {
    public String nombre;
    public int creditos;
    public int semestre;
    public String programa;    
    
    public Asignatura() {
    }
     
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Créditos: " + creditos + ", Semestre: " + semestre + ", Programa Académico: " + programa;
    }
}
