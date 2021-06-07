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
public class PrbListaDobleCircular
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ListaDobleCircular obj = new ListaDobleCircular();
        
       // Nodo n1 = new Nodo(8);
        Nodo n2 = new Nodo("5");
        Nodo n3 = new Nodo("6");
        Nodo n4 = new Nodo("2");
       // Nodo n5 = new Nodo(9);
        
       // obj.insertaLista(n1);
        obj.insertaLista(n2);
        obj.insertaLista(n3);
        obj.insertaLista(n4);
       // obj.insertaLista(n5);
        
        obj.recorrido();
        System.out.println("***************************************");
        obj.recorridoInverso();
        
        Nodo ne = obj.eliminaLista("3");
        if(ne != null)
        {
            System.out.println("Dato eliminado = " + ne.getD());
        }
        
        obj.recorrido();
        System.out.println("***************************************");
        obj.recorridoInverso();
        
        
        
    }
    
}
