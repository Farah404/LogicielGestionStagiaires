module LogicielGestionStagiaires {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires java.desktop;

    opens application to javafx.base, javafx.controls, javafx.graphics, javafx.fxml;
    opens application.controllers to javafx.base, javafx.controls, javafx.graphics, javafx.fxml;
    opens application.interfaces to javafx.base, javafx.controls, javafx.graphics, javafx.fxml;
}