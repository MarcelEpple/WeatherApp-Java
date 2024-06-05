module com.example.demo3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires org.apache.commons.io;
    requires org.json;


    opens com.example.demo3 to javafx.fxml;
    exports com.example.demo3;
}