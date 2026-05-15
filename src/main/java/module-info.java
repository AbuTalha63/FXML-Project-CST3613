module edu.citytech.cst3613 {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.citytech.cst3613 to javafx.fxml;
    exports edu.citytech.cst3613;
}
