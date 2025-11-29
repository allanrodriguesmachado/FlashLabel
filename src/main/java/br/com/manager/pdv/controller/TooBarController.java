package br.com.manager.pdv.controller;

import br.com.manager.pdv.util.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class TooBarController {

    @FXML private Button newProduct;

    @FXML private Button newCategory;

    @FXML
    public void openModalCategory() throws IOException {
        ViewLoader.loadNewWindowModal("/product/category.fxml", "/dashboard/sistema.css", "Categoria", (Stage) this.newProduct.getScene().getWindow());
    }

    @FXML
    public void openModalProduct() {
        try {
            Stage dashboardStage = (Stage) this.newProduct.getScene().getWindow();

            ViewLoader.loadNewWindowModal(
                    "/product/openModal.fxml",
                    "/dashboard/sistema.css",
                    "Novo Produto",
                    dashboardStage
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
