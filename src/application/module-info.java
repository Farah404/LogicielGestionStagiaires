module ISIKA_CDA17_Projet1 {
    requires javafx.base;
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;

	
	opens application to javafx.base, javafx.controls, javafx.graphics, javafx.fxml;
}