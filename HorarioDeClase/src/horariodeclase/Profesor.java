/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package horariodeclase;

/**
 *
 * @author Alexateam
 */
public class Profesor {
    
    
    private int hora;
    private String cedula;
    private String nombre;
    private Horario horario;
    private String apellido;

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Profesor() {
    }
    
    

    public Profesor(String nombre, String apellido, String cedula, int hora) {
        this.hora = hora;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    

    public String getCedula() {
        return cedula;
    }

    public int getHora() {
        return hora;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }
    
    
    
    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
