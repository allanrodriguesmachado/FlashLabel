module br.com.bank {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.com.bank to javafx.fxml;
    opens br.com.bank.controller to javafx.fxml;
    opens br.com.bank.util to javafx.fxml;

    exports br.com.bank;
}