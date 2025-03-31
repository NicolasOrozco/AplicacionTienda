package co.edu.uniquindio.poo.aplicaciontienda.model;

public record DireccionRecord(String ciudad, String codigoPostal, String calle) {
    /*To String  Direccion
    * */
    @Override
    public String toString() {
        return "ciudad='" + ciudad +
                ", codigoPostal='" + codigoPostal+
                ", calle='" + calle ;
    }
}
