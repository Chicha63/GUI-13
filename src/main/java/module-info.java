module com.gui13.gui13 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.gui13.gui13 to javafx.fxml;
    exports com.gui13.gui13;
}