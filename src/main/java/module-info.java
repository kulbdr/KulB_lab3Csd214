module com.example.kulb_csd214lab3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.sql;
    requires org.testng;
    requires junit;

    opens com.example.kulb_csd214lab3 to javafx.fxml;
    exports com.example.kulb_csd214lab3;
}