package org.guatgames.system;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author guatgames
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException, Exception {

        try {
            Loader.getSingleton().setCurrentStage(stage);
            Loader.getSingleton().newScene("../views/NOse.fxml");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
