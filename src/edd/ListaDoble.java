/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edd;

/**
 *
 * @author Mauro
 */
public class ListaDoble
{

    Nodo r;

    public ListaDoble()
    {
        r = null;
    }

    public void insertaLista(Nodo d)
    {
        if (d != null) //verifica si hay algo a insertar
        {
            Nodo aux = r;
            if (aux == null) //inserta por primera vez
            {
                r = d;
            } else
            {
                if (aux.getD().compareTo(d.getD()) > 0)//inserta antes del primero de la lista
                {
                    d.setSig(aux);
                    aux.setAnt(d);
                    r=d;
                } else
                {
                    boolean b = false;
                    while (aux.getSig() != null && !b) //recorrer la lista
                    {
                        if (aux.getSig().getD().compareTo(d.getD()) > 0) //inserta en medio de la lista
                        {
                            d.setSig(aux.getSig());
                            d.setAnt(aux);
                            //aux.getSig().setAnt(d);
                            aux.setSig(d);
                            aux.getSig().getSig().setAnt(d);// d.getSig().setAnt(d);
                            b =true;
                        }else
                        {
                            aux=aux.getSig();
                        }
                        
                    }
                    if (!b)//inserta al final de la lista
                    {
                        aux.setSig(d);
                        d.setAnt(aux);
                    }
                }
            }
        }
    }

    public Nodo eliminaLista(String dato)
    {
        Nodo aux, nodoEliminado = null;
        if (r == null)
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
                    nodoEliminado=r;
                    r=aux.getSig();
                    if(r != null)
                    {
                        r.setAnt(null);
                    }
                    nodoEliminado.setSig(null);
                } else
                {
                    boolean b = false;
                    while (aux.getSig() != null && !b)//elimino en medio o al final
                    {
                        if (aux.getSig().getD().equals(dato))
                        {
                            nodoEliminado = aux.getSig();
                            aux.setSig(nodoEliminado.getSig());
                            if(nodoEliminado.getSig() != null)
                            {
                                nodoEliminado.getSig().setAnt(aux);
                            }
                            nodoEliminado.setSig(null);
                            nodoEliminado.setAnt(null);
                            b = true;
                        }else
                        {
                            if(aux.getSig().getD().compareTo(dato) > 0)
                            {
                                break;
                            }else
                            {
                                aux= aux.getSig();
                            }
                        }
                    }
                    if (!b)
                    {
                        System.out.println("dato no encontrado en la  lista");
                    }
                }
            }

        }
        return nodoEliminado;
    }
    
    public void recorrido()
    {
        Nodo aux =r;
        while(aux != null)
        {
            System.out.println(aux.getD());
            aux =aux.getSig();
        }
    }
    
    public void recorridoInverso()
    {
        Nodo aux =r;
        if(aux != null)
        {
            while(aux.getSig() != null)
            {
                aux=aux.getSig();
            }
            while(aux !=null)
            {
                System.out.println(aux.getD());
                aux =aux.getAnt();
            }
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
