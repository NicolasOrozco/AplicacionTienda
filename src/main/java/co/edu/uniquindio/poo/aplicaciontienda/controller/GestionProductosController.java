package co.edu.uniquindio.poo.aplicaciontienda.controller;

import co.edu.uniquindio.poo.aplicaciontienda.model.ProductoRecord;
import co.edu.uniquindio.poo.aplicaciontienda.model.*;

import java.util.LinkedList;

public class GestionProductosController {

    Tienda tienda;

    public GestionProductosController(Tienda tienda){
        this.tienda = tienda;
    }

    public void agregarProducto(ProductoRecord producto){
        tienda.getProductos().add(producto);
    }

    public LinkedList<ProductoRecord> obtenerProductos(){
        return tienda.getProductos();
    }

    public void eliminarProducto(String nombre){tienda.eliminarProducto(nombre);}
}
