package br.com.bank;

import br.com.bank.util.ViewLoader;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ViewLoader.loadNewWindow("/index.fxml", "/style.css", "Bank App - Menu Principal");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
