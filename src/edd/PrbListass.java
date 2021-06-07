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
public class PrbListass
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Listas obj = new Listas();
        
        Nodo n1 = new Nodo("A");  //A
        Nodo n2 = new Nodo("B");  //B
        Nodo n3 = new Nodo("C");  //C
       // Nodo n4 = new Nodo(5);
        
       //System.out.println(obj.r.getAnt());
       //obj.r.setSig(null);
//       Nodo aux = obj.r;
//       //obj.r= aux;
//        System.out.println("aux  ="+ aux);
//        System.out.println("r  ="+ obj.r);
//        System.out.println("******************");
        obj.insertaLista(n1);
        obj.insertaLista(n2);
        obj.insertaLista(n3);
       // obj.insertaLista(n4);
        
        
       obj.recorrido();
        
       Nodo ne =obj.eliminaLista("G");
       if(ne !=null)
       {
           System.out.println("NODO ELIMINADO = " +ne.getD());
       }
//       aux = obj.r.getSig().getSig();
//        System.out.println("aux apunta =  "+ aux);
//        
//        char car = (char) obj.r.getSig().getSig().getD();
//        System.out.println("car = "+ car );
//       
//       // aux = obj.r.getSig().getSig().getSig().getSig();
//       aux = obj.r.getSig();
//       System.out.println("aux apunta =  "+ aux);
//        System.out.println("dato apuntado por aux = " + (char)aux.getD());
//        Nodo aux2 = null; //Nodo aux2 = obj.r.getSig().getSig().getSig();
//       
//        //aux2 = obj.r.getSig().getSig();
//        aux2 = aux.getSig();
//         System.out.println("AUX2 = "+aux2);
//         
//         obj.r.setSig(aux.getSig());//obj.r.setSig(aux2);//obj.r.setSig(obj.r.getSig().getSig());
//         System.out.println("R de siguiente apunta = "+ obj.r.getSig());
         obj.recorrido();
//        System.out.println(obj.r.getSig().getSig().getD());
//        System.out.println("sigiente de R = "+obj.r.getSig().getD());
//        aux = obj.r.getSig();
//        System.out.println("aux = " +aux.getD());
        
//        Nodo ne=obj.eliminaLista(4);
//        if(ne != null)
//        {
//            System.out.println("Dato eliminado = "+ ne.getD());
//        }
//        
//        obj.recorrido();
    
    }
    
}
