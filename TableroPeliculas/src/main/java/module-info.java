module com.mycompany.tableropeliculas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.tableropeliculas to javafx.fxml;
    exports com.mycompany.tableropeliculas;
}
