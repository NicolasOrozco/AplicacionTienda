package co.edu.uniquindio.poo.aplicaciontienda.controller;

import co.edu.uniquindio.poo.aplicaciontienda.model.*;

public class GestionPedidosController {
    Tienda tienda;

    public GestionPedidosController(Tienda tienda) {
        this.tienda = tienda;
    }

    public void agregarPedido(PedidoDTO pedidoDTO){
        tienda.agregarPedido(pedidoDTO);
    }
}
