module LogicielGestionStagiaires {
    requires javafx.base;
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;

	
	opens application to javafx.base, javafx.controls, javafx.graphics, javafx.fxml;
}