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
public class PrbListaDoble
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ListaDoble obj = new ListaDoble();
        
        Nodo n1 = new Nodo("A");
        Nodo n2 = new Nodo("B");
        Nodo n3 = new Nodo("C");
        Nodo n4 = new Nodo("D");
        Nodo n5 = new Nodo("9");
        
        obj.insertaLista(n1);
        obj.insertaLista(n2);
        obj.insertaLista(n3);
        obj.insertaLista(n4);
        obj.insertaLista(n5);
        
        obj.recorrido();
        System.out.println("***************************************");
        obj.recorridoInverso();
        
        Nodo ne = obj.eliminaLista("5");
        if(ne != null)
        {
            System.out.println("Dato eliminado = " + ne.getD());
        }
        
        obj.recorrido();
        System.out.println("***************************************");
        obj.recorridoInverso();
        
        
        
    }
    
}
