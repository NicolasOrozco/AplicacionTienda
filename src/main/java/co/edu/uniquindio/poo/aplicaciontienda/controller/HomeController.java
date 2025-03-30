package co.edu.uniquindio.poo.aplicaciontienda.controller;

import co.edu.uniquindio.poo.aplicaciontienda.model.*;

import java.util.LinkedList;

public class HomeController {

    Tienda tienda;

    public HomeController(Tienda tienda) {
        this.tienda = tienda;
    }

    public LinkedList<PedidoDTO> obtenerPedidosActivos(){
        return tienda.obtenerPedidosActivos();
    }

}
