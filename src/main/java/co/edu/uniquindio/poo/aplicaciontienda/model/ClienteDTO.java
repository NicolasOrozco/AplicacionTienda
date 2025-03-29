package co.edu.uniquindio.poo.aplicaciontienda.model;

public class ClienteDTO {
    private String nombre;
    private DireccionRecord direccion;

    /**
     * Método Constructor de la clase
     * @param nombre del cliente
     * @param direccion
     */
    public ClienteDTO(String nombre, DireccionRecord direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    //-------------Getters y Setters-------------/

    public String getNombre() {
        return nombre;
    }

    public DireccionRecord getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(DireccionRecord direccion) {
        this.direccion = direccion;
    }

}
