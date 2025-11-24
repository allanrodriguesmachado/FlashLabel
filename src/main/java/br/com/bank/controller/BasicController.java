package br.com.bank.controller;

import java.io.IOException;

import br.com.bank.util.AlertUtil;
import br.com.bank.util.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BasicController {
    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtPassword;

    public void initialize() {
    }

    @FXML
    public void handleButtonAction(ActionEvent event) {
        String cpf = txtCpf.getText();
        String passw = txtPassword.getText();

        if (txtCpf.getText().isEmpty() || txtPassword.getText().isEmpty()) {
            txtCpf.focusedProperty();
            txtCpf.clear();
            AlertUtil.showAlert(Alert.AlertType.WARNING, "Erro de login", "Usuario e senha invalido");

        }

        boolean loginSuccess = cpf.equals("admin") && passw.equals("admin123");

        if (loginSuccess) {
            try {
                ViewLoader.loadNewWindow("/main-menu.fxml", "/style.css", "Bank App - Menu Principal");
                Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                currentStage.close();
            } catch (IOException exception) {
                AlertUtil.showAlert(Alert.AlertType.ERROR, "ERROR", "passw");
            }
        }
    }
}
