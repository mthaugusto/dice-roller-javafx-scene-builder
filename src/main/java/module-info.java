module com.matheus.leite {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.matheus.leite to javafx.fxml;
    exports com.matheus.leite;
}
