/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd;

/**
 *
 * @author Mauro
 */
public class PrbListasCirculares
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ListasCircular obj = new ListasCircular();
        
        Nodo n1 = new Nodo("3");
        Nodo n2 = new Nodo("1");
        Nodo n3 = new Nodo("5");
        Nodo n4 = new Nodo("4");
        
        //obj.recorrido();
        obj.insertaLista(n1); //primero en la lista
        //obj.recorrido();
        obj.insertaLista(n2); //antes del primero
        //obj.recorrido();
        obj.insertaLista(n3); //al final de la lista
        //obj.recorrido();
        obj.insertaLista(n4); //en medio de la lista
        obj.recorrido();
        Nodo ne =obj.eliminaLista("2");
       if(ne !=null)
       {
           System.out.println("NODO ELIMINADO = " +ne.getD());
       }
         obj.recorrido();
    }
    
}
