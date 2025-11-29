package br.com.manager.pdv.controller.product;

import br.com.manager.pdv.service.CategoryService;
import br.com.manager.pdv.util.AlertUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CategoryController {
    @FXML
    private Button closeModal;

    @FXML
    private TextField newCategory;

    public void initialize() {
        if (newCategory != null) {
            newCategory.requestFocus();
        }
    }

    public void handleCloseModal() {
        var closeModalCategory = (Stage) closeModal.getScene().getWindow();
        closeModalCategory.close();
    }

    public void handleSaveAction() {
        String categoryName = newCategory.getText();

        if (categoryName == null || categoryName.isBlank()) {
            AlertUtil.showAlert(Alert.AlertType.ERROR, "Categoria inválida", "Preencha todos os campos");
            return;
        }
        handleCloseModal();

        CategoryService newService = new CategoryService();
        newService.create(categoryName);

        newCategory.clear();
        newCategory.requestFocus();

    }

    public void handleCleanInput() {
        newCategory.clear();
        newCategory.requestFocus();
    }
}
