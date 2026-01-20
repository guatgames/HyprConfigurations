
package org.guatgames.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import org.guatgames.components.BindComponent;
import org.guatgames.objects.binds.HyprBind;
import org.guatgames.objects.binds.HyprBindInfo;
import org.guatgames.system.ConfigLoader;
import org.guatgames.system.HyprConfigReader;
import org.guatgames.system.HyprConfigWriter;
import org.guatgames.system.Loader;

/**
 *
 * @author guatgames
 */
public class HyprBindingsController implements Initializable {

    @FXML
    ScrollPane bindsContainer;

    @FXML
    Button applyButton;

    @FXML
    Pane floatingContainer, sectionContainer;

    FlowPane space = new FlowPane();

    private void reloadBinds( ArrayList<String[]> array ){
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb) {

        floatingMenu();

        space.setHgap(5);
        space.setVgap(15);

        HyprConfigReader reader = new HyprConfigReader();

        List<HyprBindInfo> bindTypeList = ConfigLoader.loadDispatchers(
                "src/org/guatgames/docs/bindTypes.json"
        );

        List<HyprBindInfo> dispatcherList = ConfigLoader.loadDispatchers(
                "src/org/guatgames/docs/dispatchers.json"
        );

        for(HyprBind i : reader.getBinds("src/org/guatgames/system/hyprland.conf")){
            BindComponent bind = new BindComponent(i.getBind(),i.getModifier(),i.getKey(),i.getDispatcher(),i.getParams());

            bind.enableAutocomplete(bindTypeList,dispatcherList);

            space.getChildren().add(bind);
        }

        bindsContainer.setContent(space);

        applyButton.setOnAction(e -> {
            HyprConfigWriter write = new HyprConfigWriter();

            write.saveBindConfig("src/org/guatgames/system/hyprland.conf", space.getChildren());
            Loader.getSingleton().alert(Alert.AlertType.CONFIRMATION,"Configuration saved",
                    "The configuration was saved correctly");
        });

    }
    
    @FXML
    public void addNewBind(){

        List<HyprBindInfo> bindTypeList = ConfigLoader.loadDispatchers(
                "src/org/guatgames/docs/bindTypes.json"
        );

        List<HyprBindInfo> dispatcherList = ConfigLoader.loadDispatchers(
                "src/org/guatgames/docs/dispatchers.json"
        );

        BindComponent bind = new BindComponent();

        bind.enableAutocomplete(bindTypeList,dispatcherList);

        space.getChildren().add(bind);

        bindsContainer.applyCss();
        bindsContainer.layout();
        bindsContainer.setVvalue(1);

    }

    public void floatingMenu(){
        floatingContainer.setTranslateX(-100);
        sectionContainer.setTranslateX(-50);

        floatingContainer.setOnMouseEntered(e -> {
            TranslateTransition transition = new TranslateTransition(Duration.millis(200),floatingContainer);
            transition.setToX(0);
            TranslateTransition transition2 = new TranslateTransition(Duration.millis(200),sectionContainer);
            transition2.setToX(0);
            transition.play();
            transition2.play();
        });

        floatingContainer.setOnMouseExited(e -> {
            TranslateTransition transition = new TranslateTransition(Duration.millis(200),floatingContainer);
            transition.setToX(-100);
            TranslateTransition transition2 = new TranslateTransition(Duration.millis(200),sectionContainer);
            transition2.setToX(-100);
            transition.play();
            transition2.play();
        });
    }
    
}
