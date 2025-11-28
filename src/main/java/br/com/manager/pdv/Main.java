package br.com.manager.pdv;

import br.com.manager.pdv.util.ViewLoader;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ViewLoader.loadNewWindow("/index.fxml", "/style.css", "PDV - Login", null);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
