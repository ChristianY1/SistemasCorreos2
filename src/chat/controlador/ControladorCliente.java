/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.controlador;

import chat.modelo.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cy190
 */
public class ControladorCliente {
    public Cliente cliente;
    public List<Cliente> listaClientes;
    
    public ControladorCliente(){
        listaClientes = new ArrayList<>();
        
    }

    public ControladorCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void addCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }
    
  
    
    
    
    
}
