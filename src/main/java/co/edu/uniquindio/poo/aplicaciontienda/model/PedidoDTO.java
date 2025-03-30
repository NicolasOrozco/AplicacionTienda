package co.edu.uniquindio.poo.aplicaciontienda.model;

import java.util.LinkedList;

public class PedidoDTO {
    private final String id;
    private ClienteDTO cliente;
    private final LinkedList<ProductoRecord> productos;
    private DireccionRecord direccion;
    private Estado estado;

    public PedidoDTO(String id, ClienteDTO cliente, DireccionRecord direccion) {
        this.id = id;
        this.cliente = cliente;
        productos = new LinkedList<>();
        this.direccion = direccion;
        this.estado = Estado.PENDIENTE;
    }

    //-------------Getters y Setters-------------//

    public String getId() { return id; }

    public ClienteDTO getCliente() { return cliente; }

    public LinkedList<ProductoRecord> getProductos() { return productos; }

    public DireccionRecord getDireccion() { return direccion; }

    public Estado getEstado() { return estado; }

    public void setEstado(Estado estado) { this.estado = estado; }

    public void setDireccion(DireccionRecord direccion) { this.direccion = direccion; }

    public void setCliente(ClienteDTO cliente) { this.cliente = cliente; }

}
