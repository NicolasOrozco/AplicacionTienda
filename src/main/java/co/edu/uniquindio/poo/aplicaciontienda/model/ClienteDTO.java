package co.edu.uniquindio.poo.aplicaciontienda.model;

public class ClienteDTO {
    private String nombre;
    private String id;

    /**
     * Método Constructor de la clase
     * @param nombre del cliente
     * @param id del cliente
     */
    public ClienteDTO(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    //-------------Getters y Setters-------------//

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(String id) {
        this.id = id;
    }
}
