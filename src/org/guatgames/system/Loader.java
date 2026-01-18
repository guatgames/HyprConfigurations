package org.guatgames.system;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;

public class Loader {

    private static Loader singleton = null;
    private Stage currentStage = null;

    public static Loader getSingleton() {

        if (singleton == null) {
            singleton = new Loader();
        }

        return singleton;

    }

    public void newScene(String path) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));

        Scene sc = new Scene(loader.load());

        Stage stage = getCurrentStage();
        stage.setTitle("Escena");
        stage.setScene(sc);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();

    }

    public void newScene(String path, String title) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));

        Scene sc = new Scene(loader.load());

        Stage stage = getCurrentStage();
        stage.setTitle(title);
        stage.setScene(sc);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();

    }

    public void newScene(String path, String title, String img) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        //loader.setRoot(this);

        Scene sc = new Scene(loader.load());

        Stage stage = getCurrentStage();

        stage.setTitle(title);
        stage.getIcons().add(new Image(Loader.class.getResourceAsStream(img)));
        stage.setScene(sc);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();

    }

    public Stage getCurrentStage() {
        return currentStage;
    }

    public void setCurrentStage(Stage currentStage) {
        this.currentStage = currentStage;
    }

    public void alert(Alert.AlertType tipo, String title, String msg) {
        Alert a = new Alert(tipo);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.show();
    }
}
