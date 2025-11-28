module br.com.manager.pdv {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;

    requires static lombok;

    opens br.com.manager.pdv to javafx.fxml;
    opens br.com.manager.pdv.controller.auth to javafx.fxml;
    opens br.com.manager.pdv.util to javafx.fxml;


    exports br.com.manager.pdv;
}