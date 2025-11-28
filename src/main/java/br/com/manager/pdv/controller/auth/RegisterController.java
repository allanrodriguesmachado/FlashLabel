package br.com.manager.pdv.controller.auth;

import br.com.manager.pdv.service.UserService;
import br.com.manager.pdv.util.AlertUtil;
import br.com.manager.pdv.util.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class RegisterController {
    @FXML
    private TextField first_name;

    @FXML
    private TextField last_name;


    @FXML private Button btnNovoProduto;

    @FXML
    public void abrirModalCadastro() {
        try {
            Stage dashboardStage = (Stage) this.btnNovoProduto.getScene().getWindow();

            ViewLoader.loadNewWindowModal(
                    "/modal_produto.fxml",
                    "/sistema.css",
                    "Novo Produto",
                    dashboardStage
            );


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
