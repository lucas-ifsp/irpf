module br.edu.ifsp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens br.edu.ifsp.controller to javafx.fxml;
    opens br.edu.ifsp.view to javafx.fxml;

    exports br.edu.ifsp.controller;
    exports br.edu.ifsp.view;
}