/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edd;

/**
 *
 * @author Mauro
 */
public class ListaDobleCircular
{

    Nodo r;

    public ListaDobleCircular()
    {
        r = null;
    }

    public void insertaLista(Nodo d)
    {
        if (d != null) //verifica si hay algo a insertar
        {
            if (r == null) //inserta por primera vez
            {
                r = d;
                r.setSig(d); //r.setSig(r);
                r.setAnt(d); //r.setAnt(r);
            } else
            {
                if (r.getD().compareTo(d.getD()) < 0 || r.getSig().getD().compareTo(d.getD()) > 0)//inserta al final o inserta antes del primero de la lista
                {
                    d.setSig(r.getSig());
                    d.setAnt(r);
                    r.getSig().setAnt(d);
                    r.setSig(d);
                    if (r.getD().compareTo(d.getD()) < 0)
                    {
                        r=d;
                    }
                    
                } else
                {
                    Nodo aux = r.getSig(); //en el primer elemento de la lista
                    boolean b = false;
                    while (!b) //recorrer la lista
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
            if (r.getD().compareTo(dato) < 0 || r.getSig().getD().compareTo(dato) > 0) //cuando el dato a eliminar es mayor que el ultimo elemento de la lista o es menor al primer elemento de la lista
            {
                System.out.println("Dato no encontrado desde el inicio de la lista");
            } else
            {
                if (r.getSig().getD().equals(dato)) //elimino el primero de la lista
                {
                    nodoEliminado=r.getSig();
                    r.setSig(nodoEliminado.getSig());
                    r.getSig().setAnt(r);
                    if(r == nodoEliminado)
                    {
                        r=null;
                    }
                    nodoEliminado.setSig(null);
                    nodoEliminado.setAnt(null);
                } else
                {
                    aux = r.getSig(); //el primero de la lista
                    boolean b = false;
                    while (aux != r && !b)//elimino en medio o al final
                    {
                        if (aux.getSig().getD().equals(dato))
                        {
                            nodoEliminado = aux.getSig();
                            aux.setSig(nodoEliminado.getSig());
                            aux.getSig().setAnt(aux);
                            
                            if(nodoEliminado==r)
                            {
                                r=aux;
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
        if(r !=null)
        {
            Nodo aux =r.getSig();
            do
            {
                System.out.println(aux.getD());
                aux =aux.getSig();
            } while(aux != r.getSig());
        }else
        {
            System.out.println("no hay datos en la lista");
        }
    }
    
    public void recorridoInverso()
    {
       
        if(r != null)
        {
            Nodo aux = r;
            do
            {
                System.out.println(aux.getD());
                aux =aux.getAnt();
            }while(aux !=r);
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
