/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package horariodeclase;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexateam
 */
public class ListaDeMateri {
    
    private List<Materia> materias;
    
    public ListaDeMateri()
    {
        materias = new ArrayList<Materia>();
        materias.add(new Materia("Calculo Diferencial", "1-1C",4));
        materias.add(new Materia("Calculo Integral", "4-1C",4));
        materias.add(new Materia("Programacion I", "4-1B",4));
        materias.add(new Materia("Programacion II", "CAD",4));
        materias.add(new Materia("Etica ", "3-2D",4));
        materias.add(new Materia("Precalculo", "5-2D",4));
        materias.add(new Materia("Analisis y Diseno", "3-2D",4));


    }
    
    public List<Materia> getMaterias()
    {
        return materias;
    }
    
    
    
}
