package co.edu.uniquindio.poo.aplicaciontienda.model;

import java.util.LinkedList;

public class Tienda {

    public LinkedList<ClienteDTO> clientes;
    public LinkedList<ProductoRecord> productos;
    public LinkedList<PedidoDTO> pedidos;

    public Tienda(LinkedList<ClienteDTO> clientes, LinkedList<ProductoRecord> productos, LinkedList<PedidoDTO> pedidos) {
        clientes = new LinkedList<>(clientes);
        productos = new LinkedList<>(productos);
        pedidos = new LinkedList<>(pedidos);
    }

    //-------------CRUD CLIENTE-------------//

    /**
     * Busca un cliente en la lista de clientes
     * @param id id del cliente a buscar
     * @return cliente encontrado
     * @throws IllegalArgumentException si el id es nula o vacia
     */
    public ClienteDTO buscarCliente(String id) {
        if (id==null|| id.isEmpty()){
            throw new IllegalArgumentException("El id no puede ser vacio o nulo");
        }
        for (ClienteDTO clienteDTO : clientes) {
            if (clienteDTO.getId().equals(id)) {
                return clienteDTO;
            }
        }
        return null;
    }

    /**
     * Agrega un nuevo cliente a la lista de clientes si no está registrado previamente
     *
     * @param  clienteDTO Cliente a agregar
     * @throws IllegalArgumentException si el cliente es nulo
     */

    public void agregarCliente(ClienteDTO clienteDTO) {
        if (clienteDTO == null) {
            throw new IllegalArgumentException("No se ingresó el cliente que se desea agregar.");
        }

        if (buscarCliente(clienteDTO.getId()) != null) {
            System.out.println("El cliente ya se encuentra registrado.");
            return;
        }

        clientes.add(clienteDTO);
        System.out.println("Cliente agregado exitosamente.");
    }

    /**
     * Actualiza la información de un cliente existente en la tienda
     *
     * @param id         el identificador del cliente a actualizar
     * @param actualizado el objeto cliente con los datos actualizados
     * @throws IllegalArgumentException si los datos del cliente actualizado son nulos
     */

    public void actualizarCliente(String id, ClienteDTO actualizado) {
        if (actualizado == null) {
            throw new IllegalArgumentException("Los datos del Cliente actualizado no pueden ser nulos.");
        }

        ClienteDTO cliente = buscarCliente(id);
        if (cliente != null) {
            cliente.setId(actualizado.getId());
            cliente.setNombre(actualizado.getNombre());
            System.out.println("Cliente actualizado exitosamente.");
        } else {
            System.out.println("No existe un Cliente con el id ingresado.");
        }
    }

    /**
     * Elimina un Cliente de la lista de la tienda si existe
     *
     * @param id el identificador del Cliente a eliminar
     * @throws IllegalArgumentException si el ID es nulo
     */

    public void eliminarCliente(String id) {
        if (id == null) {
            throw new IllegalArgumentException("El id no puede ser nulo.");
        }

        ClienteDTO clienteDTO = buscarCliente(id);
        if (clienteDTO != null) {
            clientes.remove(clienteDTO);
            System.out.println("Cliente eliminado exitosamente.");
        } else {
            System.out.println("No existe un Cliente con el id ingresado.");
        }
    }

    //-------------CRUD PEDIDO-------------//

    public PedidoDTO buscarPedido(String id) {
        if (id == null) {
            throw new IllegalArgumentException("El id no puede ser nulo.");
        }

        for (PedidoDTO pedido : pedidos) {
            if (pedido.getId().equals(id)) {
                return pedido;
            }
        }

        return null;
    }

    /**
     * Agrega un nuevo pedido al historial de la tienda si no está registrado previamente
     *
     * @param pedido el pedido a agregar
     * @throws IllegalArgumentException si el pedido es nulo
     */

    public void agregarPedido(PedidoDTO pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("No se ingresó el pedido que se desea agregar.");
        }

        if (buscarPedido(pedido.getId()) != null) {
            System.out.println("Ya existe un pedido con ese Id, por favor, ingrese uno nuevo.");
            return;
        }

        pedidos.add(pedido);
        System.out.println("Pedido agregado exitosamente.");
    }

    /**
     * Elimina un pedido de la lista de la tienda si existe
     *
     * @param id el identificador del pedido a eliminar
     * @throws IllegalArgumentException si el ID es nulo
     */

    public void eliminarPedido(String id) {
        if (id == null) {
            throw new IllegalArgumentException("El id no puede ser nulo.");
        }

        PedidoDTO pedidoDTO = buscarPedido(id);
        if (pedidoDTO != null) {
            pedidos.remove(pedidoDTO);
            System.out.println("Pedido eliminado exitosamente.");
        } else {
            System.out.println("No existe un pedido con el id ingresado.");
        }
    }

    //-------------OTROS MÉTODOS-------------//

    public LinkedList<PedidoDTO> obtenerPedidosActivos() {
        LinkedList<PedidoDTO> pedidosActivos = new LinkedList<>();

        for (PedidoDTO pedido : pedidos) {
            if(pedido.getEstado() == Estado.PENDIENTE){
                pedidosActivos.add(pedido);
            }
        }

        return pedidosActivos;
    }

    //-------------GETTERS Y SETTERS-------------//


    public LinkedList<ClienteDTO> getClientes() {
        return clientes;
    }

    public void setClientes(LinkedList<ClienteDTO> clientes) {
        this.clientes = clientes;
    }

    public LinkedList<ProductoRecord> getProductos() {
        return productos;
    }

    public void setProductos(LinkedList<ProductoRecord> productos) {
        this.productos = productos;
    }

    public LinkedList<PedidoDTO> getPedidos() {
        return pedidos;
    }

    public void setPedidos(LinkedList<PedidoDTO> pedidos) {
        this.pedidos = pedidos;
    }
}
