/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edd;

/**
 *
 * @author Mauro
 */
public class Listas
{

    Nodo r;

    public Listas()
    {
        r = null;
    }

    public void insertaLista(Nodo n)
    {
        if (n != null) //verifica si hay algo a insertar
        {
            Nodo aux = r;
            if (aux == null) //inserta por primera vez
            {
                r = n;
            } else
            {
                if (aux.getD().compareTo(n.getD()) > 0)//inserta antes del primero de la lista
                {
                    n.setSig(aux);
                    r = n;
                } else
                {
                    boolean b = false;
                    while (aux.getSig() != null && !b) //recorrer la lista
                    {
                        if (aux.getSig().getD().compareTo(n.getD()) > 0) //inserta en medio de la lista
                        {
                            n.setSig(aux.getSig());
                            aux.setSig(n);
                            b = true;
                        }else
                        {
                            aux=aux.getSig();
                        }
                    }
                    if (!b)//inserta al final de la lista
                    {
                        aux.setSig(n);
                    }
                }
            }
        }
    }

    public Nodo eliminaLista(String dato)
    {
        Nodo aux, nodoEliminar = null;
        if (r == null) // cuando no hay datos en la lista
        {
            System.out.println("no hay elementos en la lista");
        } else
        {
            if (r.getD().compareTo(dato) > 0) //cuando el dato a eliminar es menor al primer elemento de la lista
            {
                System.out.println("Dato no encontrado desde el inicio de la lista");
            } else
            {
                aux = r;
                if (r.getD().equals(dato)) //elimino el primero de la lista
                {
                    nodoEliminar = r; // nodoEliminar =aux;
                    r=aux.getSig();//r= r.getSig();
                    nodoEliminar.setSig(null);
                } else
                {
                    boolean b = false;
                    while (aux.getSig() != null && !b) //elimino en medio o al final
                    {
                        if (aux.getSig().getD().equals(dato))
                        {
                            nodoEliminar = aux.getSig();
                            aux.setSig(nodoEliminar.getSig());//aux.setSig(aux.getSig().getSeig())
                            nodoEliminar.setSig(null);
                            b = true;
                        }else
                        {
                            if(aux.getSig().getD().compareTo(dato) > 0) //corta el siclo porque no encontrará el dato jámas
                            {
                                break;
                            }else
                            {
                                aux=aux.getSig();
                            }
                        }
                    }
                    if (!b)
                    {
                        System.out.println("dato no encontrado en la lista");
                    }
                }
            }
        }
        return nodoEliminar;
    }
    
    public void recorrido()
    {
        Nodo aux = r;
        while (aux !=null)
        {
            System.out.println(aux);
            System.out.println(aux.getD());
            aux = aux.getSig();                 
        }
    }
    
    public Nodo busca(String d)
    {
        Nodo aux = r;
        while (aux !=null)
        {
            if(aux.getD().equals(d))
            {
                return aux; //encontró el dato
            }    
            aux = aux.getSig();                 
        }
        System.out.println("dato no encontrado..");
        return null; // no encontró el dato
    }
}
