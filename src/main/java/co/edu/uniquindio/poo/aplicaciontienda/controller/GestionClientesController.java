package co.edu.uniquindio.poo.aplicaciontienda.controller;

import co.edu.uniquindio.poo.aplicaciontienda.model.*;

public class GestionClientesController {
    Tienda tienda;

    public GestionClientesController(Tienda tienda) {this.tienda = tienda;}

    public ClienteDTO buscarCliente(String id){
        return tienda.buscarCliente(id);
    }
    public void agregarCliente(ClienteDTO cliente){
        tienda.agregarCliente(cliente);
    }
    public void actualizarCliente(String id,ClienteDTO cliente){
        tienda.actualizarCliente(id, cliente);
    }
    public void eliminarCliente(String id){
        tienda.eliminarCliente(id);
    }
}
