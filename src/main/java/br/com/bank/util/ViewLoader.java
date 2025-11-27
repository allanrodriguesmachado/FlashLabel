package br.com.bank.util;

import java.io.IOException;
import java.util.Objects;

import br.com.bank.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewLoader {
    private ViewLoader() {
        throw new UnsupportedOperationException("Classe utilitária de navegação.");
    }

    public static void loadNewWindow(String fxmlPath, String cssPath, String title, Stage windowClose) throws IOException {
        Stage newStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlPath));

        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        scene.getStylesheets().add(
                Objects.requireNonNull(Main.class.getResource(cssPath)).toExternalForm());

        newStage.setTitle(title);
        newStage.setResizable(true);
        newStage.setScene(scene);

        if (windowClose != null) {
            windowClose.close();
        }

        newStage.show();
    }
}
