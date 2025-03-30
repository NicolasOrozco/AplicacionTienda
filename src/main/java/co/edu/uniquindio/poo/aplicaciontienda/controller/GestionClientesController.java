package co.edu.uniquindio.poo.aplicaciontienda.controller;

import co.edu.uniquindio.poo.aplicaciontienda.model.*;

public class GestionClientesController {
    Tienda tienda;

    public GestionClientesController(Tienda tienda) {this.tienda = tienda;}

    public ClienteDTO buscarCliente(String nombre){
        return tienda.buscarCliente(nombre);
    }
    public void agregarCliente(ClienteDTO cliente){
        tienda.agregarCliente(cliente);
    }
    public void actualizar(String id,ClienteDTO cliente){
        tienda.actualizarCliente(id, cliente);
    }
    public void eliminarCliente(String id){
        tienda.eliminarCliente(id);
    }
}
