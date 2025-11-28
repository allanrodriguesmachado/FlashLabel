package br.com.manager.pdv.util;

import java.io.IOException;
import java.util.Objects;

import br.com.manager.pdv.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ViewLoader {
    private ViewLoader() {
        throw new UnsupportedOperationException("Classe utilitária de navegação.");
    }

    public static void loadNewWindow(String fxmlPath, String cssPath, String title, Stage windowClose) throws IOException {
        Stage newStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlPath));

        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);

        scene.getStylesheets().add(
                Objects.requireNonNull(Main.class.getResource(cssPath)).toExternalForm());

        newStage.setTitle(title);
        newStage.setResizable(true);
        newStage.setScene(scene);
        newStage.setFullScreen(true);

        newStage.initStyle(StageStyle.TRANSPARENT);
        newStage.initModality(Modality.APPLICATION_MODAL);

        if (windowClose != null) {
            windowClose.close();
        }

        newStage.show();
    }

    public static void loadNewWindowModal(String fxmlPath, String cssPath, String title, Stage ownerStage) throws IOException {
        Stage modalStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlPath));

        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);

        if (cssPath != null && !cssPath.isEmpty()) {
            scene.getStylesheets().add(
                    Objects.requireNonNull(Main.class.getResource(cssPath)).toExternalForm());
        }

        modalStage.setTitle(title);
        modalStage.setScene(scene);

        // Configurações do Modal Moderno
        modalStage.initStyle(StageStyle.TRANSPARENT); // Remove a barra do Windows
        modalStage.initModality(Modality.APPLICATION_MODAL); // Bloqueia a janela de trás

        // Define quem é o "Pai" desse modal (para centralizar e bloquear)
        if (ownerStage != null) {
            modalStage.initOwner(ownerStage);
        }

        // showAndWait faz o código esperar o modal fechar antes de continuar
        modalStage.showAndWait();
    }
}
