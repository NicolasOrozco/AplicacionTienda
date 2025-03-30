package co.edu.uniquindio.poo.aplicaciontienda.controller;

import co.edu.uniquindio.poo.aplicaciontienda.model.*;

public class HistorialPedidosController {
    Tienda tienda;
    public HistorialPedidosController(Tienda tienda) { this.tienda = tienda; }
    public void buscarPedido(String codigo) {
        tienda.buscarPedido(codigo);
    }
    public void agregarPedido(PedidoDTO pedido) {
        tienda.agregarPedido(pedido);
    }
    public void eliminarPedido(String codigo) {
        tienda.eliminarPedido(codigo);
    }

}
