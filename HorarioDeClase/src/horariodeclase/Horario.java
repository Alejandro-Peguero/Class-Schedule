/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package horariodeclase;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Alexateam
 */
public class Horario {
    
    
    private String tanda;
    
    
    private Map<String, Materia> materias = new HashMap<String,Materia>();
    

    public Map<String, Materia> getMaterias() {
        return materias;
    }

    public String getTanda() {
        return tanda;
    }

    public void setMaterias(Map<String, Materia> materias) {
        this.materias = materias;
    }

    public void setTanda(String tanda) {
        this.tanda = tanda;
    }
    
    
    
}
