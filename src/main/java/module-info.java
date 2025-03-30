module co.edu.uniquindio.poo.aplicaciontienda {
    requires javafx.controls;
    requires javafx.fxml;

    // Abre los paquetes que contienen FXML y controladores
    opens co.edu.uniquindio.poo.aplicaciontienda to javafx.fxml;
    opens views to javafx.fxml;
    opens styles to javafx.fxml;

    // Exporta el módulo principal si otras partes del código lo necesitan
    exports co.edu.uniquindio.poo.aplicaciontienda.model;
    exports co.edu.uniquindio.poo.aplicaciontienda.app;
    exports co.edu.uniquindio.poo.aplicaciontienda.viewController;
    exports co.edu.uniquindio.poo.aplicaciontienda.controller;

}