package org.guatgames.system;

import java.io.IOException;
import java.util.List;
import javafx.application.Application;
import javafx.stage.Stage;
import org.guatgames.controllers.HyprConfigReader;
import org.guatgames.objects.HyprBind;

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

        HyprConfigReader reader = new HyprConfigReader();
        List<HyprBind> list = reader.getBinds("/home/guatgames/NetBeansProjects/HyprConffigurrations/src/org/guatgames/system/hyprland.conf");
        for(HyprBind i : list){
            System.out.println(i.getModifier() + " " + i.getKey() + " " + i.getDispatcher() + " " + i.getParams());
        }
        
        launch(args);
        
    }

}
