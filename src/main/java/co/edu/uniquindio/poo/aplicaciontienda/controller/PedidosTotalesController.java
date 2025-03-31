package co.edu.uniquindio.poo.aplicaciontienda.controller;

import co.edu.uniquindio.poo.aplicaciontienda.model.PedidoDTO;
import co.edu.uniquindio.poo.aplicaciontienda.model.Tienda;

public class PedidosTotalesController {
    Tienda tienda;
    public PedidosTotalesController(Tienda tienda){ this.tienda = tienda;}
    public void buscarPedido(String id){
        tienda.buscarPedido(id);
    }
    public void agregarPedido(PedidoDTO pedidoDTO){ tienda.agregarPedido(pedidoDTO);}
    public void eliminarPedido(String id){ tienda.eliminarPedido(id);}
}
