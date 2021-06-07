/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edd;

/**
 *
 * @author Mauro
 */
public class ListasCircular
{

    Nodo r;

    public ListasCircular()
    {
        r = null;
    }

    public void insertaLista(Nodo n)
    {
        if (n != null) //verifica si hay algo a insertar
        {
            
            if (r == null) //inserta por primera vez
            {
                r = n;
                r.setSig(r);
            } else
            {
                if (r.getD().compareTo(n.getD()) < 0 || r.getSig().getD().compareTo(n.getD()) > 0)
                    //inserta antes del primero de la lista
                    //o al final de la listas
                {
                    n.setSig(r.getSig());
                    r.setSig(n);
                    if(r.getD().compareTo(n.getD()) < 0) //cuando se inserta al final se mueve r
                    {
                        r = n;
                    }
                } else
                {
                    Nodo aux = r.getSig(); //lleva a aux al primer elemento de la lista
                    boolean b = false;
                    while (!b) //recorrer la lista
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
            if (r.getD().compareTo(dato) < 0 || r.getSig().getD().compareTo(dato) > 0) //cuando el dato a eliminar es mayor al ultimo elemento o menor al primer elemento de la lista
            {
                System.out.println("Dato no encontrado desde el inicio de la lista");
            } else
            {
                aux = r.getSig();
                if (aux.getD().equals(dato)) //elimino el primero de la lista
                {
                    nodoEliminar = aux; // nodoEliminar =r.getSig();
                    r.setSig(aux.getSig());//r.setSig(r.getSig().getSig()); r.setSig(nodoEliminar.getSig();
                    nodoEliminar.setSig(null);
                    if(r == nodoEliminar)
                    {
                        r=null;
                    }
                } else
                {
                    boolean b = false;
                    while (aux != r && !b) //elimino en medio o al final
                    {
                        if (aux.getSig().getD().equals(dato))
                        {
                            nodoEliminar = aux.getSig();
                            aux.setSig(nodoEliminar.getSig());//aux.setSig(aux.getSig().getSeig())
                            nodoEliminar.setSig(null);
                            b = true;
                            if(nodoEliminar == r)
                            {
                                r=aux;
                            }
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
        System.out.println("***************************************");
        Nodo aux = r;
        if (aux !=null)
        {
            aux = r.getSig();
            do
            {
                System.out.println(aux.getD());
                aux = aux.getSig();  
            } while (aux != r.getSig());              
        }else
        {
            System.out.println("no hay datos en la lista");
        }
    }
    
    public Nodo busca(String d)
    {
        System.out.println("***************************************");
        Nodo aux = r;
        if (aux !=null)
        {
            
            aux = r.getSig();
            if(d.compareTo(aux.getD())< 0  || d.compareTo(r.getD())>0)
            {
                System.out.println("dato no encontrado en la lista");
                return null;
            }else
            {
                do
                {
                    if(aux.getD().equals(d))
                    {
                        return aux;
                    }
                    aux = aux.getSig();  
                } while (aux != r.getSig());              
                System.out.println("dato no encontrado en la lista");
                return null;
            }
        }else
        {
            System.out.println("no hay datos en la lista");
            return null;
        }
    }
    
}
