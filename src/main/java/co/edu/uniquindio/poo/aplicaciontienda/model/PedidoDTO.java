package co.edu.uniquindio.poo.aplicaciontienda.model;

import java.util.LinkedList;

public class PedidoDTO {
    private ClienteDTO cliente;
    private LinkedList<ProductoRecord> productos;
    private String estado;

    public PedidoDTO(ClienteDTO cliente) {
        this.cliente = cliente;
        productos = new LinkedList<>();
        this.estado = "Pendiente";
    }

    //-------------Getters y Setters-------------//

    public ClienteDTO getCliente() { return cliente; }

    public LinkedList<ProductoRecord> getProductos() { return productos; }

    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }

    public void setCliente(ClienteDTO cliente) { this.cliente = cliente; }

}
