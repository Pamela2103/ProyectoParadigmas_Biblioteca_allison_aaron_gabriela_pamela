module com.mycompany.biblioteca {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
requires java.sql.rowset;
    
    requires java.logging;

    opens com.mycompany.biblioteca to javafx.fxml;
    exports com.mycompany.biblioteca;
    requires javafx.graphicsEmpty;
    requires mysql.connector.java;
}
