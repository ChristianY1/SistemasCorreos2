/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.modelo;

import java.util.List;


public class Cliente {
    public String nombre;
    public int edad;
    public String usuario;
    public String correo;
    public List<Cliente> clientes;

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente() {
       
    }
    
    

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /*@Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", edad=" + edad + ", usuario=" + usuario + ", correo=" + correo + ", clientes=" + clientes + '}';
    }*/
    
    
    
    
}
