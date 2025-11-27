package br.com.bank.controller.auth;

import br.com.bank.service.UserService;
import br.com.bank.util.AlertUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;


public class RegisterController {
    @FXML
    private TextField first_name;

    @FXML
    private TextField last_name;

    private final UserService userService;

    public RegisterController() {
        this.userService = new UserService();
    }

    public void handleSaveAction() {
        String firstName = first_name.getText();
        String lastName = last_name.getText();

        try {
            userService.register(firstName, lastName);

            this.first_name.clear();
            this.last_name.clear();
            this.first_name.requestFocus();
        } catch (Exception e) {
            AlertUtil.showAlert(Alert.AlertType.ERROR, "Erro no cadastro", e.getMessage());
        }
    }
}
