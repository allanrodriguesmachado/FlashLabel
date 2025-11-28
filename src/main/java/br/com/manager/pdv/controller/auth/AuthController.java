package br.com.manager.pdv.controller.auth;

import java.io.IOException;

import br.com.manager.pdv.model.AuthModel;
import br.com.manager.pdv.util.*;
import br.com.manager.pdv.util.AlertUtil;
import br.com.manager.pdv.util.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AuthController {
    @FXML
    private TextField document;

    @FXML
    private TextField password;

    public void initialize() {
    }

    @FXML
    public void loginAction(ActionEvent event) throws IOException {
        String doc = document.getText();
        String pass = password.getText();

        AuthModel auth = new AuthModel();

        if (doc.isBlank() || pass.isBlank()) {
             AlertUtil.showAlert(Alert.AlertType.WARNING, "Usuario e senha invalido", "Preencha todos os campos");
             return;
        }

        boolean isAuthenticated = auth.authentication(document.getText(), password.getText());

        if (!isAuthenticated) {
            AlertUtil.showAlert(Alert.AlertType.ERROR, "Usuario e senha invalido", "Usuario e senha invalido");
            return;
        }

        Stage stageClose = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ViewLoader.loadNewWindow("/main-menu.fxml", "/style.css", "Bank App - Menu Principal", stageClose);
    }
}
