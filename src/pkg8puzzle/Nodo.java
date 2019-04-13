package pkg8puzzle;
 
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;
 
/**
 *
 * @author Mario R�os
 */
public class Nodo {
    private String estado;
    private Collection<Nodo> hijos;
    Nodo padre;
    private int profundidad;
    
    public Nodo(String estado)
    {
        this.estado = estado;
        hijos = new ArrayList<>();
    }
 
    public String getEstado() {
        return estado;
    }
 
    public Collection<Nodo> getHijos() {
        return hijos;
    }
 
    //Agrega 1 Nodo hijo
    public void agregarHijos(Nodo h) {
        this.hijos.add(h);
    }
 
    public Nodo getPadre() {
        return padre;
    }
 
    public void setPadre(Nodo padre) {
        this.padre = padre;
    }
 
    public Collection<String> generaHijos() {
        //|0|1|2|
        //|3|4|5|   Indices
        //|6|7|8|
    	ArrayList<String>hijosGenerados=new ArrayList<>();
        int i = estado.indexOf(" ");//Obtengo el indice del espacio
        String nuevoEstado;
        switch(i)
        {       /*
        		Usar los m�todos: replace, charAt
        		Otra idea es pasar el String a Matriz, hacer los cambios y luego pasarlo a String... xD     
         		*/
            case 0:
            	nuevoEstado = reemplaza(estado,0,1);
            	hijosGenerados.add(new Nodo(nuevoEstado).getEstado());
            	
            	nuevoEstado = reemplaza(estado,0,3);
            	hijosGenerados.add(new Nodo(nuevoEstado).getEstado());
                break;
                
            case 1:
            	nuevoEstado = reemplaza(estado,1,0);
            	hijosGenerados.add(new Nodo(nuevoEstado).getEstado());
            	
            	nuevoEstado = reemplaza(estado,1,2);
            	hijosGenerados.add(new Nodo(nuevoEstado).getEstado());
            	
            	nuevoEstado = reemplaza(estado,1,4);
            	hijosGenerados.add(new Nodo(nuevoEstado).getEstado());
                break;
            
            case 2:
            	nuevoEstado = reemplaza(estado,2,1);
            	hijosGenerados.add(new Nodo(nuevoEstado).getEstado());
            	
            	nuevoEstado = reemplaza(estado,2,5);
            	hijosGenerados.add(new Nodo(nuevoEstado).getEstado());
                break;
            
            case 3:
            	nuevoEstado = reemplaza(estado,3,0);
            	hijosGenerados.add(new Nodo(nuevoEstado).getEstado());
            	
            	nuevoEstado = reemplaza(estado,3,4);
            	hijosGenerados.add(new Nodo(nuevoEstado).getEstado());
                
            	nuevoEstado = reemplaza(estado,3,6);
            	hijosGenerados.add(new Nodo(nuevoEstado).getEstado());
                break;
            	
            case 4:
            	nuevoEstado = reemplaza(estado,4,1);
            	hijosGenerados.add(new Nodo(nuevoEstado).getEstado());
            	
            	nuevoEstado = reemplaza(estado,4,3);
            	hijosGenerados.add(new Nodo(nuevoEstado).getEstado());
                
            	nuevoEstado = reemplaza(estado,4,5);
            	hijosGenerados.add(new Nodo(nuevoEstado).getEstado());
            	
            	nuevoEstado = reemplaza(estado,4,7);
            	hijosGenerados.add(new Nodo(nuevoEstado).getEstado());
                break;
                
            case 5:
            	nuevoEstado = reemplaza(estado,5,2);
            	hijosGenerados.add(new Nodo(nuevoEstado).getEstado());
            	
            	nuevoEstado = reemplaza(estado,5,4);
            	hijosGenerados.add(new Nodo(nuevoEstado).getEstado());
                
            	nuevoEstado = reemplaza(estado,5,8);
            	hijosGenerados.add(new Nodo(nuevoEstado).getEstado());
            	break;
            
            case 6:
            	nuevoEstado = reemplaza(estado,6,3);
            	hijosGenerados.add(new Nodo(nuevoEstado).getEstado());
            	
            	nuevoEstado = reemplaza(estado,6,7);
            	hijosGenerados.add(new Nodo(nuevoEstado).getEstado());
                break;
           
            case 7:
            	nuevoEstado = reemplaza(estado,7,6);
            	hijosGenerados.add(new Nodo(nuevoEstado).getEstado());
            	
            	nuevoEstado = reemplaza(estado,7,4);
            	hijosGenerados.add(new Nodo(nuevoEstado).getEstado());
                
            	nuevoEstado = reemplaza(estado,7,8);
            	hijosGenerados.add(new Nodo(nuevoEstado).getEstado());
                break;
                
            case 8:
            	nuevoEstado = reemplaza(estado,8,5);
            	hijosGenerados.add(new Nodo(nuevoEstado).getEstado());
            	
            	nuevoEstado = reemplaza(estado,8,7);
            	hijosGenerados.add(new Nodo(nuevoEstado).getEstado());
                break;
               
        }
        
         
        return hijosGenerados;
    }
    private String reemplaza(String estado,int posicionIni, int posicionFin) {
    	Vector<Character> caracteres= new Vector<Character>();
    	char elemento;
    	String nuevoEstado = "";
    			//crea el vector con elementos por separado
    	for(int i = 0; i<estado.length(); i++) {
    		caracteres.addElement(estado.charAt(i));
    	}
    			//almacena el elemento a mover
    	elemento=(char) caracteres.get(posicionFin);
    			//intercambia los elementos 
    	caracteres.set(posicionFin,' ');
    	caracteres.set(posicionIni,elemento);
    			//transforma el vector en un string
    	for(int i=0; i<estado.length();i++) {
    		nuevoEstado=nuevoEstado+caracteres.elementAt(i);
    	}	
    	return nuevoEstado;
    }

	public int getProfundidad() {
		return profundidad;
	}

	public void setProfundidad(int profundidad) {
		this.profundidad = profundidad;
	}
     
}