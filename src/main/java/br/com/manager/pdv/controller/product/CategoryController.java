package br.com.manager.pdv.controller.product;

import br.com.manager.pdv.model.entity.Category;
import br.com.manager.pdv.service.CategoryService;
import br.com.manager.pdv.util.AlertUtil;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.List;

public class CategoryController {
    @FXML
    private Button closeModal;

    @FXML
    private TextField newCategory;

    @FXML
    private TableView<Category> tableCategory;

    @FXML
    private TableColumn<Category, String> colName;

    @FXML
    private TableColumn<Category, Integer> colId;

    @FXML
    private TableColumn<Category, Void> colDelete;

    @FXML
    private TableColumn<Category, Void> colEdit;

    @FXML
    private final CategoryService categoryService = new CategoryService();

    private final ObservableList<Category> observableCategoryList = FXCollections.observableArrayList();

    private Category categoryInEdition = null;

    @FXML
    private Button btnAction;

    public void initialize() {
        handleListCategoriesAction();
        configList();
        if (newCategory != null) {
            newCategory.requestFocus();
        }

        handleDeleteAction();
        handleUpdateAction();
    }

    public void handleCloseModal() {
        var closeModalCategory = (Stage) closeModal.getScene().getWindow();
        closeModalCategory.close();
    }

    public void handleSaveAction() {
        String categoryName = newCategory.getText();

        if (categoryInEdition == null) {
            if (categoryName == null || categoryName.isBlank()) {
                AlertUtil.showAlert(Alert.AlertType.ERROR, "Categoria inválida", "Preencha todos os campos");
                return;
            }

            newCategory.clear();

            CategoryService newService = new CategoryService();
            newService.create(categoryName);

            handleListCategoriesAction();

            newCategory.requestFocus();
            return;
        }

        CategoryService newService = new CategoryService();
        newService.update(categoryInEdition.id(), categoryName);
        handleListCategoriesAction();

        resetForm();
    }

    private void resetForm() {
        this.categoryInEdition = null;
        newCategory.clear();

        btnAction.setText("ADICIONAR");
        btnAction.setStyle("");
    }

    private void handleListCategoriesAction() {
        observableCategoryList.clear();
        List<Category> categoriesFromDb = categoryService.list();
        observableCategoryList.addAll(categoriesFromDb);
    }

    private void handleUpdateAction() {
        Callback<TableColumn<Category, Void>, TableCell<Category, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Category, Void> call(final TableColumn<Category, Void> param) {
                return new TableCell<>() {
                    private final Button btn = new Button();

                    {
                        SVGPath svg = new SVGPath();
                        svg.setContent("M3 17.25V21h3.75L17.81 9.94l-3.75-3.75L3 17.25zM20.71 7.04c.39-.39.39-1.02 0-1.41l-2.34-2.34c-.39-.39-1.02-.39-1.41 0l-1.83 1.83 3.75 3.75 1.83-1.83z");
                        svg.setFill(javafx.scene.paint.Color.web("#0f68a8"));
                        svg.setScaleX(0.8);
                        svg.setScaleY(0.8);

                        btn.setGraphic(svg);
                        btn.setStyle("-fx-background-color: transparent; -fx-cursor: hand;");

                        btn.setOnAction(event -> {
                            Category category = getTableView().getItems().get(getIndex());

                            enterEditMode(category);
                        });
                    }


                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
            }
        };
        colEdit.setCellFactory(cellFactory);
    }

    private void enterEditMode(Category category) {
        this.categoryInEdition = category;

        newCategory.setText(category.name());

        btnAction.setText("ATUALIZAR");
        btnAction.setStyle("-fx-background-color: #ffc107; -fx-text-fill: black;");
    }

    private void handleDeleteAction() {
        Callback<TableColumn<Category, Void>, TableCell<Category, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Category, Void> call(final TableColumn<Category, Void> param) {
                return new TableCell<>() {

                    private final Button btn = new Button();

                    {
                        SVGPath svg = new SVGPath();
                        svg.setContent("M6 19c0 1.1.9 2 2 2h8c1.1 0 2-.9 2-2V7H6v12zM19 4h-3.5l-1-1h-5l-1 1H5v2h14V4z");
                        svg.setFill(javafx.scene.paint.Color.web("#a80f3a"));
                        svg.setScaleX(0.8);
                        svg.setScaleY(0.8);

                        btn.setGraphic(svg);
                        btn.setStyle("-fx-background-color: transparent; -fx-cursor: hand;");

                        btn.setOnAction(event -> {
                            Category category = getTableView().getItems().get(getIndex());
                            deleteCategory(category);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
            }
        };

        colDelete.setCellFactory(cellFactory);
    }

    private void deleteCategory(Category category) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Deseja realmente excluir a categoria " + category.name() + "?", ButtonType.YES, ButtonType.NO);
        if (alert.showAndWait().get() == ButtonType.YES) {
            var newService = new CategoryService();
            newService.delete(category.id());
            handleListCategoriesAction();
        }
    }

    private void configList() {
        colName.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().name()));
        colId.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().id()));
        tableCategory.setItems(observableCategoryList);
    }
}
