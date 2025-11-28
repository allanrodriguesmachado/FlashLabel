package br.com.manager.pdv.controller.product;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RegisterController {

    @FXML
    private Button closeModal;

    @FXML
    public void initialize() {}

    @FXML
    public void handleCloseModal() {
        Stage closeModalDash = (Stage) closeModal.getScene().getWindow();
        closeModalDash.close();
    }
}
