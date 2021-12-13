module com.example.zavod {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires org.testng;
    requires junit;


    opens com.example.zavod to javafx.fxml;
    exports com.example.zavod;
}