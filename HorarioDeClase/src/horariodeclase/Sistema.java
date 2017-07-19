/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package horariodeclase;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author Alexateam
 *
 */
public class Sistema {
    
    List<Profesor> profesores;
    Scanner console = new Scanner(System.in);
    Map<Integer, String> dias = new HashMap<Integer, String>();
    
    public void imprimirPDF() throws FileNotFoundException, DocumentException
    {
        
        if(profesores.size()==0)
        {
            System.out.println("No hay profesores");
            System.out.println("Ingrese cuaquier tecla para volver el Menu Principa");
            String te = console.next();
            menu();
            
        }
        else
        {
            Document document=new Document() {}; 
    PdfWriter.getInstance(document,new FileOutputStream("PrintHorario.pdf"));
    document.open(); 
    document.add(new Paragraph("*************HORARIO DE PROFESORES DEL ITLA*****************")); 
    String output= "";
    
                Map<String, Materia> materias = new HashMap<String,Materia>();
                Horario horario;
    
    for(Profesor prof: profesores)
            {
             //   System.out.println("Horario del profesor: " + prof.getNombre());
          output+="Horario del profesor: " + prof.getNombre() + " \n";
               horario = prof.getHorario();
             
               materias = horario.getMaterias();
              // System.out.println("Tanda: \n" + horario.getTanda());
              output+="Tanda: " + horario.getTanda() + "\n";
               for(int i =0; i<materias.size(); i++)
               {
                   
                  
                   Materia mat = materias.get(dias.get(i+1));
                  

                   if(mat==null)
                   { 
                       //System.out.println("El " + dias.get(i+1) + " no tiene clases");
                       output+="El " + dias.get(i +1) + " no tiene clases \n";
                   }
                     
                   else
                   {
                   //System.out.println("El " + dias.get(i+1) + " tiene " + mat.getNombre() + " en el Aula " + mat.getAula());
                   output+="El " + dias.get(i+1) + " tiene " + mat.getNombre() + " en el aula " + mat.getAula() + " \n";
                           }
               }
               
                    document.add(new Paragraph(output)); 

            }
    
    document.close();
    System.out.println("Documento impreso");
    
    System.out.println("Ingrese una tecla para volver al Menu Principal");
    String l = console.next();
    menu();
        }

    }
    
    public void imprimir(Profesor profesor)
    {
        System.out.println("Profesor: " + profesor.getNombre());
         Horario temp = profesor.getHorario();
        Map<String, Materia> materias = new HashMap<String,Materia>();
        
        materias = temp.getMaterias();
        System.out.println(materias.size());
        
        
        System.out.println("Dia: " + dias.get(1));
        Materia mat = materias.get("Lunes");
        if(mat==null)
                    System.out.println("No hay materias para este profesor");
                else
        System.out.println("Nombre de la materia " + mat.getNombre());
        

    
    }
    
    
    public void imprimirHorarios()
    {
        
        //variable para guardar las materias de x profesor.
  
                Map<String, Materia> materias = new HashMap<String,Materia>();
                Horario horario;

        if(profesores.size()==0)
        {
            
            System.out.println("No hay horarios actualmente agregados!");
            System.out.println("Ingrese cualquier letra para volver al menu principal");
            String letra = console.next();
            menu();
        }
        else
        {
            //Si la lista contiene 1 o mas profesores.
            System.out.println();
            System.out.println();
            System.out.println("**********************************************************************************");
            System.out.println("***********************Imprimiendo horarios***************************************");
            System.out.println("***********************************************************************************");

            
            /**
             * 
             * 
             */
          
            for(Profesor prof: profesores)
            {
                System.out.println("Horario del profesor: " + prof.getNombre());
          
               horario = prof.getHorario();
             
               materias = horario.getMaterias();
               System.out.println("Tanda: \n" + horario.getTanda());
              
               for(int i =0; i<materias.size(); i++)
               {
                   
                  
                   Materia mat = materias.get(dias.get(i+1));
                  

                   if(mat==null)
                       System.out.println("El " + dias.get(i+1) + " no tiene clases");
                   else
                   System.out.println("El " + dias.get(i+1) + " tiene " + mat.getNombre() + " en el Aula " + mat.getAula());
          
               }
               
                
            }
            
    
            System.out.println("Presion cualquier tecla para volver al Menu Principal");
            String tecla = console.next();
            menu();
        
        
        
        }
    }
    
    public void setearDias()
    {
        dias.put(1, "Lunes");
        dias.put(2, "Martes");
        dias.put(3, "Miercoles");
        dias.put(4, "Jueves");
        dias.put(5, "Viernes");
        dias.put(6, "Sabado");
    }
    
    public Sistema() //Constructor.
    {
        
        /**
         * 
         * Este es el constructor que inicializa el programa.
         * 
         */
          System.out.println("*****Bienvenido al Sistema de registro ");
         
          profesores = new ArrayList<Profesor>();
        setearDias();
        //Este es el menu
        menu();
    }
    
    public void agregarProfesor()
    {
        Profesor profesor = new Profesor();
       
        System.out.println("Ingrese el nombre del profesor");
        String nombreProfesor = console.next();
        
        profesor.setNombre(nombreProfesor);
      
        Horario temp = agregarHorario();
      
         profesor.setHorario(temp);
    
        profesores.add(profesor);
            System.out.println("Profesor " + profesor.getNombre() + " agregado con exito");
            System.out.println("Presione cualquier tecla para volver al Menu Principal");
            String t = console.next();
            menu();
            
        
        
        
    }
    
    
    public Horario agregarHorario()
    {
        Horario horario = new Horario();
        String tanda = "";
        
        System.out.println("Tanda: \n1. Manana\n2.Tarde");
        String tan = console.next();
        
        if(tan.equals("1"))
            tanda = "Manana";
        else if(tan.equals("2"))
            tanda= "Tarde";
        
        horario.setTanda(tanda);
        
        //Agregando materias
        for(int i=1; i<7; i++)
        {
            System.out.println("Desea agregar materia para el " + dias.get(i) + " ?\n1.Si\n2.No");
            String sel = console.next();
    
            if(sel.equals("1")){
            Materia mate;

            mate = agregarMateria();
            
   
            horario.getMaterias().put(dias.get(i), mate);
            }
            
        }
        
        
        
        return horario;
        
        
    }
    
   
    public Materia agregarMateria()
    {
        
        System.out.println("Ingrese nombre de la materia");
        String nombre = console.next();
        System.out.println("Ingrese aula de la materia: ");
        String aula = console.next();
       
        Materia temp = new Materia(nombre,aula);
        
        //retorna una materia;
        return temp;
    }
    
    //Menu principal
    public void menu()
    {
        /**
         * Este es el menu principal
         *  
         * 
         */
        String seleccion = "";
        
      
        while(true){
            System.out.println("A continuacion digite el Numero de la opcion  desea ejecutar: ");
            
        System.out.println("1. Generar Horario\n2. Imprimir Horarios\n3.IMPRIMIR EL PDF\n4.salir.");
        /**
             
             */
          seleccion= console.next();
        if(seleccion.equals("1"))
            agregarProfesor();
        else if(seleccion.equals("2"))
            imprimirHorarios();
        else if(seleccion.equals("3"))
            try {          
                imprimirPDF();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
            }          
        else if(seleccion.equals("4"))
       System.exit(0);
           
            System.out.println("Opcion invalida");
          
           }
        
        
        
    }
    
    
    
    
}
