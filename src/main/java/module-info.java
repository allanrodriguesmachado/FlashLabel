module br.com.bank {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;

    requires static lombok;

    opens br.com.bank to javafx.fxml;
    opens br.com.bank.controller.auth to javafx.fxml;
    opens br.com.bank.util to javafx.fxml;


    exports br.com.bank;
}