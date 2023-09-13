module ec.edu.espol.mavenproject3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens ec.edu.espol.mavenproject3 to javafx.fxml;
    exports ec.edu.espol.mavenproject3;
}
