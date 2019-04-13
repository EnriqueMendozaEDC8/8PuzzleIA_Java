package pkg8puzzle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import pkg8puzzle.Nodo;
 
/**
 *
 * @author Mario R�os
 */
public class ArbolBusqueda {
     
    Nodo raiz;
    String objetivo;
     
    public ArbolBusqueda(Nodo nodo, String objetivo)
    {
        this.raiz = nodo;
        this.objetivo = objetivo;
    }
    public void setRaiz (String nuevaRaiz ,String estadoFinal){
        this.raiz = new Nodo(nuevaRaiz);
    }
    //Busqueda por Anchura
    public String busquedaPorAnchura()
    {
        pkg8puzzle.Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList();
        Queue<Nodo> estadosPorVisitar = new LinkedList();
        while(!nodoActual.getEstado().equals(objetivo))
        {
            System.out.println("Se esta buscando"+nodoActual.getEstado());
        	estadosVisitados.add(nodoActual.getEstado());
            //Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos();  //<-- Cada Equipo tiene que ingeniarselas para crear este metodo!
            for (String hijo : hijos) {
                if(!estadosVisitados.contains(hijo))
                {
                    //System.out.println("---Metiendo nuevo Nodo");
                    //Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                }
            }
            nodoActual = estadosPorVisitar.poll();  
        }
        String regreso = ImprimirSecuencia(nodoActual);
        /*System.out.println("YA SE ENCONTRO EL NODO OBJETIVO");
        System.out.println(nodoActual.getEstado());*/
        return regreso;
    }
    
    public String busquedaPrimeroEnProfundidad(){
        pkg8puzzle.Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList<String>();
        Stack<Nodo> estadosPorVisitar = new Stack<Nodo>();
        while(!nodoActual.getEstado().equals(objetivo))
        {
            System.out.println("Se esta buscando"+nodoActual.getEstado());
        	estadosVisitados.add(nodoActual.getEstado());
            //Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos();  //<-- Cada Equipo tiene que ingeniarselas para crear este metodo!
            for (String hijo : hijos) {
                if(!estadosVisitados.contains(hijo))
                {
                    //System.out.println("---Metiendo nuevo Nodo");
                    //Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                }
            }
            nodoActual = estadosPorVisitar.pop();  
        }
        String regreso = ImprimirSecuencia(nodoActual);
        /*System.out.println("YA SE ENCONTRO EL NODO OBJETIVO");
        System.out.println(nodoActual.getEstado());*/
        return regreso;
    }
    
    public String busquedaProfundidadIterativa(int profundidad) {
    	
        Nodo nodoActual = raiz;
        nodoActual.setProfundidad(0);
        Collection<String> estadosVisitados = new ArrayList<String>();
        Stack<Nodo> estadosPorVisitar = new Stack<Nodo>();
        while(!nodoActual.getEstado().equals(objetivo)){
            while(!nodoActual.getEstado().equals(objetivo) && nodoActual.getProfundidad()<=profundidad)
            {
                System.out.println("Se esta buscando"+nodoActual.getEstado());
                estadosVisitados.add(nodoActual.getEstado());
                //Generar a los Nodos Hijos
                Collection<String> hijos = nodoActual.generaHijos();  //<-- Cada Equipo tiene que ingeniarselas para crear este metodo!
                for (String hijo : hijos) {
                    if(!estadosVisitados.contains(hijo))
                    {
                        //System.out.println("---Metiendo nuevo Nodo");
                        //Crear nuevo Nodo.
                        Nodo nHijo = new Nodo(hijo);
                        nHijo.setPadre(nodoActual);
                        nHijo.setProfundidad(nodoActual.getProfundidad() +1 );
                        estadosPorVisitar.add(nHijo);
                    }
                }
                nodoActual = estadosPorVisitar.pop();  
            }
            if(nodoActual.getEstado().equals(objetivo)) {
                String regreso = ImprimirSecuencia(nodoActual);
                /*System.out.println("YA SE ENCONTRO EL NODO OBJETIVO");
                System.out.println(nodoActual.getEstado());*/
                return regreso;
            }
            profundidad++;
            System.out.println("Ya dio la vuelta");
        }
    	return "No se encontro nada";
    }
    
    public String ImprimirSecuencia(Nodo encontrado ){
        String impresion = null;
        if(encontrado.getPadre() != null){
            impresion = encontrado.getEstado();
        }
        Nodo auxiliar = encontrado.getPadre();
        while(auxiliar.getPadre()!= null){
            impresion = impresion+"\n"+auxiliar.getEstado();
            auxiliar = auxiliar.getPadre();
        }
        return impresion;
    }
}