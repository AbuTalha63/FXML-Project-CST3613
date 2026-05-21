module edu.citytech.cst3613 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;
    requires com.jbbwebsolutions.http.utility;

    opens edu.citytech.cst3613 to javafx.fxml;
    opens edu.citytech.cst3613.service to com.jbbwebsolutions.http.utility;
    opens edu.citytech.cst3613.dto to com.jbbwebsolutions.http.utility, com.google.gson;

    exports edu.citytech.cst3613;
}
