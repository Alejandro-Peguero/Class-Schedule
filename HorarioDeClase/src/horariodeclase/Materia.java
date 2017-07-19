/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package horariodeclase;
import java.util.ArrayList;

/**
 *
 * @author Alexateam
 */
public class Materia {
    
    private String nombre;
    private String aula;
    private Integer creditos;

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public Materia(String nombre, String aula, Integer creditos) {
        this.nombre = nombre;
        this.aula = aula;
        this.creditos = creditos;
    }
    

    public Materia(String nombre, String aula) {
        this.nombre = nombre;
        this.aula = aula;
    }

    public String getAula() {
        return aula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Materia() {
    }
    
    
    
}
