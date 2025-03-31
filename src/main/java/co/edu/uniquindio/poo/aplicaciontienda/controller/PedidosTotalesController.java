package co.edu.uniquindio.poo.aplicaciontienda.controller;

import co.edu.uniquindio.poo.aplicaciontienda.model.PedidoDTO;
import co.edu.uniquindio.poo.aplicaciontienda.model.Tienda;

public class PedidosTotalesController {
    Tienda tienda;
    public PedidosTotalesController(Tienda tienda){ this.tienda = tienda;}
    public PedidoDTO buscarPedido(String id){
       return tienda.buscarPedido(id);
    }
    public void editarPedido( String id, PedidoDTO pedido){
        tienda.editarPedido(id, pedido);
    }
    public void agregarPedido(PedidoDTO pedidoDTO){ tienda.agregarPedido(pedidoDTO);}
    public void eliminarPedido(String id){ tienda.eliminarPedido(id);}
}
