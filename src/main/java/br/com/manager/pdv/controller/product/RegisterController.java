package br.com.manager.pdv.controller.product;


import br.com.manager.pdv.util.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {
    @FXML
    private Button closeModal;

    @FXML
    public void handleCloseModal() {
        var closeModalDash = (Stage) closeModal.getScene().getWindow();
        closeModalDash.close();
    }
}
