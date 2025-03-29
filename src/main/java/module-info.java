module co.edu.uniquindio.poo.aplicaciontienda {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.aplicaciontienda to javafx.fxml;
    exports co.edu.uniquindio.poo.aplicaciontienda;
}